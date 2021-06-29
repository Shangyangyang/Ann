package cn.ainannan.timeline.picManager.controller;

import cn.ainannan.timeline.picManager.service.TimelinePicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 时光轴Controller
 * @author syy
 * @version 2018-09-26
 */
@RestController
@RequestMapping(value = "timeline/pic")
public class TimelinePicController {

	@Autowired
	private TimelinePicService tpService;

	@RequestMapping("getImg")
	public void getImg(String id, String type, HttpServletRequest request, HttpServletResponse resp) {
		tpService.getImg(id, type, resp);
	}

}