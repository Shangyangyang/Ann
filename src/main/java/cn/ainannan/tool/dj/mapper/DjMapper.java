package cn.ainannan.tool.dj.mapper;

import cn.ainannan.tool.dj.bean.Dj;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DjMapper extends BaseMapper<Dj> {
	List<Dj> listWithChildren(Dj bean);
	Dj getPathById(String id);
}
