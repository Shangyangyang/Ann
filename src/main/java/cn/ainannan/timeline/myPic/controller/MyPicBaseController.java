package cn.ainannan.timeline.myPic.controller;

import cn.ainannan.base.result.ResultObject;
import cn.ainannan.timeline.myPic.service.MyPicBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("myPic/base")
public class MyPicBaseController {
	@Autowired
	private MyPicBaseService myPicBaseService;

	@RequestMapping("getTotalDirList")
	public ResultObject getTotalDirList(String parentPath, String filename) {

		return myPicBaseService.getTotalDirList(parentPath, filename);
	}

	@RequestMapping("getFileContent")
	public ResultObject getFileContent(String parentPath, String filename) {

		return myPicBaseService.getFileContent(parentPath, filename);
	}

}
