package cn.ainannan.timeline.picManager.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.commons.Constant;
import cn.ainannan.commons.utils.FileUtils;
import cn.ainannan.commons.utils.ImageUtils;
import cn.ainannan.commons.utils.MD5Utils;
import cn.ainannan.commons.utils.UUIDUtils;
import cn.ainannan.commons.utils.fingerPrint.FingerPrintUtils;
import cn.ainannan.sys.utils.ImageUtil;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;
import com.google.common.collect.Lists;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ImportPicService extends BaseService<TimelinePicMapper, TimelinePic>{

	@Value("${myPic-basePath}")
	private String BASE_PATH;
	@Value("${myPanfu}")
	private String BASE_PANFU;
	
	private static final int MAX_ADD_PIC_NUM = 150;
	
	public String addPic() throws IOException {
		int addNum = 0; // 新增图片计数器
		// 获取未筛选文件夹中的图片
		List<String> fileList = getFileList();
		List<TimelinePic> tpList = Lists.newArrayList();
		// 遍历操作
		for (String sourceStr : fileList) {
			File sourceFile = new File(sourceStr);
			
			// 获取拍摄日期，如果没有的话，则根据文件名进行解析拍摄日期
			Date d = ImageUtils.getOriginalDate(sourceStr);
			if(d == null) d = this.executeShotDate(sourceFile.getName());
			
			/*
			 * 思路分析
			 * 1. 如果日期不为空，则取年度，如果年度 是2011及以前，那么父目录就是2011及以前，其它的则按年度做父目录
			 * 2. 如果日期为空，则放到未知年份里
			 * 3. 生成文件路径，查询该路径有同名文件没有，如果有，则跳过，如果没有，则移动
			 * 4. 生成缩略图，
			 * 5. 保存数据库
			 */
						
			String prePath = null;
			
			if(d != null) {
				Calendar c = Calendar.getInstance();
				c.setTime(d);
				int year = c.get(Calendar.YEAR);
				if(year <= 2011) prePath = "2011及以前";
				else prePath = String.valueOf(year);
			} else {
				prePath = "20未知年份";
			}
			
			// 生成目标文件路径
			String rootPath = sourceStr.replace(BASE_PANFU + BASE_PATH + Constant.TIMELINE_PIC_WEISHAIXUAN, "");
			String targetPath = BASE_PANFU + BASE_PATH + prePath + rootPath;
			String targetThumbnailPath = BASE_PANFU + BASE_PATH + Constant.IMG_THUMBNAIL_ROOT_SRC + prePath + rootPath;
			
			File targetFile = new File(targetPath);
			// 如果文件已经存在 ，则跳过
			if(targetFile.exists()) continue;
			
			// 移动文件
			try {
				org.apache.commons.io.FileUtils.moveFile(sourceFile, targetFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// 生成缩略图
			ImageUtil.genThumbnail(targetPath, targetThumbnailPath);
			
			// 生成类，放入List
			TimelinePic tp = getTimelinePic(targetPath);
			
			// 如果不为空，则预新增
			if(tp != null) {
				tp.setSrcThumbnail(Constant.IMG_THUMBNAIL_ROOT_SRC + prePath + rootPath);
				
				if(tp.getShotDate() == null) {
					tp.setShotDate(this.executeShotDate(sourceFile.getName()));
				}
				
				tp.setSimilarStatus(0);
				tp.preInsert();
				tpList.add(tp);
				
				System.out.println("已添加 " + tpList.size() + " 张照片。");
				
				// 最大新增数
				if(++addNum >= MAX_ADD_PIC_NUM) break;
			}
			
		}// 退出for file list循环
		
		if(tpList.size() > 0) {
			dao.insertByList(tpList);
		}
		// 保存list
		int shengyu = fileList.size() - addNum < 0 ? 0 : fileList.size() - addNum;
		return "本次新增了 " + addNum + " 条，还剩 " + shengyu + " 条未处理。" ;
	}

	
	/**
	 * 获取指定文件夹下的图片名称集合
	 * @return
	 */
	private List<String> getFileList() {
		List<String> fileList = Lists.newArrayList();
		FileUtils.addList(BASE_PANFU + BASE_PATH + Constant.TIMELINE_PIC_WEISHAIXUAN, fileList);
		return fileList;
	}

	/**
	 * 根据文件名解析拍摄日期
	 * 
	 * @param str
	 * @return
	 */
	public Date executeShotDate(String str) {
		Date newDate = null;
		String guessTime = null;

		if (str.indexOf("WuTa_") == 0 && str.length() > 19) {
			String subStrO = str.substring(5, 24);

			String[] arr = subStrO.split("_");
			String date = arr[0];
			String time = arr[1].replace("-", ":");

			guessTime = date + " " + time;

		}

		if (str.indexOf("MYXJ_") == 0 && str.length() > 14) {
			String subStr = substr(str, 5, 14);

			guessTime = substr(subStr, 0, 4) + "-" + substr(subStr, 4, 2) + "-" + substr(subStr, 6, 2) + " "
					+ substr(subStr, 8, 2) + ":" + substr(subStr, 10, 2) + ":" + substr(subStr, 12, 2);
		}

		if (str.indexOf("faceu_") == 0 && str.length() > 14) {
			String subStr = substr(str, 6, 14);

			guessTime = substr(subStr, 0, 4) + "-" + substr(subStr, 4, 2) + "-" + substr(subStr, 6, 2) + " "
					+ substr(subStr, 8, 2) + ":" + substr(subStr, 10, 2) + ":" + substr(subStr, 12, 2);
		}

		if (str.indexOf("微信图片_") == 0 && str.length() > 14) {
			String subStr = substr(str, 5, 14);

			guessTime = substr(subStr, 0, 4) + "-" + substr(subStr, 4, 2) + "-" + substr(subStr, 6, 2) + " "
					+ substr(subStr, 8, 2) + ":" + substr(subStr, 10, 2) + ":" + substr(subStr, 12, 2);
		}

		if (str.indexOf("QQ图片") == 0 && str.length() > 14) {
			String subStr = substr(str, 4, 14);

			guessTime = substr(subStr, 0, 4) + "-" + substr(subStr, 4, 2) + "-" + substr(subStr, 6, 2) + " "
					+ substr(subStr, 8, 2) + ":" + substr(subStr, 10, 2) + ":" + substr(subStr, 12, 2);
		}

		if (str.indexOf("IMG_") == 0 && str.length() > 15) {
			String subStr = substr(str, 4, 15);
			String[] arr = subStr.split("_");

			String dateStr = substr(arr[0], 0, 4) + "-" + substr(arr[0], 4, 2) + "-" + substr(arr[0], 6, 2);
			String timeStr = substr(arr[1], 0, 2) + ":" + substr(arr[1], 2, 2) + ":" + substr(arr[1], 4, 2);

			guessTime = dateStr + " " + timeStr;

		}

		if (str.indexOf("P") == 0 && str.length() > 13) {
			// 2016\P61006-110001-001.jpg

			String dateStr = "201" + substr(str, 1, 1) + "-" + substr(str, 2, 2) + "-" + substr(str, 4, 2);

			String timeStr = substr(str, 7, 2) + ":" + substr(str, 9, 2) + ":" + substr(str, 11, 2);

			guessTime = dateStr + " " + timeStr;

		}

		if (str.indexOf("B612咔叽_") == 0 && str.length() > 20) {
			String subStr = substr(str, 7, 15);

			String[] arr = subStr.split("_");

			String dateStr = substr(arr[0], 0, 4) + "-" + substr(arr[0], 4, 2) + "-" + substr(arr[0], 6, 2);
			String timeStr = substr(arr[1], 0, 2) + ":" + substr(arr[1], 2, 2) + ":" + substr(arr[1], 4, 2);

			guessTime = dateStr + " " + timeStr;
		}

		if (str.indexOf("B612Kaji_") == 0 && str.length() > 20) {
			// B612Kaji_20180603_231306_600.jpg
			String subStr = substr(str, 9, 15);
			String[] arr = subStr.split("_");

			String dateStr = substr(arr[0], 0, 4) + "-" + substr(arr[0], 4, 2) + "-" + substr(arr[0], 6, 2);
			String timeStr = substr(arr[1], 0, 2) + ":" + substr(arr[1], 2, 2) + ":" + substr(arr[1], 4, 2);

			guessTime = dateStr + " " + timeStr;

		}

		if (str.indexOf("mmexport") == 0 && str.length() > 20) {
			// mmexport1500993758999.jpg
			String subStr = substr(str, 8, 13);

			guessTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.parseLong(subStr)));

		}
		// wx_camera_1500028140900.jpg
		if (str.indexOf("wx_camera_") == 0 && str.length() > 20) {
			// mmexport1500993758999.jpg
			String subStr = substr(str, 10, 13);

			guessTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.parseLong(subStr)));

		}
		// 2014-05-18 125400.jpg
		if (findDate("^\\d{4}-\\d{2}-\\d{2}\\s\\d{6}", str)) {
			String subStr = substr(str, 0, 17);
			guessTime = substr(subStr, 0, 13) + ":" + substr(subStr, 13, 2) + ":" + substr(subStr, 15, 2);
		}
		// 2014_01_15_09_53_29.jpg
		if (findDate("^\\d{4}_\\d{2}_\\d{2}_\\d{2}_\\d{2}_\\d{2}", str)) {
			String[] subStr = str.split("_");

			guessTime = subStr[0] + "-" + subStr[1] + "-" + subStr[2] + " " + subStr[3] + ":" + subStr[4] + ":"
					+ substr(subStr[5], 0, 2);
		}
		// 20120415.jpg
		if (findDate("^\\d{8}\\.", str)) {
			guessTime = substr(str, 0, 4) + "-" + substr(str, 4, 2) + "-" + substr(str, 6, 2) + " 00:00:00";

		}

		// 如果日期字符串不为空，表示命中了规则并生成了字符串，进行转换
		if (guessTime != null && !"".equals(guessTime)) {
			try {
				newDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(guessTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return newDate;
	}

	/**
	 * 截取字符串，
	 * 
	 * @param str
	 *            原字符串
	 * @param begin
	 *            开始位置
	 * @param length
	 *            截取长度
	 * @return
	 */
	private String substr(String str, int begin, int length) {
		try {

			return str.substring(begin, begin + length);
		} catch (Exception e) {
			System.out.println("str:\t" + str);
			System.out.println("begin:\t" + begin);
			System.out.println("length:\t" + length);
		}

		return null;

	}

	/**
	 * 匹配指定格式，如果包含则返回true
	 * 
	 * @param str
	 * @return
	 */
	private boolean findDate(String input, String str) {

		Pattern p = Pattern.compile(input);
		Matcher m = p.matcher(str);

		return m.find();
	}
	
	/**
	 * 根据文件路径新建一个timelinePic对象，填充基本信息。
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException 
	 */
	public TimelinePic getTimelinePic(String filePath) throws IOException {

		File file = new File(filePath);
		if (!file.exists())
			return null;

		TimelinePic tp = new TimelinePic();

		tp.setShortId(UUIDUtils.generateShortUuid());
		tp.setFilename(FilenameUtils.getName(filePath));
		tp.setPath(FilenameUtils.getFullPath(filePath));
		tp.setSrc(filePath.replace(BASE_PANFU + BASE_PATH, ""));
		tp.setSuffix(FilenameUtils.getExtension(filePath));
		tp.setSize(file.length());
		tp.setMD5(MD5Utils.getFileMD5(file));
		tp.setFingerPrint(FingerPrintUtils.produceFingerPrint(filePath));
		tp.setShotDate(ImageUtils.getOriginalDate(filePath));
		tp.setState(Constant.TIMELINE_PIC_STATE_0);

		return tp;
	}	

}
