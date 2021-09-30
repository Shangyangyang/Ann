package cn.ainannan.timeline.myPic.service;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.Constant;
import cn.ainannan.commons.utils.FileUtils;
import cn.ainannan.commons.utils.StringUtils;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class MyPicBaseService extends ServiceImpl<TimelinePicMapper, TimelinePic> {

	@Value("${myPic-basePath}")
	private String myPicBasePath;
	@Value("${myPanfu}")
	private String myPanfu;

	private List<String> getFullFileList() {
		List<String> fileList = Lists.newArrayList();

		for (int i = 0; i < Constant.picFiles.length; i++) {
			FileUtils.addList(myPanfu + myPicBasePath + Constant.picFiles[i], fileList);
		}

		return fileList;
	}

	public ResultObject getFileContent(String parentPath, String filename) {

		//System.out.println("parentPath = " + parentPath);
		//System.out.println("filename = " + filename);
		String filePath = getFilePathByQuery(parentPath, filename);
		File file = new File(filePath);

		StringBuffer sb = new StringBuffer();
		sb.append("文件名称： ").append(file.getName());

		if(file.isDirectory()){
			List<String> fileList = Lists.newArrayList();
			FileUtils.addList(filePath, fileList);
			sb.append(" <br/>包含 ").append(fileList.size()).append(" 个文件");
		} else {
			sb.append(",").append(" <br/> 文件大小： ").append(FileUtils.getFileSizeStr(file.length()));
		}


		return ResultGen.genSuccessResult(sb.toString());
	}

	public ResultObject getTotalDirList(String parentPath, String filename) {
		/**
		 {"parentPath":"myPicBasePath",
		 "fileList":
		 [
		 {path: "test.jpg", isDir: false, size: 123341},
		 {path: "2011", isDir: true, size: 0, isNullDir: false}
		 ]
		 */

		String filePath = getFilePathByQuery(parentPath, filename);

		if(StringUtils.isNotBlank(parentPath) && StringUtils.isNotBlank(filename))
			parentPath = parentPath + PATH_SEPARATOR + filename;
		else parentPath = BASE_PATH;

		System.out.println("parentPath = " + parentPath);
		System.out.println("filename = " + filename);
		System.out.println("filePath = " + filePath);

		File curFile = new File(filePath);

		if(curFile == null || !curFile.isDirectory()){
			return ResultGen.genFailResult("错误的路径，获取列表失败");
		}

		File [] files = curFile.listFiles();

		StringBuffer sb = new StringBuffer();

		sb.append("{\"parentPath\":\"").append(parentPath).append("\",").append("\"fileList\":").append("[");

		if(files != null && files.length > 0){

			for (File file : files) {

				sb.append("{\"name\":\"").append(file.getName())
						.append("\",\"id\":\"").append(file.getName()).append("\",\"isDir\":")
						.append(file.isDirectory()).append(",\"size\":")
						.append(file.isDirectory() ? 0 : file.length());

				if(file.isDirectory()) {
					boolean isNullDir = file.list().length == 0;
					sb.append(",\"isNullDir\":").append(isNullDir);
				}

				sb.append("},");
			}

			sb.deleteCharAt(sb.length() - 1);
		}

		sb.append("]}");

		System.out.println(sb.toString());

		return ResultGen.genSuccessResult(sb.toString());
	}

	/**
	 * 根据parentPath 与 filename 获取本地正确的路径
	 * @param parentPath
	 * @param filename
	 * @return
	 */
	private String getFilePathByQuery(String parentPath, String filename) {
		String basePath = myPanfu + myPicBasePath;

		String newParentPath = null;
		String filePath = null;

		if(StringUtils.isNotBlank(parentPath) && StringUtils.isNotBlank(filename)){
			newParentPath = parentPath.replace(BASE_PATH , basePath);
			filePath = newParentPath.replace(
					PATH_SEPARATOR , File.separator
			) + File.separator + filename;
		} else
		{
			filePath = basePath;
		}

		return filePath;
	}

	private static final String BASE_PATH = "myPicBasePath";
	private static final String PATH_SEPARATOR = "+a+n+n+";
}
