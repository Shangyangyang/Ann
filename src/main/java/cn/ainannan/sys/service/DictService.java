package cn.ainannan.sys.service;

import cn.ainannan.sys.bean.SysDict;
import cn.ainannan.sys.mapper.DictMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DictService extends ServiceImpl<DictMapper, SysDict>{
	public String getLabelByName(SysDict dict) {
		return baseMapper.getLabelByName(dict);
	}
}
