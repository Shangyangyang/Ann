package cn.ainannan.tool.cost.large.controller;

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
import cn.ainannan.tool.cost.large.bean.Large;
import cn.ainannan.tool.cost.large.service.LargeService;

@RestController
@RequestMapping("cost/large")
public class LargeController {
	@Autowired
	private LargeService largeService;
	
	@RequestMapping({"","list"})
	public ResultObject list(Large large, @RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "20") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size);
		List<Large> list = largeService.findList(large);
		PageInfo<Large> pageInfo = new PageInfo<Large>(list);
		
		return ResultGen.genSuccessResult(pageInfo);
	}
	
	/**
	 * 保存
	 * @param car
	 * @return
	 */
	@RequestMapping("save")
	public ResultObject save(Large large) {
		
		largeService.save(large);
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("delete")
	public ResultObject delete(String id) {
		
		largeService.delete(new Large(id));
		return ResultGen.genSuccessResult();
	}
	
}
