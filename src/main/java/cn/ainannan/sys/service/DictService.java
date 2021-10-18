package cn.ainannan.sys.service;

import cn.ainannan.base.service.MyBaseService;
import cn.ainannan.sys.bean.SysDict;
import cn.ainannan.sys.mapper.DictMapper;
import org.springframework.stereotype.Service;

@Service
public class DictService extends MyBaseService<DictMapper, SysDict> {
	public String getLabelByName(SysDict dict) {
		return baseMapper.getLabelByName(dict);
	}
}
