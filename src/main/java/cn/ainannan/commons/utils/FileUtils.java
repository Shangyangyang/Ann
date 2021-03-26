package cn.ainannan.commons.utils;

import com.google.common.collect.Lists;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.List;

public class FileUtils {

	/**
	 * 判断path是否文件，如果是文件的话添加到List中，如果是目录则下钻到目录中获取文件。
	 * @param filePath
	 * @param fileList
	 */
	public static void addList(String filePath, List<String> fileList) {
		
		File file = new File(filePath);
		
		if(!file.exists()) {
			return;
		}
		
		if(file.isDirectory()) {
			
			String [] files = file.list();
			
			for (String s : files) {
				String filename = filePath + File.separatorChar + s;
				FileUtils.addList(filename, fileList);
			}
		} else {
			
			List<String> extensions = Lists.newArrayList();
			extensions.add("jpg");
			extensions.add("jpeg");
			extensions.add("png");
			extensions.add("gif");
			
			if(FilenameUtils.isExtension(filePath.toLowerCase(), extensions)) {
				fileList.add(filePath);
			}
		}
	}

	public static void main(String[] args) {
		File file = new File("H:\\尚羊羊\\图片");
		System.out.println("getFileSizeStr(file) = " + getFileSizeStr(file.length()));
	}

	public static String getFileSizeStr(Long size){
		String [] unitStr = new String [] {"B", "KB","MB","GB",};

		if(size <= 0) return "0B";
		int count = 0;
		long unit = 1024;
		double temp = size;
		while(temp > unit){
			temp = temp / unit;
			count++;
		}

		DecimalFormat df = new DecimalFormat("#.0");

		return df.format(temp) + unitStr[count];
	}

	public static void sendFile(File file, HttpServletResponse response) throws IOException {
		InputStream inStream = null;
		ServletOutputStream servletOS = null;
		// 读文件
		
		String suffix = FilenameUtils.getExtension(file.getAbsolutePath()).toLowerCase();
		
		if (file.exists()) {
			// type 为response 返回类型,filename 为要打开的文件名称
			String type = "";
			String open = "inline";
			if (suffix.equalsIgnoreCase("xlsx")) {
				type = "application/octet-stream";
			} else if (suffix.equalsIgnoreCase("xls")) {
				type = "application/x-xls";
			} else if (suffix.equalsIgnoreCase("mp3")) {
				type = "audio/mpeg";
			} else if (suffix.equalsIgnoreCase("pdf")) {
				type = "application/pdf";
			} else if (suffix.equalsIgnoreCase("doc")) {
				type = "application/msword";
			} else if (suffix.equalsIgnoreCase("docx")) {
				type = "application/msword";
			} else if (suffix.equalsIgnoreCase("txt")) {
				type = "text/plain";
			} else if (suffix.equalsIgnoreCase("ppt")) {
				type = "application/octet-stream";
			} else if (suffix.equalsIgnoreCase("pptx")) {
				type = "application/octet-stream";
			} else if (suffix.equalsIgnoreCase("jpg")) {
				type = "image/jpeg";
			} else if (suffix.equalsIgnoreCase("jpeg")) {
				type = "image/jpeg";
			} else if (suffix.equalsIgnoreCase("png")) {
				type = "image/png";
			} else if (suffix.equalsIgnoreCase("bmp")) {
				type = "image/bmp";
			} else if (suffix.equalsIgnoreCase("gif")) {
				type = "image/gif";
			} else if (suffix.equalsIgnoreCase("rar")) {
				type = "application/octet-stream";
			} else if (suffix.equalsIgnoreCase("zip")) {
				type = "application/octet-stream";
			} else {
				type = "application/octet-stream";
				open = "attachment";
			}
			response.reset();
			// 增加断点续传
			response.addHeader("Accept-Ranges", "bytes");
			response.addHeader("Content-Length", file.length() + "");
			response.addHeader("Content-Range", "bytes " + 0 + "-" + (file.length() - 1) + "/" + file.length());

			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Cache-Control","no-cache");

			response.setContentType(type);
			response.addHeader("Content-Disposition", open + "; filename=\""
					+ new String((file.getName()).getBytes("utf-8"), "ISO8859-1") + "\"");
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
			}
		}
	}
}
