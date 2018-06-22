package cn.ainannan.sys.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.sys.menu.bean.Menu;
import cn.ainannan.sys.menu.service.MenuService;

@RestController
@RequestMapping("sys/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	@RequestMapping(value = "list")
	public ResultObject list(Menu menu) {
		List<Menu> menuList = menuService.findList(menu);
		return ResultGen.genSuccessResult(menuList);
	}
}
