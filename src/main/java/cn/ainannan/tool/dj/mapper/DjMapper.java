package cn.ainannan.tool.dj.mapper;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.tool.dj.bean.Dj;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DjMapper extends BaseDao<Dj> {
	List<Dj> listWithChildren(Dj bean);
	Dj getPathById(String id);
}
