package cn.ainannan.tool.cost.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.excel.EasyPoiUtil;
import cn.ainannan.tool.cost.bean.Car;
import cn.ainannan.base.bean.Tongji;
import cn.ainannan.tool.cost.service.CarService;

@RestController
@RequestMapping("cost/car")
public class CarController {
	@Autowired
	private CarService carService;

	@RequestMapping({ "", "list" })
	public ResultObject list(Car car, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size); 
		
		List<Car> list = carService.findList(car);
		PageInfo<Car> pageInfo = new PageInfo<Car>(list);
		
		return ResultGen.genSuccessResult(pageInfo);
	}
	
	@RequestMapping("export")
	public void export(Car car, HttpServletResponse response) {

		List<Car> list = carService.findList(car);
		// 导出操作
		EasyPoiUtil.exportExcel(list, "汽车花费", "total", Car.class, "汽车花费.xls", response);
	}

	/**
	 * 保存
	 * 
	 * @param car
	 * @return
	 */
	@RequestMapping("save")
	public ResultObject save(Car car) {
		carService.save(car);
		return ResultGen.genSuccessResult();
	}

	/**
	 * 删除
	 * 
	 * @param car
	 * @return
	 */
	@RequestMapping("delete")
	public ResultObject delete(String id) {

		carService.delete(new Car(id));
		return ResultGen.genSuccessResult();
	}

	@RequestMapping(value = "findColumnData")
	public ResultObject findColumnData(Tongji bean) {
		return ResultGen.genSuccessResult(carService.findColumnData(bean));
	}

	@RequestMapping(value = "tongjiByNianduCharts")
	public ResultObject tongjiByNianduCharts(Car bean) {
		return ResultGen.genSuccessResult(carService.tongjiByNianduCharts(bean));
	}

	@RequestMapping(value = "tongjiStr")
	public ResultObject tongjiStr(Car bean) {
		return ResultGen.genSuccessResult(carService.tongjiStr(bean));
	}

	

}
