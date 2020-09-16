package cn.ainannan.tool.dj.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.tool.dj.bean.Dj;

@Repository
public interface DjMapper extends BaseDao<Dj> {
	List<Dj> listWithChildren(Dj bean);
}
