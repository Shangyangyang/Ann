package cn.ainannan.tool.dj.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.tool.dj.bean.Dj;
import cn.ainannan.tool.dj.service.DjService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("music/dj")
public class DjController {
    @Autowired
    private DjService djService;

    @RequestMapping({"", "list"})
    public ResultObject list(Dj bean, @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
        PageHelper.startPage(page, size);

        List<Dj> list = djService.findList(bean);
        PageInfo<Dj> pageInfo = new PageInfo<Dj>(list);

        return ResultGen.genSuccessResult(pageInfo);
    }

    @RequestMapping("get")
    public ResultObject get(String id, HttpServletRequest request, HttpServletResponse resp) {

        return ResultGen.genSuccessResult(djService.get(id));
    }

    @RequestMapping("getFile")
    public void getFile(String id, HttpServletRequest request, HttpServletResponse resp) {

        Enumeration<String> paraNames = request.getHeaders("Range");
        System.out.println("paraNames.nextElement() = " + paraNames.nextElement());

        djService.getFile(id, resp);
    }
}
