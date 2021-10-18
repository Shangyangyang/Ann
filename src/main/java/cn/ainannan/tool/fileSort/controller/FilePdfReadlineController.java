package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.mybatisPlus.QueryGenerator;
import cn.ainannan.tool.fileSort.bean.FilePdfReadline;
import cn.ainannan.tool.fileSort.mapper.FilePdfReadlineMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

// import com.github.pagehelper.PageHelper;
// import com.github.pagehelper.PageInfo;

/**
 * 时光轴Controller
 * @author syy
 * @version 2018-09-26
 */
@RestController
@RequestMapping(value = "fileSort/filePdfReadline")
public class FilePdfReadlineController {

	@Autowired(required = false)
	private FilePdfReadlineMapper readlineMapper;

	
	@RequestMapping("list")
	public ResultObject list(
			FilePdfReadline bean, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size, HttpServletRequest req) {
		QueryWrapper<FilePdfReadline> wrapper = QueryGenerator.initQueryWrapper(bean, req.getParameterMap());
		wrapper.orderByAsc("readtime");

		if(page == 0 && size == 0){
			return ResultGen.genSuccessResult(readlineMapper.selectList(wrapper));
		} else {
			Page<FilePdfReadline> page2 = new Page<FilePdfReadline>(page, size);
			IPage<FilePdfReadline> list = readlineMapper.selectPage(page2, wrapper);

			return ResultGen.genSuccessResult(list);
		}
	}
}