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
import cn.ainannan.timeline.picManager.bean.TimelineLabel;
import cn.ainannan.timeline.picManager.bean.TimelineLabelQuick;
import cn.ainannan.timeline.picManager.service.TimelineLabelQuickService;
import cn.ainannan.timeline.picManager.service.TimelineLabelService;

/**
 * 时光轴Controller
 * @author syy
 * @version 2018-09-26
 */
@RestController
@RequestMapping(value = "timeline/labelQuick")
public class TimelineLabelQuickController {

	@Autowired
	private TimelineLabelService tlService;
	@Autowired
	private TimelineLabelQuickService tlqService;
	
	@RequestMapping("list")
	public ResultObject list(TimelineLabelQuick timelineLabelQuick, 
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer size, 
			HttpServletRequest request) {
		
		PageHelper.startPage(page, size);
		List<TimelineLabelQuick> list = tlqService.findList(timelineLabelQuick);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGen.genSuccessResult(pageInfo);
	}
	
	@RequestMapping("save")
	public ResultObject save(TimelineLabelQuick quick, HttpServletRequest request) {
		
		// 新增标签的重复检查
		if(quick.isNewRecord()) {
			TimelineLabelQuick tl = new TimelineLabelQuick();
			
			if(quick.getName() == null || quick.getBelong() == null) {
				return ResultGen.genFailResult("关键参数不能为空！");
			}
			
			tl.setName(quick.getName());
			tl.setBelong(quick.getBelong());
			
			List<TimelineLabelQuick> tlList = tlqService.findList(tl);
			
			if(tlList.size() > 0) {
				return ResultGen.genFailResult("标签名已存在！");
			}
		}
		
		tlqService.save(quick);
		return ResultGen.genSuccessResult(quick);
	}
}