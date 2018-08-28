package cn.ainannan.commons.utils;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

import com.google.common.collect.Lists;

import cn.ainannan.commons.Constant;

public class FileUtils {

	public static void main1(String[] args) {
		List<String> fileList = Lists.newArrayList();
		
		for(String s : Constant.picFiles) {
			String filePath = "H:\\尚羊羊\\图片\\个人相册\\" + s;
			addList(filePath, fileList);
		}
		
		System.out.println(fileList.size());
	}
	
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
}
