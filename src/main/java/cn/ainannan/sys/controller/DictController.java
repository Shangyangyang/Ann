package cn.ainannan.sys.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.mybatisPlus.QueryGenerator;
import cn.ainannan.sys.bean.SysDict;
import cn.ainannan.sys.mapper.DictMapper;
import cn.ainannan.sys.service.DictService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sys/dict")
public class DictController {
	@Autowired
	private DictService dictService;
	@Autowired
	private DictMapper dictMapper;

	@RequestMapping({ "", "list" })
	public ResultObject list(SysDict dict, @RequestParam(defaultValue = "1") Integer page,
							 @RequestParam(defaultValue = "10") Integer size, HttpServletRequest req) {

		QueryWrapper<SysDict> wrapper = QueryGenerator.initQueryWrapper(dict, req.getParameterMap());
		wrapper.orderByAsc("value");
		if(page == 0 && size == 0){
			return ResultGen.genSuccessResult(dictMapper.selectList(wrapper));
		} else {
			Page<SysDict> page2 = new Page<SysDict>(page, size);
			IPage<SysDict> list = dictMapper.selectPage(page2, wrapper);

			return ResultGen.genSuccessResult(list);
		}
	}

	@RequestMapping(value = "lists")
	public ResultObject lists(String name, String id) {
		String[] names = name.split(",");
		List<List<SysDict>> dictList = new ArrayList<List<SysDict>>();

		for (int i = 0; i < names.length; i++) {
			SysDict dict = new SysDict();
			dict.setName(names[i]);
			List<SysDict> list = dictService.list();
			dictList.add(list);
		}

		return ResultGen.genSuccessResult(dictList);
	}

	@RequestMapping(value = "add")
	public Boolean add(SysDict dict) {
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
	public ResultObject getLabelByName(SysDict dict) {
		return ResultGen.genSuccessResult(dictService.getLabelByName(dict));
	}
}
