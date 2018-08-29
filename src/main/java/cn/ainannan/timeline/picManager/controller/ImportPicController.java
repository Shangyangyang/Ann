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
	
	
	public static Integer addPercent = 0;	// 图片新增进度统计
	public static Integer addNum = 0;		// 新增图片数量
	
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

		List<String> fileList = getFileList();
		
		int i = 0;	// 进度统计-当前进度
		
		for(String str : fileList) {
			// 先去数据库查询对比是否已经添加
			timelinePic.setFilename(FilenameUtils.getName(str));
			timelinePic.setPath(FilenameUtils.getFullPath(str));
			List<TimelinePic> resultList = timelinePicService.findList(timelinePic);
			// 进度统计
			addPercent = (int) ((double)++i / (double)fileList.size() * 100);
			// 数据库中已经存在同路径同名的文件
			if(resultList.size() > 0) continue;
			
			// 增加到数据库的操作
			timelinePicService.save(getTimelinePic(str));
			
			addNum++; 	// 新增图片数据增加
			
		}
		
		return ResultGen.genSuccessResult();
	}
	
	/**
	 * 获得添加进度情况
	 * @return
	 */
	@RequestMapping("getAddPercent")
	public ResultObject getAddPercent() {
		return ResultGen.genSuccessResult(addPercent);
	}
	
	/**
	 * 获取新增图片数量
	 * @return
	 */
	@RequestMapping("getAddNum")
	public ResultObject getAddNum() {
		return ResultGen.genSuccessResult(addNum);
	}
	
	/**
	 * 将进度值与新增数量清空
	 * @return
	 */
	@RequestMapping("clearAddPercentAndNum")
	public ResultObject clearAddPercentAndNum() {
		addPercent = addNum = 0;
		return ResultGen.genSuccessResult();
	}
	
	
	
	/**
	 * 清除掉：数据库中有而文件系统中没有的照片
	 * @param timelinePic
	 * @return
	 */
	@RequestMapping("clean")
	public ResultObject clean(TimelinePic timelinePic) {
		List<TimelinePic> resultList = timelinePicService.findList(timelinePic);
		int i = 0;
		for (TimelinePic tp : resultList) {
			if(!new File(tp.getPath() + tp.getFilename()).exists()) {
				timelinePicService.delete(tp);
				i++;
			}
		}
		
		return ResultGen.genSuccessResult("共清除了  " + i + "  条。");
	}
	
	
	
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
