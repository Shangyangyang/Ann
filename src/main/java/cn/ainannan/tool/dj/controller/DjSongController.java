package cn.ainannan.tool.dj.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.tool.dj.bean.DjSong;
import cn.ainannan.tool.dj.service.DjSongService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("music/djSong")
public class DjSongController {
    @Autowired
    private DjSongService djSongService;

    @RequestMapping({"", "list"})
    public ResultObject list(DjSong bean, @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
        PageHelper.startPage(page, size);

        List<DjSong> list = djSongService.findList(bean);
        PageInfo<DjSong> pageInfo = new PageInfo<DjSong>(list);

        return ResultGen.genSuccessResult(pageInfo);
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
        djSongService.delete(bean);
        return ResultGen.genSuccessResult();
    }
}
