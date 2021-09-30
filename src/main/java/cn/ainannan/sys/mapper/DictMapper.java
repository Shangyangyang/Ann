package cn.ainannan.sys.mapper;

import cn.ainannan.sys.bean.SysDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
@Repository
public interface DictMapper extends BaseMapper<SysDict> {
	String getLabelByName(SysDict dict);
}