package cn.ainannan.tool.dj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.tool.dj.bean.Dj;
import cn.ainannan.tool.dj.mapper.DjMapper;

@Service
public class DjService extends BaseService<DjMapper, Dj>{
	
	public List<Dj> listWithChildren(Dj bean){
		return dao.listWithChildren(bean);
	}
}
