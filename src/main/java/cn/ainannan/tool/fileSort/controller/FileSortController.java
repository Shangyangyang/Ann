package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultObject;
import cn.ainannan.tool.fileSort.bean.FileSort;
import cn.ainannan.tool.fileSort.service.FileSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 时光轴Controller
 * @author syy
 * @version 2018-09-26
 */
@RestController
@RequestMapping(value = "fileSort/fileSort")
public class FileSortController {

	@Autowired
	private FileSortService fileSortService;
	
	@RequestMapping({ "", "findFlieList" })
	public ResultObject list(FileSort bean, HttpServletRequest request) {
		return fileSortService.findFileList(bean);
	}

//	@RequestMapping(value = "download")
//	public ResultObject download(HttpServletResponse response, @RequestParam(required = true) String id)
//			throws IOException {
//		InputStream inStream = null;
//		ServletOutputStream servletOS = null;
//		Attachment att = attachmentService.get(new Attachment(id));
//		//String webPath = Global.getUserfilesBaseDir();
//		/* 读取文件 */
//		File file = new File(webPath + att.getFilePath() + att.getNewFileName());
//		/* 如果文件存在 */
//		if (file.exists()) {
//			// type 为response 返回类型,filename 为要打开的文件名称
//			String type = "";
//			String open = "inline";
//			if (att.getFileExt().equalsIgnoreCase("xlsx")) {
//				type = "application/octet-stream";
//			} else if (att.getFileExt().equalsIgnoreCase("xls")) {
//				type = "application/octet-stream";
//			} else if (att.getFileExt().equalsIgnoreCase("pdf")) {
//				type = "application/octet-stream";
//			} else if (att.getFileExt().equalsIgnoreCase("doc")) {
//				type = "application/octet-stream";
//			} else if (att.getFileExt().equalsIgnoreCase("txt")) {
//				type = "application/octet-stream";
//			} else if (att.getFileExt().equalsIgnoreCase("ppt")) {
//				type = "application/octet-stream";
//			} else if (att.getFileExt().equalsIgnoreCase("pptx")) {
//				type = "application/octet-stream";
//			} else if (att.getFileExt().equalsIgnoreCase("jpg")) {
//				type = "image/jpeg";
//			} else if (att.getFileExt().equalsIgnoreCase("jpeg")) {
//				type = "image/jpeg";
//			} else if (att.getFileExt().equalsIgnoreCase("png")) {
//				type = "image/png";
//			} else if (att.getFileExt().equalsIgnoreCase("bmp")) {
//				type = "image/bmp";
//			} else if (att.getFileExt().equalsIgnoreCase("gif")) {
//				type = "image/gif";
//			} else if (att.getFileExt().equalsIgnoreCase("rar")) {
//				type = "application/octet-stream";
//			} else if (att.getFileExt().equalsIgnoreCase("zip")) {
//				type = "application/octet-stream";
//			} else {
//				type = "application/octet-stream";
//				open = "attachment";
//			}
//			response.reset();
//			response.setContentType(type);
//			response.addHeader("Content-Disposition", open + "; filename=\""
//					+ new String((att.getFileName()).getBytes("utf-8"), "ISO8859-1") + "\"");
//			int fileLength = (int) file.length();
//			/* 如果文件长度大于0 */
//			if (fileLength != 0) {
//				/* 创建输入流 */
//				inStream = new FileInputStream(file);
//				byte[] buf = new byte[4096];
//				/* 创建输出流 */
//				servletOS = response.getOutputStream();
//				int readLength;
//				while (((readLength = inStream.read(buf)) != -1)) {
//					servletOS.write(buf, 0, readLength);
//				}
//				inStream.close();
//				servletOS.flush();
//				servletOS.close();
//				return null;
//			}
//		}
//		return null;
//	}



	
}