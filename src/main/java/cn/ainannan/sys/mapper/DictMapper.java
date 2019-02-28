package cn.ainannan.sys.mapper;

import org.springframework.stereotype.Repository;
import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.sys.bean.Dict;
@Repository
public interface DictMapper extends BaseDao<Dict>{
	String getLabelByName(Dict dict);
}