package cn.ainannan.sys.controller;

import java.util.ArrayList;
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
import cn.ainannan.sys.bean.Dict;
import cn.ainannan.sys.service.DictService;

@RestController
@RequestMapping("sys/dict")
public class DictController {
	@Autowired
	private DictService dictService;

	@RequestMapping({ "", "list" })
	public ResultObject list(Dict dict, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {

		PageHelper.startPage(page, size);
		List<Dict> list = dictService.findList(dict);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGen.genSuccessResult(pageInfo);
	}

	@RequestMapping(value = "lists")
	public ResultObject lists(String name, String id) {
		String[] names = name.split(",");
		List<List<Dict>> dictList = new ArrayList<List<Dict>>();

		for (int i = 0; i < names.length; i++) {
			Dict dict = new Dict();
			dict.setName(names[i]);
			List<Dict> list = dictService.findList(dict);
			dictList.add(list);
		}

		return ResultGen.genSuccessResult(dictList);
	}

	@RequestMapping(value = "add")
	public Boolean add(Dict dict) {
		dictService.save(dict);
		return true;
	}

	@RequestMapping(value = "addRecord")
	public Boolean addRecord(String type, String episode, String person, String ranking, String content, String ext1,
			String ext2) {
		System.out.println("执行");
		return true;
	}

	/**
	 * 通过名称、值来获取字典表的标签
	 * 
	 * @param dict
	 * @return
	 */
	@RequestMapping(value = "getLabelByName")
	public ResultObject getLabelByName(Dict dict) {
		return ResultGen.genSuccessResult(dictService.getLabelByName(dict));
	}
}
