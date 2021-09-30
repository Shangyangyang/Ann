package cn.ainannan.tool.dj.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.mybatisPlus.QueryGenerator;
import cn.ainannan.tool.dj.bean.DjSong;
import cn.ainannan.tool.dj.mapper.DjSongMapper;
import cn.ainannan.tool.dj.service.DjSongService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

// import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("music/djSong")
public class DjSongController {
    @Autowired
    private DjSongService djSongService;
    @Autowired
    private DjSongMapper djSongMapper;

    @RequestMapping({"", "list"})
    public ResultObject list(DjSong bean, @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer size, HttpServletRequest req) {
        QueryWrapper<DjSong> wrapper = QueryGenerator.initQueryWrapper(bean, req.getParameterMap());

        if(page == 0 && size == 0){
            return ResultGen.genSuccessResult(djSongMapper.selectList(wrapper));
        } else {
            Page<DjSong> page2 = new Page<DjSong>(page, size);
            IPage<DjSong> list = djSongMapper.selectPage(page2, wrapper);

            return ResultGen.genSuccessResult(list);
        }


    }

    @RequestMapping("getSingerList")
    public ResultObject getSingerList(DjSong bean) {

        return ResultGen.genSuccessResult(djSongService.getSingerList());
    }

    @RequestMapping("save")
    public ResultObject save(DjSong bean) {
        djSongService.save(bean);
        return ResultGen.genSuccessResult();
    }

    @RequestMapping("delete")
    public ResultObject delete(DjSong bean) {
        djSongMapper.deleteById(bean.getId());
        return ResultGen.genSuccessResult();
    }
}
