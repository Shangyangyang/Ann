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
import cn.ainannan.tool.cost.bean.CostLijin;
import cn.ainannan.tool.cost.service.CostLijinService;

/**
 * 礼金Controller
 * @author syy
 * @version 2018-08-31
 */
@RestController
@RequestMapping(value = "costLijin")
public class CostLijinController {

	@Autowired
	private CostLijinService costLijinService;
	
	@RequestMapping({ "", "list" })
	public ResultObject list(CostLijin costLijin, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size);
		List<CostLijin> list = costLijinService.findList(costLijin);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGen.genSuccessResult(pageInfo);
	}

}