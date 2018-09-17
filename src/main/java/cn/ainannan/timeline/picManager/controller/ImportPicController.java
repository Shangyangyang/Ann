package cn.ainannan.timeline.picManager.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import cn.ainannan.commons.utils.ImageUtils;
import cn.ainannan.commons.utils.MD5Utils;
import cn.ainannan.commons.utils.UuidUtils;
import cn.ainannan.commons.utils.fingerPrint.FingerPrintUtils;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.service.TimelinePicService;

@RestController
@RequestMapping("timeline/importPic")
public class ImportPicController {
	
	@Value("${myPic-basePath}")
	private String basePath;
	
	@Autowired
	private TimelinePicService timelinePicService;
	
	public static Integer percent = 0;	// 图片新增进度统计
	
	/**
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("skipByTpList")
	public ResultObject skipByIds(String tpList){
		
		if(tpList == null || "".equals(tpList.trim())) return this.getEqualFingerPrint();
		
		List<TimelinePic> tps = Lists.newArrayList();
		
		String [] objs = tpList.split(";");
		for (int i = 0; i < objs.length; i++) {
			
			String [] obj = objs[i].split(",");
			TimelinePic tp = new TimelinePic();
			
			tp.setId(obj[0]);
			tp.setShortId(obj[1]);
			tp.setSimilarId("null".equals(obj[2]) ? "" : obj[2]);	// 先判断一下是不是为空
			
			tps.add(tp);
		}
		
		// 循环判断
		int size = tps.size();
		for (int i = 0; i < size; i++) {
			
			TimelinePic tpI = tps.get(i);
			
			for (int j = i + 1; j < size; j++) {
				TimelinePic tpJ = tps.get(j);
				
				// 如果双方的similarId都不包含对方，则互相添加
				if(tpJ.getSimilarId() == null || "".equals(tpJ.getSimilarId()) 
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
	 * 获取相同文件指纹的记录
	 * @return
	 */
	@RequestMapping("getEqualFingerPrint")
	public ResultObject getEqualFingerPrint(){
		List<TimelinePic> tpList = timelinePicService.getEqualFingerPrint();
		
		// List为空则是没有可去重的记录了
		if(tpList.size() == 0) {
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
				if(tpJ.getFingerPrint().equals(tpI.getFingerPrint())) {
					// 查找如果类似ID集中有I的ID，则删除该记录
//					if(null != tpJ.getSimilarId() && !"".equals(tpJ.getSimilarId()) 
//							&& tpJ.getSimilarId().indexOf(tpI.getShortId()) > -1) {
//						tpList.remove(j);
//					}
					
					//查找如果类似ID集中有I的ID
					if(tpJ.getSimilarId() == null || "".equals(tpJ.getSimilarId()) 
							|| tpJ.getSimilarId().indexOf(tpI.getShortId()) == -1) {
						
						resultList.add(tpJ);
					}
				}
			}
			
			// 判断如果List的长度大于2，则代表有重复内容需要判断，则返回。
			if(resultList.size() > 1) {
				return ResultGen.genSuccessResult(resultList);
			}
			
		}// for i 循环结束
		
		return ResultGen.genFailResult("99");
	}
	
	/**
	 * 删除数据库记录以及物理文件
	 * @param tp
	 * @return
	 */
	@RequestMapping("delete")
	public ResultObject delete(TimelinePic tp) {
		// 先删除物理文件，先获取前端传递过来的path，如果为空，则通过Id获取数据库里的记录
		if(tp.getPath() == null || "".equals(tp.getPath())) {
			if(tp.getId() != null && !"".equals(tp.getId())) {
				TimelinePic result = timelinePicService.get(tp.getId());
				tp.setPath(result.getPath() + result.getFilename());
			}else {
				return ResultGen.genFailResult("缺少参数，删除失败。");
			}
		}
		
		// 删除物理文件
		File file = new File(tp.getPath());
		
		if(file.exists()) {
			while(!file.delete()){
				System.gc();    //回收资源
			}
		}
		
		timelinePicService.delete(tp);
		return ResultGen.genSuccessResult();
	}
	
	/**
	 * 获取相同MD5的数据
	 * @return
	 */
	@RequestMapping("getEqualMd5")
	public ResultObject getEqualMd5(){
		List<TimelinePic> tpList = timelinePicService.getEqualMd5();
		// List为空则是没有可去重的记录了
		if(tpList.size() == 0) {
			return ResultGen.genFailResult("99");
		}
		return ResultGen.genSuccessResult(tpList);
	}
	
	/**
	 * 获取图片库最近状态
	 * @param timelinePic
	 * @param request
	 * @return
	 */
	@RequestMapping("getLastStatus")
	public ResultObject getLastStatus(TimelinePic timelinePic, HttpServletRequest request) {
		timelinePic = timelinePicService.getLastStatus();
		return ResultGen.genSuccessResult(timelinePic);
	}
	
	@RequestMapping({"","list"})
	public ResultObject list(TimelinePic timelinePic, @RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size);
		List<TimelinePic> resultList = timelinePicService.findList(timelinePic);
		PageInfo pageInfo = new PageInfo(resultList);
		return ResultGen.genSuccessResult(pageInfo);
	}
	
	/**
	 * 添加照片到数据中
	 * @param timelinePic
	 * @return
	 */
	@RequestMapping("addPic")
	public ResultObject addPic(TimelinePic timelinePic) {
		int addNum = 0; // 新增图片计数器
		List<String> fileList = getFileList();
		
		int i = 0;	// 进度统计-当前进度
		
		for(String str : fileList) {
			// 先去数据库查询对比是否已经添加
			timelinePic.setFilename(FilenameUtils.getName(str));
			timelinePic.setPath(FilenameUtils.getFullPath(str));
			List<TimelinePic> resultList = timelinePicService.findList(timelinePic);
			// 进度统计
			percent = (int) ((double)++i / (double)fileList.size() * 100);
			// 数据库中已经存在同路径同名的文件
			if(resultList.size() > 0) continue;
			
			// 增加到数据库的操作
			timelinePicService.save(getTimelinePic(str));
			
			addNum++; 	// 新增图片数据增加
			
		}
		
		percent = 0;
		
		return ResultGen.genSuccessResult("新增完成，本次共添加了 " + addNum + " 张照片！");
	}
	
	/**
	 * 获得添加进度情况
	 * @return
	 */
	@RequestMapping("getPercent")
	public ResultObject getPercent() {
		return ResultGen.genSuccessResult(percent);
	}
	
	/**
	 * 清除掉：数据库中有而文件系统中没有的照片
	 * @param timelinePic
	 * @return
	 */
	@RequestMapping("cleanDatabase")
	public ResultObject cleanDatabase(TimelinePic timelinePic) {
		List<TimelinePic> resultList = timelinePicService.findList(timelinePic);
		int i = 0;	// 进度统计-当前进度
		int deleteNum = 0;
		double size = (double)resultList.size();
		for (TimelinePic tp : resultList) {
			// 进度统计
			percent = (int) ((double)++i / size * 100);
			
			if(!new File(tp.getPath() + tp.getFilename()).exists()) {
				timelinePicService.delete(tp);
				deleteNum++;
			}
		}
		
		return ResultGen.genSuccessResult("共清除了  " + deleteNum + "  条。");
	}
	
	// ==================================== 私有函数区   =========================================
	
	/**
	 * 根据文件路径新建一个timelinePic对象，填充基本信息。
	 * @param filePath
	 * @return
	 */
	private TimelinePic getTimelinePic(String filePath) {
		
		File file = new File(filePath);
		if(!file.exists()) return null;
		
		TimelinePic tp = new TimelinePic();
		
		tp.setShortId(UuidUtils.generateShortUuid());
		tp.setFilename(FilenameUtils.getName(filePath));
		tp.setPath(FilenameUtils.getFullPath(filePath));
		tp.setSrc(filePath.replace(basePath, ""));
		tp.setSuffix(FilenameUtils.getExtension(filePath));
		tp.setSize(file.length());
		tp.setMD5(MD5Utils.getFileMD5(file));
		tp.setFingerPrint(FingerPrintUtils.produceFingerPrint(filePath));
		tp.setShotDate(ImageUtils.getOriginalDate(filePath));
		tp.setState(Constant.TIMELINE_PIC_STATE_0);
		
		return tp;
	}
	
	
	/**
	 * 获取图片列表
	 * @return
	 */
	private List<String> getFileList(){
		List<String> fileList = Lists.newArrayList();
		
		for(int i = 0; i < Constant.picFiles.length; i++) {
			FileUtils.addList(basePath + Constant.picFiles[i], fileList);
		}
		
		return fileList;
	}
	
}
