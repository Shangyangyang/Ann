package cn.ainannan.sys.dict.service;

import org.springframework.stereotype.Service;
import cn.ainannan.base.service.CrudService;
import cn.ainannan.sys.dict.bean.Dict;
import cn.ainannan.sys.dict.mapper.DictMapper;

@Service
public class DictService extends CrudService<DictMapper, Dict>{
	public String getLabelByName(Dict dict) {
		return dao.getLabelByName(dict);
	}
}
