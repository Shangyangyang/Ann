package cn.ainannan.sys.dict.mapper;

import org.springframework.stereotype.Repository;
import cn.ainannan.base.dao.CrudDao;
import cn.ainannan.sys.dict.bean.Dict;
@Repository
public interface DictMapper extends CrudDao<Dict>{
	String getLabelByName(Dict dict);
}