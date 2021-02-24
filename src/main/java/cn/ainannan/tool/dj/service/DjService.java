package cn.ainannan.tool.dj.service;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.base.service.BaseService;
import cn.ainannan.commons.utils.FileUtils;
import cn.ainannan.commons.utils.MD5Utils;
import cn.ainannan.tool.dj.bean.Dj;
import cn.ainannan.tool.dj.mapper.DjMapper;
import com.google.common.collect.Lists;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class DjService extends BaseService<DjMapper, Dj>{
	
	public List<Dj> listWithChildren(Dj bean){
		return dao.listWithChildren(bean);
	}

    public void getFile(String id, HttpServletResponse resp) {
		Dj dj = dao.getPathById(id);

		String filePath = dj.getPath().replace(DJ_PRE_PATH, DJ_FILE_SAVE_PATH);

		File file = new File(filePath);
		try {
			FileUtils.sendFile(file, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ResultObject getTempList(String filePath){

		List<Dj> djList = Lists.newArrayList();
		if(StringUtils.isBlank(filePath)) return ResultGen.genFailResult("路径不能为空");

		/*
		简单梳理
		1.根据路径获取全部文件列表
		2.只要音乐的
		3.整理取相关信息，返回到前端
		 */

		File path = new File(filePath);

		if(!path.exists()) return ResultGen.genFailResult("路径无效");

		Dj obj = null;
		String fileType = "";

		if(!path.isDirectory()){
			fileType = FILE_TYPE_FILE;

			if("mp3".equals(FilenameUtils.getExtension(filePath))){
				obj = new Dj();

				obj.setName(FilenameUtils.getBaseName(filePath));
				obj.setPath(path.getName());
				obj.setSize(path.length());
				// obj.setFileId(MD5Utils.getFileMD5(path));
				djList.add(obj);
			}
		} else {
			fileType = FILE_TYPE_DIR;

			File [] files = path.listFiles();
			int count = 0;
			for (File f : files ) {
				if("mp3".equals(FilenameUtils.getExtension(f.getAbsolutePath()))){
					obj = new Dj();
					obj.setName(FilenameUtils.getBaseName(f.getAbsolutePath()));
					obj.setPath(f.getName());
					obj.setSize(f.length());
					// obj.setFileId(MD5Utils.getFileMD5(f));
					djList.add(obj);
					if(++count >= 5) break;
				}
			}
		}

		return ResultGen.genSuccessResult(djList).setData2(fileType);
	}

	public Integer checkIsAlready(String filePath) {
		File file = new File(filePath);
		String md5Str = MD5Utils.getFileMD5(file);

		Dj query = new Dj();
		query.setFileId(md5Str);

		List<Dj> djList = dao.findList(query);

		if(djList == null) return 0;
		return djList.size();
	}

	public ResultObject add(Dj bean){
		String path = bean.getPath();
		System.out.println("bean.getPath() = " + path);

		if(StringUtils.isBlank(path)) return ResultGen.genFailResult("路径不能为空");

		File file = new File(path);

		if(!file.exists()) return ResultGen.genFailResult("路径无效");

		Dj obj = new Dj();
		obj.setName(FilenameUtils.getBaseName(path));
		obj.setPath(DJ_PRE_PATH + "/" + file.getName());
		obj.setSize(file.length());
		obj.setFileId(MD5Utils.getFileMD5(file));
		obj.setState(DJ_STATE_WEIJIEXI);

		this.save(obj);
		obj.setPath(null);

		try {
			org.apache.commons.io.FileUtils.moveFile(
					file, new File(DJ_FILE_SAVE_PATH + "/" + file.getName()));
		} catch (IOException e) {
			e.printStackTrace();
			return ResultGen.genFailResult("文件移动失败，" + e.toString());
		}

		return ResultGen.genSuccessResult(obj);
	}


	private static final String FILE_TYPE_FILE = "1";
	private static final String FILE_TYPE_DIR = "2";

	private static final String DJ_STATE_WEIJIEXI = "1";
	private static final String DJ_PRE_PATH = "djSource";
	private static final String DJ_FILE_SAVE_PATH = "H:\\尚羊羊\\音乐\\水晶DJ\\source";
}
