package cn.ainannan.sys.service;

import org.springframework.stereotype.Service;
import cn.ainannan.base.service.BaseService;
import cn.ainannan.sys.bean.Dict;
import cn.ainannan.sys.mapper.DictMapper;

@Service
public class DictService extends BaseService<DictMapper, Dict>{
	public String getLabelByName(Dict dict) {
		return dao.getLabelByName(dict);
	}
}
