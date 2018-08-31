package cn.ainannan.tool.cost.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.utils.DateUtil;
import cn.ainannan.commons.utils.NumberUtils;
import cn.ainannan.tool.cost.bean.Car;
import cn.ainannan.tool.cost.bean.CarOilWear;
import cn.ainannan.tool.cost.service.CarService;

@RestController
@RequestMapping("cost/car")
public class CarController {
	@Autowired
	private CarService carService;
	
	@RequestMapping({"","list"})
	public ResultObject list(Car car, @RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "20") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size);
		
		List<Car> list = carService.findList(car);
		PageInfo<Car> pageInfo = new PageInfo<Car>(list);
		
		return ResultGen.genSuccessResult(pageInfo);
	}
	
	/**
	 * 保存
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
	 * @param car
	 * @return
	 */
	@RequestMapping("delete")
	public ResultObject delete(String id) {
		
		carService.delete(new Car(id));
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping(value="getOilWear")
	public ResultObject getOilWear(Car car){
		car.setType("1"); 	// 油费
		CarOilWear cow = null;
		
		List<Car> carList = carService.findList(car);
		
		if(carList.size() > 0){
			int min = carList.get(0).getLicheng();			
			int max = carList.get(0).getLicheng();
			double money = 0D;
			double shengTotal = 0D;
			String startTime = carList.get(0).getInputDate();
			String endTime = carList.get(0).getInputDate();
			
			for (Car c : carList) {
				
				if(c.getLicheng() < min){
					min = c.getLicheng();
					startTime = c.getInputDate();
				}
				if(c.getLicheng() > max){
					max = c.getLicheng();
					endTime = c.getInputDate();
				}
				
				money += c.getMoney();
				shengTotal += c.getMoney() / c.getYoujia();
			}
			
			// 计算
			int lichengTotal = max - min;
			
			double baigongliyouhao = shengTotal / lichengTotal * 100;
						
			cow = new CarOilWear(NumberUtils.getSubDouble(shengTotal), DateUtil.getDate(startTime), 
					DateUtil.getDate(endTime), lichengTotal, NumberUtils.getSubDouble(money),
					NumberUtils.getSubDouble(money / shengTotal), NumberUtils.getSubDouble(baigongliyouhao));
			
			
		}
		
		return ResultGen.genSuccessResult(cow);
	}
	
}
