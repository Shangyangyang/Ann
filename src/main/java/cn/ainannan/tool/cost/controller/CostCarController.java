package cn.ainannan.tool.cost.controller;

import cn.ainannan.AnnApplication;
import cn.ainannan.base.bean.Tongji;
import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.mybatisPlus.QueryGenerator;
import cn.ainannan.excel.EasyPoiUtil;
import cn.ainannan.tool.cost.bean.CostCar;
import cn.ainannan.tool.cost.mapper.CostCarMapper;
import cn.ainannan.tool.cost.service.CostCarService;
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
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("cost/car")
// junit5 改用以下方式
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AnnApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 指定spring-boot的启动类
public class CostCarController {
	@Autowired
	private CostCarService costCarService;
	@Autowired
	private CostCarMapper costCarMapper;

	@RequestMapping({ "", "list" })
	public ResultObject list(CostCar car, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size, HttpServletRequest req) {

		QueryWrapper<CostCar> wrapper = QueryGenerator.initQueryWrapper(car, req.getParameterMap());

		if(page == 0 && size == 0){
			return ResultGen.genSuccessResult(costCarMapper.selectList(wrapper));
		} else {
			Page<CostCar> page2 = new Page<CostCar>(page, size);
			IPage<CostCar> list = costCarMapper.selectPage(page2, wrapper);

			return ResultGen.genSuccessResult(list);
		}

	}

	@RequestMapping("export")
	public void export(CostCar car, HttpServletResponse response) {

		List<CostCar> list = costCarService.list();
		// 导出操作
		EasyPoiUtil.exportExcel(list, "汽车花费", "total", CostCar.class, "汽车花费.xls", response);
	}

	/*
	 * 保存
	 *
	 * @param car
	 * @return

	*/
	@RequestMapping("save")
	public ResultObject save(CostCar car) {
		costCarService.save(car);
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

		costCarMapper.deleteById(id);
		return ResultGen.genSuccessResult();
	}

	@RequestMapping(value = "findColumnData")
	public ResultObject findColumnData(Tongji bean) {
		return ResultGen.genSuccessResult(costCarService.findColumnData(bean));
	}

	@RequestMapping(value = "tongjiByNianduCharts")
	public ResultObject tongjiByNianduCharts(CostCar bean) {
		return ResultGen.genSuccessResult(costCarService.tongjiByNianduCharts(bean));
	}

	@RequestMapping(value = "tongjiStr")
	public ResultObject tongjiStr(CostCar bean) {
		return ResultGen.genSuccessResult(costCarService.tongjiStr(bean));
	}

	@Test
	public void setList(){
		CostCar costCar = new CostCar();
		costCar.setType("2");

		QueryWrapper<CostCar> wrapper = new QueryWrapper<CostCar>();
		wrapper.eq("type", "2");

		Page<CostCar> page = new Page<CostCar>(1, 10);

		IPage<CostCar> list = costCarMapper.selectPage(page, wrapper);
		System.out.println(list.getPages());
		for (CostCar car : list.getRecords()) {
			System.out.println("car = " + car);
		}


	}

}
