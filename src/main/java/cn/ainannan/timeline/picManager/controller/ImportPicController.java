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
		
		int i = 0;
		
		for(String str : fileList) {
			// System.out.println(FilenameUtils.getFullPath(str));
			
			// 先去数据库查询对比是否已经添加
			timelinePic.setFilename(FilenameUtils.getName(str));
			timelinePic.setPath(FilenameUtils.getFullPath(str));
			List<TimelinePic> resultList = timelinePicService.findList(timelinePic);
			
			// 数据库中已经存在同路径同名的文件
			if(resultList.size() > 0) continue;
			
			// 增加到数据库的操作
			timelinePicService.save(getTimelinePic(str));
			System.out.println(++i);
		}
		
		
		return ResultGen.genSuccessResult("共添加了 " + i);
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
