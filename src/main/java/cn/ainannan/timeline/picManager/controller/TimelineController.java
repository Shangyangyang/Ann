package cn.ainannan.timeline.picManager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.timeline.picManager.bean.Timeline;
import cn.ainannan.timeline.picManager.service.TimelineService;

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
	
	@RequestMapping({ "", "list" })
	public ResultObject list(Timeline timeline, 
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer size, 
			HttpServletRequest request) {
		System.out.println("执行");
		PageHelper.startPage(page, size);
		List<Timeline> list = timelineService.findList(timeline);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGen.genSuccessResult(pageInfo);
	}

	@RequestMapping("get")
	public ResultObject get(Timeline timeline, HttpServletRequest request) {
		Timeline dest = timelineService.get(timeline);
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