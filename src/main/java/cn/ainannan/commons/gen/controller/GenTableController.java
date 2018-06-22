package cn.ainannan.commons.gen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.gen.bean.GenTable;
import cn.ainannan.commons.gen.service.GenTableService;

@RestController
@RequestMapping("gen/genTable")
public class GenTableController {
	
	@Autowired
	private GenTableService genTableService;
	
	
	@RequestMapping(value = "list")
	public ResultObject list(GenTable genTable, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<GenTable> list = genTableService.findList(genTable); 
        return ResultGen.genSuccessResult(list);
	}
}
