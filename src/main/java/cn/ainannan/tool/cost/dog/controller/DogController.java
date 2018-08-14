package cn.ainannan.tool.cost.dog.controller;

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
import cn.ainannan.tool.cost.dog.bean.Dog;
import cn.ainannan.tool.cost.dog.service.DogService;

@RestController
@RequestMapping("cost/dog")
public class DogController {
	@Autowired
	private DogService dogService;
	
	@RequestMapping({"","list"})
	public ResultObject list(Dog dog, @RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "20") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size);
		List<Dog> list = dogService.findList(dog);
		PageInfo<Dog> pageInfo = new PageInfo<Dog>(list);
		
		return ResultGen.genSuccessResult(pageInfo);
	}
	
	/**
	 * 保存
	 * @param car
	 * @return
	 */
	@RequestMapping("save")
	public ResultObject save(Dog dog) {
		
		dogService.save(dog);
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("delete")
	public ResultObject delete(String id) {
		
		dogService.delete(new Dog(id));
		return ResultGen.genSuccessResult();
	}
	
}
