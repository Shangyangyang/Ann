package cn.ainannan.tool.cost.controller;

import cn.ainannan.AnnApplication;
import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.mybatisPlus.QueryGenerator;
import cn.ainannan.tool.cost.bean.CostGuihua;
import cn.ainannan.tool.cost.mapper.CostGuihuaMapper;
import cn.ainannan.tool.cost.service.CostGuihuaService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("cost/guihua")
// junit5 改用以下方式
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AnnApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 指定spring-boot的启动类
public class CostGuihuaController {

	@Autowired
	private CostGuihuaMapper guihuaMapper;
	@Autowired
    private CostGuihuaService guihuaService;


	@RequestMapping({ "", "list" })
	public ResultObject list(CostGuihua bean, @RequestParam(defaultValue = "1") Integer page,
							 @RequestParam(defaultValue = "10") Integer size, HttpServletRequest req) {

		QueryWrapper<CostGuihua> wrapper = QueryGenerator.initQueryWrapper(bean, req.getParameterMap());
		wrapper.orderByDesc("create_date");
		if(page == 0 && size == 0){
			return ResultGen.genSuccessResult(guihuaMapper.selectList(wrapper));
		} else {
			Page<CostGuihua> page2 = new Page<CostGuihua>(page, size);
			IPage<CostGuihua> list = guihuaMapper.selectPage(page2, wrapper);

			return ResultGen.genSuccessResult(list);
		}

	}

    /*
     * 保存
     *
     * @param bean
     * @return

     */
    @RequestMapping("save")
    public ResultObject save(CostGuihua bean) {
        guihuaService.save(bean);
        return ResultGen.genSuccessResult();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public ResultObject delete(String id) {

        guihuaMapper.deleteById(id);
        return ResultGen.genSuccessResult();
    }


    @Test
    public void test(){
        QueryWrapper<CostGuihua> query = new QueryWrapper<>();
        query.eq("state", "1").eq("type", "1");

        List<CostGuihua> guihuaList = guihuaMapper.selectList(query);

        guihuaList.stream().forEach(System.out::println);

    }

}
