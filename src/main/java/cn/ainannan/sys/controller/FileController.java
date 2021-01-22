package cn.ainannan.sys.controller;

import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.utils.FileUtils;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.service.TimelinePicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("sys/file")
public class FileController {

	@Autowired(required = false)
	private TimelinePicService picService;

	@RequestMapping(value = "download")
	public ResultObject download(HttpServletResponse response, @RequestParam(required = true) String id)throws IOException {
		// 流
		InputStream inStream = null;
		ServletOutputStream servletOS = null;
		// 读文件

		TimelinePic tp = picService.get(id);

		File file = null;

		file = new File(tp.getPath() + File.separator + tp.getFilename());

		FileUtils.sendFile(file, response);

		return null;
	}
	
}
