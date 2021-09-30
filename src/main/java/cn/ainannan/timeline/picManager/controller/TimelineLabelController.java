package cn.ainannan.timeline.picManager.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.mybatisPlus.QueryGenerator;
import cn.ainannan.timeline.picManager.bean.TimelineLabel;
import cn.ainannan.timeline.picManager.mapper.TimelineLabelMapper;
import cn.ainannan.timeline.picManager.service.TimelineLabelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping(value = "timeline/label")
public class TimelineLabelController {

	@Autowired
	private TimelineLabelService tlService;
	@Autowired(required = false)
	private TimelineLabelMapper timelineLabelMapper;
	
	@RequestMapping({ "", "list" })
	public ResultObject list(TimelineLabel timelineLabel, 
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer size, 
			HttpServletRequest req) {
		QueryWrapper<TimelineLabel> wrapper = QueryGenerator.initQueryWrapper(timelineLabel, req.getParameterMap());

		if(page == 0 && size == 0){
			return ResultGen.genSuccessResult(timelineLabelMapper.selectList(wrapper));
		} else {
			Page<TimelineLabel> page2 = new Page<TimelineLabel>(page, size);
			wrapper.orderByDesc("select_num");
			IPage<TimelineLabel> list = timelineLabelMapper.selectPage(page2, wrapper);

			return ResultGen.genSuccessResult(list);
		}
	}
	
	
	/*@RequestMapping("list2")
	public ResultObject list2(TimelineLabel timelineLabel, HttpServletRequest request) {
		
		List<TimelineLabel> list = tlService.list(timelineLabel);
		
		return ResultGen.genSuccessResult(list);
	}*/
	
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
	
	@RequestMapping("updateSelectNum")
	public ResultObject updateSelectNum(TimelineLabel timelineLabel, HttpServletRequest request) {
		if(StringUtils.isBlank(timelineLabel.getIdstr())) {
			return ResultGen.genFailResult("主键不能为空！");
		}
		
		timelineLabel.setIds(timelineLabel.getIdstr().split(","));
		
		tlService.updateSelectNum(timelineLabel);
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("save")
	public ResultObject save(TimelineLabel timelineLabel, HttpServletRequest request) {
		
		// 新增标签的重复检查
		if(timelineLabel.ifNewRecord()) {

			QueryWrapper<TimelineLabel> query = new QueryWrapper<TimelineLabel>();
			query.eq("name", timelineLabel.getName());

			List<TimelineLabel> tlList = tlService.list(query);

			if(tlList.size() > 0) {
				return ResultGen.genFailResult("标签名已存在！");
			}


		}
		
		tlService.save(timelineLabel);
		return ResultGen.genSuccessResult(timelineLabel);
	}
	
	@RequestMapping("delete")
	public ResultObject delete(TimelineLabel timelineLabel, HttpServletRequest request) {
		timelineLabelMapper.deleteById(timelineLabel.getId());
		return ResultGen.genSuccessResult(timelineLabel);
	}

	
}