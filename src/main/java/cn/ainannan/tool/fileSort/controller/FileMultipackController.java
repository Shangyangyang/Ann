package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.mybatisPlus.QueryGenerator;
import cn.ainannan.tool.fileSort.bean.FileMultipack;
import cn.ainannan.tool.fileSort.mapper.FileMultipackMapper;
import cn.ainannan.tool.fileSort.service.FileMultipackService;
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


@RestController
@RequestMapping(value = "file/multipack")
public class FileMultipackController {

	@Autowired
	private FileMultipackService fileMultipackService;
	@Autowired
	private FileMultipackMapper fileMultipackMapper;

	@RequestMapping("list")
	public ResultObject getFileInfo(FileMultipack bean, @RequestParam(defaultValue = "1") Integer page,
									@RequestParam(defaultValue = "10") Integer size, HttpServletRequest req) {
		QueryWrapper<FileMultipack> wrapper = QueryGenerator.initQueryWrapper(bean, req.getParameterMap());

		if(page == 0 && size == 0){
			return ResultGen.genSuccessResult(fileMultipackMapper.selectList(wrapper));
		} else {
			Page<FileMultipack> page2 = new Page<FileMultipack>(page, size);
			IPage<FileMultipack> list = fileMultipackMapper.selectPage(page2, wrapper);

			return ResultGen.genSuccessResult(list);
		}

	}

	@RequestMapping("get")
	public ResultObject get(FileMultipack bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(fileMultipackService.getById(bean.getId()));
	}

	@RequestMapping("save")
	public ResultObject save(FileMultipack bean, HttpServletRequest request) {

		fileMultipackService.save(bean);

		return ResultGen.genSuccessResult();
	}

	@RequestMapping("add")
	public ResultObject add(FileMultipack bean, HttpServletRequest request) {
		return fileMultipackService.add(bean);
	}

	@RequestMapping("delete")
	public ResultObject delete(FileMultipack bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(fileMultipackMapper.deleteById(bean.getId()));
	}

}