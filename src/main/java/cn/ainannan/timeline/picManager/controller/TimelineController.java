package cn.ainannan.timeline.picManager.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.timeline.picManager.bean.Timeline;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.bean.TimelineTongji;
import cn.ainannan.timeline.picManager.service.TimelinePicService;
import cn.ainannan.timeline.picManager.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 时光轴Controller
 * @author syy
 * @version 2018-09-26
 */
@RestController
@RequestMapping(value = "timeline")
public class TimelineController {

	@Autowired
	private TimelineService timelineService;
	@Autowired
	private TimelinePicService tpService;
	
	@RequestMapping({ "", "list" })
	public ResultObject list(Timeline timeline, 
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer size, 
			HttpServletRequest request) {
		// Pagehelper.startPage(page, size);
		List<Timeline> list = timelineService.findList(timeline);
		// PageInfo pageInfo = new PageInfo(list);
		return ResultGen.genSuccessResult();
	}
//
//	@RequestMapping("findListByTimeType")
//	public ResultObject findListByTimeType(Timeline timeline, HttpServletRequest request) {
//
//		if(StringUtils.isBlank(timeline.getTimeType()))
//			return ResultGen.genFailResult("timeType 不能为空");
//
//		List<Timeline> tList = timelineService.findListByTimeType(timeline);
//
//		for (Timeline t : tList) {
//
//			List<TimelinePic> tpList = Lists.newArrayList();
//			TimelinePic tpQuery = new TimelinePic();
//
//			if("1".equals(timeline.getTimeType())) {
//				tpQuery.setShotDateL(t.getYear());
//			} else if("2".equals(timeline.getTimeType())) {
//				tpQuery.setShotDateL(t.getMonth());
//			}
//
//			tpQuery.setLimitNum(0);
//
//			tpList = tpService.findList(tpQuery);
//
//			t.setPicList(tpList);
//			t.setTimeType(timeline.getTimeType());
//		}
//
//		return ResultGen.genSuccessResult(tList);
//	}

	@RequestMapping("get")
	public ResultObject get(Timeline timeline, HttpServletRequest request) {
		Timeline dest = timelineService.get(timeline);
		return ResultGen.genSuccessResult(dest);
	}
	

	/**
	 * 获取相似照片的集合
	 * @param tp
	 * @return
	 */
	@RequestMapping("findSimilarImgList")
	public ResultObject findSimilarImgList(TimelinePic tp, HttpServletRequest request) {
		return ResultGen.genSuccessResult(tpService.findSimilarImgList(tp));
	}

	/**
	 * 获取时光轴已筛选未筛选的
	 * @return 统计对象
	 */
	@RequestMapping("getTimelineInfo")
	public ResultObject getTimelineInfo(Timeline timeline, HttpServletRequest request) {
		TimelineTongji dest = timelineService.getTimelineInfo();
		return ResultGen.genSuccessResult(dest);
	}
	
	/**
	 * 获取所有的图片标签，并且是分类后的
	 * @param timeline
	 * @param request
	 * @return
	 */
	@RequestMapping("getAllLabel")
	public ResultObject getAllLabel(Timeline timeline, HttpServletRequest request) {
		return ResultGen.genSuccessResult(timelineService.getAllLabel());
	}
	
	@RequestMapping("save")
	public ResultObject save(Timeline timeline, HttpServletRequest request) {
		timelineService.save(timeline);
		return ResultGen.genSuccessResult(timeline);
	}
	
	@RequestMapping("saveSkip")
	public ResultObject saveSkip(Timeline timeline, HttpServletRequest request) {
		timelineService.saveSkip(timeline);
		return ResultGen.genSuccessResult(timeline);
	}

	@RequestMapping("delete")
	public ResultObject delete(Timeline timeline, HttpServletRequest request) {
		timelineService.delete(timeline);
		return ResultGen.genSuccessResult();
	}

}