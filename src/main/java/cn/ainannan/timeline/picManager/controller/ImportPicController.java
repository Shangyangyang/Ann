package cn.ainannan.timeline.picManager.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.Constant;
import cn.ainannan.commons.utils.FileUtils;
import cn.ainannan.sys.utils.ImageUtil;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.service.ImportPicService;
import cn.ainannan.timeline.picManager.service.TimelinePicService;

@RestController
@RequestMapping("timeline/importPic")
public class ImportPicController {

	@Value("${myPic-basePath}")
	private String basePath;
	
	@Autowired
	private TimelinePicService timelinePicService;
	@Autowired
	private ImportPicService importPicService;

	public static Integer percent = 0; // 图片新增进度统计

	@RequestMapping("getSimilarImgList")
	public ResultObject getSimilarImgList(TimelinePic timelinePic) {
		
		List<TimelinePic> list = timelinePicService.getSimilarImgList(timelinePic);
		
		return ResultGen.genSuccessResult(list); 
	}
	
	@RequestMapping("getTest")
	public ResultObject getTest(TimelinePic timelinePic) {
		
		TimelinePic list = timelinePicService.get(timelinePic);
		
		return ResultGen.genSuccessResult(list); 
	}
	
	@RequestMapping({ "", "list" })
	public ResultObject list(TimelinePic timelinePic, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size);
		List<TimelinePic> resultList = timelinePicService.findList(timelinePic);
		PageInfo pageInfo = new PageInfo(resultList);
		return ResultGen.genSuccessResult(pageInfo);
	}

	/**
	 * 获取还没有填充拍摄日期的图片记录
	 * 
	 * @param tpList
	 * @return
	 */
	@RequestMapping("getShotDateIsnull")
	public ResultObject getShotDateIsnull(String tpList) {
		TimelinePic tp = timelinePicService.getShotDateIsnull();

		if (tp == null)
			return ResultGen.genFailResult("99");

		return ResultGen.genSuccessResult(tp);
	}

	/**
	 * 获取相同文件指纹的记录
	 * 
	 * @return
	 */
	@RequestMapping("getEqualFingerPrint")
	public ResultObject getEqualFingerPrint() {
		List<TimelinePic> tpList = timelinePicService.getEqualFingerPrint();

		// List为空则是没有可去重的记录了
		if (tpList.size() == 0) {
			return ResultGen.genFailResult("99");
		}

		List<TimelinePic> resultList = null;

		for (int i = 0; i < tpList.size(); i++) {

			resultList = Lists.newArrayList();
			TimelinePic tpI = tpList.get(i);
			resultList.add(tpI);

			for (int j = i + 1; j < tpList.size(); j++) {

				TimelinePic tpJ = tpList.get(j);

				// 如果是相同文件指纹的情况下
				if (tpJ.getFingerPrint().equals(tpI.getFingerPrint())) {
					// 查找如果类似ID集中有I的ID，则删除该记录
					// if(null != tpJ.getSimilarId() && !"".equals(tpJ.getSimilarId())
					// && tpJ.getSimilarId().indexOf(tpI.getShortId()) > -1) {
					// tpList.remove(j);
					// }

					// 查找如果类似ID集中有I的ID
					if (tpJ.getSimilarId() == null || "".equals(tpJ.getSimilarId())
							|| tpJ.getSimilarId().indexOf(tpI.getShortId()) == -1) {

						resultList.add(tpJ);
					}
				}
			}

			// 判断如果List的长度大于2，则代表有重复内容需要判断，则返回。
			if (resultList.size() > 1) {
				return ResultGen.genSuccessResult(resultList);
			}

		} // for i 循环结束

		return ResultGen.genFailResult("99");
	}

	/**
	 * 获取相同MD5的数据
	 * 
	 * @return
	 */
	@RequestMapping("getEqualMd5")
	public ResultObject getEqualMd5() {
		List<TimelinePic> tpList = timelinePicService.getEqualMd5();
		// List为空则是没有可去重的记录了
		if (tpList.size() == 0) {
			return ResultGen.genFailResult("99");
		}
		return ResultGen.genSuccessResult(tpList);
	}

	/**
	 * 获取图片库最近状态
	 * 
	 * @param timelinePic
	 * @param request
	 * @return
	 */
	@RequestMapping("getLastStatus")
	public ResultObject getLastStatus(TimelinePic timelinePic, HttpServletRequest request) {
		timelinePic = timelinePicService.getLastStatus();
		return ResultGen.genSuccessResult(timelinePic);
	}

	/**
	 * 获得添加进度情况
	 * 
	 * @return
	 */
	@RequestMapping("getPercent")
	public ResultObject getPercent() {
		return ResultGen.genSuccessResult(percent);
	}

	/**
	 * 通过添加照片到数据中
	 * 
	 * @param timelinePic
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("addPic")
	public ResultObject addPic(TimelinePic timelinePic) throws IOException {
		String count = importPicService.addPic();
		return ResultGen.genSuccessResult(count);
	}
	
	@RequestMapping("addPic2")
	public ResultObject addPic2(TimelinePic timelinePic) throws IOException {
		int addNum = 0; // 新增图片计数器
		List<String> fileList = getFileList();
		
		int i = 0; // 进度统计-当前进度
		
		for (String str : fileList) {
			// 先去数据库查询对比是否已经添加
			timelinePic.setFilename(FilenameUtils.getName(str));
			timelinePic.setPath(FilenameUtils.getFullPath(str));
			List<TimelinePic> resultList = timelinePicService.findList(timelinePic);
			// 进度统计
			percent = (int) ((double) ++i / (double) fileList.size() * 100);
			// 数据库中已经存在同路径同名的文件
			if (resultList.size() > 0)
				continue;
			
			// 增加到数据库的操作
			timelinePicService.save(importPicService.getTimelinePic(str));
			
			addNum++; // 新增图片数据增加
			
		}
		
		percent = 0;
		
		return ResultGen.genSuccessResult("新增完成，本次共添加了 " + addNum + " 张照片！");
	}

	/**
	 * 保存数据，有ID为修改、没有ID为新增。
	 * 
	 * @param timelinePic
	 * @return
	 */
	@RequestMapping("save")
	public ResultObject save(TimelinePic timelinePic) {
		timelinePicService.save(timelinePic);
		return ResultGen.genSuccessResult();
	}

	/**
	 * 跳过这一组图片，并且把它们的shortId保存在对方的similarId中。
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("skipByTpList")
	public ResultObject skipByIds(String tpList) {

		if (tpList == null || "".equals(tpList.trim()))
			return this.getEqualFingerPrint();

		List<TimelinePic> tps = Lists.newArrayList();

		String[] objs = tpList.split(";");
		for (int i = 0; i < objs.length; i++) {

			String[] obj = objs[i].split(",");
			TimelinePic tp = new TimelinePic();

			tp.setId(obj[0]);
			tp.setShortId(obj[1]);
			tp.setSimilarId("null".equals(obj[2]) ? "" : obj[2]); // 先判断一下是不是为空

			tps.add(tp);
		}

		// 循环判断
		int size = tps.size();
		for (int i = 0; i < size; i++) {

			TimelinePic tpI = tps.get(i);

			for (int j = i + 1; j < size; j++) {
				TimelinePic tpJ = tps.get(j);

				// 如果双方的similarId都不包含对方，则互相添加
				if (tpJ.getSimilarId() == null || "".equals(tpJ.getSimilarId())
						|| tpJ.getSimilarId().indexOf(tpI.getShortId()) == -1) {

					tpI.setSimilarId(tpI.getSimilarId() + tpJ.getShortId() + ",");
					tpJ.setSimilarId(tpJ.getSimilarId() + tpI.getShortId() + ",");
				}
			}
		}

		// 循环保存
		for (TimelinePic tp : tps) {
			timelinePicService.save(tp);
		}

		return this.getEqualFingerPrint();
	}
	
	/**
	 * 生成缩略库并保存到相应的路径去
	 * 运行一次生成1000张
	 */
	// @Scheduled(cron = "0 */2 * * * ?")
	@RequestMapping("genThumbnail")
	public ResultObject genThumbnail(TimelinePic tp) {
		
		while (true) {

			tp.setLimitNum(500);
			// srcThumbnail为空的
			tp.setThumbnailFlag("0");
			List<TimelinePic> tpList = timelinePicService.findListFor1000(tp);
			
			int totalNum = tpList.size();
			
			if(totalNum == 0) break;
			
			List<TimelinePic> saveList = Lists.newArrayList();
			
			for (TimelinePic t : tpList) {
				
				System.out.println(totalNum--);
				// 组装源地址与目标地址
				String sourcePath = t.getPath() + t.getFilename();
				String targetPath = basePath + Constant.IMG_THUMBNAIL_ROOT_SRC + t.getSrc();
				String targetPath2 = Constant.IMG_THUMBNAIL_ROOT_SRC + t.getSrc();
				
				// 判断目标在不在，不在的话先创建
				File file = new File(new File(targetPath).getParent());
				if(!file.exists()) {
					file.mkdirs();
				}
				
				// 先降低图片质量
				try {
					ImageUtil.compressPictureByQality(new File(sourcePath), new File(targetPath), 0.3F);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// 再缩小图片
				ImageUtil.operateByMaxSize(targetPath, targetPath, Constant.IMG_THUMBNAIL_SIZE, Constant.IMG_THUMBNAIL_SIZE);
				
				TimelinePic saveT = new TimelinePic();
				saveT.setId(t.getId());
				saveT.setSrcThumbnail(targetPath2);
				
				saveList.add(saveT);
			}
			
			TimelinePic savePic = new TimelinePic();
			savePic.setPicList(saveList);
			timelinePicService.saveByList(savePic);
			
		}
		
		return ResultGen.genSuccessResult("");
		
	}
	

	/**
	 * 删除数据库记录以及物理文件
	 * 
	 * @param tp
	 * @return
	 */
	@RequestMapping("delete")
	public ResultObject delete(TimelinePic tp) {
		// 先删除物理文件，先获取前端传递过来的path，如果为空，则通过Id获取数据库里的记录
		if (StringUtils.isBlank(tp.getPath())) {
			if (StringUtils.isNotBlank(tp.getId())) {
				TimelinePic result = timelinePicService.get(tp.getId());
				tp.setPath(result.getPath() + result.getFilename());
			} else {
				return ResultGen.genFailResult("缺少参数，删除失败。");
			}
		}
		
		String thumbnailSrc = "H:\\尚羊羊\\图片\\个人相册" + "\\thumbnail" + tp.getPath().replace("H:\\尚羊羊\\图片\\个人相册", "");
		System.out.println(thumbnailSrc);
		
		// 删除物理文件
		File file = new File(tp.getPath());
		File thumbnailFile = new File(thumbnailSrc);

		if (file.exists()) {
			while (!file.delete()) {
				System.gc(); // 回收资源
			}
		}
		if (thumbnailFile.exists()) {
			while (!thumbnailFile.delete()) {
				System.gc(); // 回收资源
			}
		}

		timelinePicService.delete(tp);
		return ResultGen.genSuccessResult();
	}

	/**
	 * 清除掉：数据库中有而文件系统中没有的照片
	 * 
	 * @param timelinePic
	 * @return
	 */
	@RequestMapping("cleanDatabase")
	public ResultObject cleanDatabase(TimelinePic timelinePic) {
		List<TimelinePic> resultList = timelinePicService.findList(timelinePic);
		int i = 0; // 进度统计-当前进度
		int deleteNum = 0;
		double size = (double) resultList.size();
		for (TimelinePic tp : resultList) {
			// 进度统计
			percent = (int) ((double) ++i / size * 100);

			if (!new File(tp.getPath() + tp.getFilename()).exists()) {
				timelinePicService.delete(tp);
				deleteNum++;
			}
		}

		return ResultGen.genSuccessResult("共清除了  " + deleteNum + "  条。");
	}

	// ==================================== 私有函数区
	// =========================================

	/**
	 * 后台计算拍摄日期并填充回数据库
	 * 
	 * @return
	 */
	@RequestMapping("executeShotDate")
	public ResultObject executeShotDate() {
		List<TimelinePic> tpList = timelinePicService.getAllShotDateIsnull();
		int count = 0;

		for (TimelinePic tp : tpList) {
			Date d = importPicService.executeShotDate(tp.getFilename());
			if (d != null) {

				count++;

				TimelinePic t = new TimelinePic();
				t.setId(tp.getId());
				t.setShotDate(d);

				timelinePicService.save(t);
			}

		}

		return ResultGen.genSuccessResult("本次后台共计算了 " + count + " 条记录。");
	}
	
	
	

	/**
	 * 获取图片列表
	 * 
	 * @return
	 */
	private List<String> getFileList() {
		List<String> fileList = Lists.newArrayList();
		
		for (int i = 0; i < Constant.picFiles.length; i++) {
			FileUtils.addList(basePath + Constant.picFiles[i], fileList);
		}
		
		return fileList;
	}

}
