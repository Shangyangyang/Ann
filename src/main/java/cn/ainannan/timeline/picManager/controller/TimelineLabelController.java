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
import cn.ainannan.timeline.picManager.bean.TimelineLabel;
import cn.ainannan.timeline.picManager.service.TimelineLabelService;

/**
 * 时光轴Controller
 * @author syy
 * @version 2018-09-26
 */
@RestController
@RequestMapping(value = "timeline/label")
public class TimelineLabelController {

	@Autowired
	private TimelineLabelService tlService;
	
	@RequestMapping({ "", "list" })
	public ResultObject list(TimelineLabel timelineLabel, 
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer size, 
			HttpServletRequest request) {
		
		PageHelper.startPage(page, size);
		List<TimelineLabel> list = tlService.findList(timelineLabel);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGen.genSuccessResult(pageInfo);
	}
	
	/**
	 * 更新标签，临时功能，现已关闭。
	 * @param timelineLabel
	 * @param request
	 * @return
	 */
	@RequestMapping("updateLabel")
	public ResultObject updateLabel(TimelineLabel timelineLabel, HttpServletRequest request) {
		// tlService.updateLabel();
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("save")
	public ResultObject save(TimelineLabel timelineLabel, HttpServletRequest request) {
		tlService.save(timelineLabel);
		return ResultGen.genSuccessResult(timelineLabel);
	}
	
	@RequestMapping("delete")
	public ResultObject delete(TimelineLabel timelineLabel, HttpServletRequest request) {
		tlService.delete(timelineLabel);
		return ResultGen.genSuccessResult(timelineLabel);
	}

	
}