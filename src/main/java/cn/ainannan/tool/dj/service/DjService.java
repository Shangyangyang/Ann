package cn.ainannan.tool.dj.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.commons.utils.FileUtils;
import cn.ainannan.tool.dj.bean.Dj;
import cn.ainannan.tool.dj.mapper.DjMapper;
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
}
