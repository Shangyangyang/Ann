package cn.ainannan.sys.controller;

import cn.ainannan.base.result.ResultObject;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.service.TimelinePicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("sys/file")
public class FileController {

	@Autowired(required = false)
	private TimelinePicService picService;

	@RequestMapping(value = "download")
	public ResultObject download(HttpServletResponse response, @RequestParam(required = true) String id, String Modeltype)
			throws IOException {
		// 流
		InputStream inStream = null;
		ServletOutputStream servletOS = null;
		// 读文件

		TimelinePic tp = picService.get(id);

		File file = null;

		file = new File(tp.getPath() + File.separator + tp.getFilename());

		if (file.exists()) {
			// type 为response 返回类型,filename 为要打开的文件名称
			String type = "";
			String open = "inline";
			if (tp.getSuffix().equalsIgnoreCase("xlsx")) {
				type = "application/octet-stream";
			} else if (tp.getSuffix().equalsIgnoreCase("xls")) {
				type = "application/x-xls";
			} else if (tp.getSuffix().equalsIgnoreCase("pdf")) {
				type = "application/pdf";
			} else if (tp.getSuffix().equalsIgnoreCase("doc")) {
				type = "application/msword";
			} else if (tp.getSuffix().equalsIgnoreCase("docx")) {
				type = "application/msword";
			} else if (tp.getSuffix().equalsIgnoreCase("txt")) {
				type = "text/plain";
			} else if (tp.getSuffix().equalsIgnoreCase("ppt")) {
				type = "application/octet-stream";
			} else if (tp.getSuffix().equalsIgnoreCase("pptx")) {
				type = "application/octet-stream";
			} else if (tp.getSuffix().equalsIgnoreCase("jpg")) {
				type = "image/jpeg";
			} else if (tp.getSuffix().equalsIgnoreCase("jpeg")) {
				type = "image/jpeg";
			} else if (tp.getSuffix().equalsIgnoreCase("png")) {
				type = "image/png";
			} else if (tp.getSuffix().equalsIgnoreCase("bmp")) {
				type = "image/bmp";
			} else if (tp.getSuffix().equalsIgnoreCase("gif")) {
				type = "image/gif";
			} else if (tp.getSuffix().equalsIgnoreCase("rar")) {
				type = "application/octet-stream";
			} else if (tp.getSuffix().equalsIgnoreCase("zip")) {
				type = "application/octet-stream";
			} else {
				type = "application/octet-stream";
				open = "attachment";
			}

System.out.println("type = " + type);
System.out.println("file.length() = " + file.length());

			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Cache-Control","no-cache");
			response.reset();
			response.setContentType(type);
			response.addHeader("Content-Disposition", open + "; filename=\""
					+ new String((tp.getFilename()).getBytes("utf-8"), "ISO8859-1") + "\"");
			int fileLength = (int) file.length();
			/* 如果文件长度大于0 */
			if (fileLength != 0) {
				/* 创建输入流 */
				inStream = new FileInputStream(file);
				byte[] buf = new byte[4096];
				/* 创建输出流 */
				servletOS = response.getOutputStream();
				int readLength;
				while (((readLength = inStream.read(buf)) != -1)) {
					servletOS.write(buf, 0, readLength);
				}
				inStream.close();
				servletOS.flush();
				servletOS.close();
				return null;
			}
		}
		return null;
	}
	
}
