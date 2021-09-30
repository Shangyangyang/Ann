package cn.ainannan.tool.dj.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.mybatisPlus.QueryGenerator;
import cn.ainannan.tool.dj.bean.Dj;
import cn.ainannan.tool.dj.mapper.DjMapper;
import cn.ainannan.tool.dj.service.DjService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("music/dj")
public class DjController {
    @Autowired
    private DjService djService;
    @Autowired
    private DjMapper djMapper;

    @RequestMapping({"", "list"})
    public ResultObject list(Dj bean, @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer size, HttpServletRequest req) {

        QueryWrapper<Dj> wrapper = QueryGenerator.initQueryWrapper(bean, req.getParameterMap());


        Page<Dj> page2 = new Page<Dj>(page, size);
        IPage<Dj> list = djMapper.selectPage(page2, wrapper);

        return ResultGen.genSuccessResult(list);

    }

    @RequestMapping("get")
    public ResultObject get(String id, HttpServletRequest request, HttpServletResponse resp) {

        return ResultGen.genSuccessResult(djService.getById(id));
    }

    @RequestMapping("getFile")
    public void getFile(String id, HttpServletRequest request, HttpServletResponse resp) {
        djService.getFile(id, resp);
    }


    @RequestMapping("save")
    public ResultObject save(Dj bean, HttpServletRequest request, HttpServletResponse resp) {
        djService.save(bean);
        return ResultGen.genSuccessResult();
    }

    @RequestMapping("getTempList")
    public ResultObject getTempList(String filePath) {
        return djService.getTempList(filePath);
    }

    @RequestMapping("checkIsAlready")
    public ResultObject checkIsAlready(String filePath) {
        return ResultGen.genSuccessResult(djService.checkIsAlready(filePath));
    }

    @RequestMapping("add")
    public ResultObject add(Dj bean) throws IOException {
        return djService.add(bean);
    }

    @RequestMapping("delete")
    public ResultObject delete(Dj bean) throws IOException {
        return djService.delete(bean);
    }


}
