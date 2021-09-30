package cn.ainannan.tool.dj.mapper;

import cn.ainannan.tool.dj.bean.DjSong;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DjSongMapper extends BaseMapper<DjSong> {
    List<String> getSingerList();
}
