package cn.ainannan.tool.dj.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.sys.utils.PinyinUtil;
import cn.ainannan.tool.dj.bean.DjSong;
import cn.ainannan.tool.dj.mapper.DjSongMapper;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DjSongService extends BaseService<DjSongMapper, DjSong>{

    public List<DjSong> getSingerList(){
        List<String> singerList = dao.getSingerList();
        List<DjSong> djSongList = Lists.newArrayList();

        singerList.stream().forEach(item -> {
            DjSong song = new DjSong();
            song.setSinger(item);
            song.setSingerPy(PinyinUtil.getFirstPinYin(item));
            djSongList.add(song);
        });

        return djSongList;
    }
}
