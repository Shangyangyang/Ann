package cn.ainannan.tool.dj.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.commons.utils.FileUtils;
import cn.ainannan.commons.utils.MD5Utils;
import cn.ainannan.tool.dj.bean.Dj;
import cn.ainannan.tool.dj.mapper.DjMapper;
import com.google.common.collect.Lists;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
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

		String filePath = dj.getPath().replace("djSource", "H:\\尚羊羊\\音乐\\水晶DJ\\source");

		File file = new File(filePath);
		try {
			FileUtils.sendFile(file, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2(){
		String filePath = "F:\\BaiduNetdiskDownload\\微信：vip44493667";
		this.getTempList(filePath);
	}

	public List<Dj> getTempList(String filePath){
		List<Dj> djList = Lists.newArrayList();
		if(StringUtils.isBlank(filePath)) return djList;

		/*
		简单梳理
		1.根据路径获取全部文件列表
		2.只要音乐的
		3.整理取相关信息，返回到前端
		 */

		File path = new File(filePath);
		Dj obj = null;

		if(!path.isDirectory()){
			if("mp3".equals(FilenameUtils.getExtension(filePath))){
				obj = new Dj();
				System.out.println("filePath = " + FilenameUtils.getBaseName(filePath));
				obj.setName(FilenameUtils.getBaseName(filePath));
				obj.setPath(path.getName());
				obj.setSize(path.length());
				// obj.setFileId(MD5Utils.getFileMD5(path));
				djList.add(obj);
			}
		} else {
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

		return djList;
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
}
