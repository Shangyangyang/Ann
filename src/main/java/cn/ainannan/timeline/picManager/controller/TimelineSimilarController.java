package cn.ainannan.timeline.picManager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import com.github.pagehelper.PageHelper;
// import com.github.pagehelper.PageInfo;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.timeline.picManager.bean.TimelineSimilar;
import cn.ainannan.timeline.picManager.service.TimelineSimilarService;

/**
 * 相似图片管理
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "timeline/similar")
public class TimelineSimilarController {

	@Autowired
	private TimelineSimilarService similarService;

	@RequestMapping({ "", "list" })
	public ResultObject list(TimelineSimilar similar, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
		// Pagehelper.startPage(page, size);
		List<TimelineSimilar> list = similarService.findList(similar);
		// PageInfo pageInfo = new PageInfo(list);
		return ResultGen.genSuccessResult();
	}

}