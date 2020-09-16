package cn.ainannan.tool.dj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ainannan.tool.dj.service.DjService;

@RestController
@RequestMapping("dj")
public class DjController {
	@Autowired
	private DjService djService;
	
	
}
