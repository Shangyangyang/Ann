package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.mybatisPlus.QueryGenerator;
import cn.ainannan.tool.fileSort.bean.FilePdfReadplan;
import cn.ainannan.tool.fileSort.mapper.FilePdfReadplanMapper;
import cn.ainannan.tool.fileSort.service.FilePdfReadplanService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping(value = "file/pdf/readplan")
public class FilePdfReadplanController {

	@Autowired
	private FilePdfReadplanService readplanService;
	@Autowired
	private FilePdfReadplanMapper readplanMapper;


	@RequestMapping("list")
	public ResultObject getFileInfo(FilePdfReadplan bean, @RequestParam(defaultValue = "1") Integer page,
									@RequestParam(defaultValue = "10") Integer size, HttpServletRequest req) {
		QueryWrapper<FilePdfReadplan> wrapper = QueryGenerator.initQueryWrapper(bean, req.getParameterMap());

		if(bean.getStates() != null && bean.getStates().length > 0){

			for (int i = 0; i < bean.getStates().length; i++) {
				wrapper.eq("state", bean.getStates()[i]);

				if(i < bean.getStates().length - 1){
					wrapper.or();
				}
			}
		}

		if(page == 0 && size == 0){
			return ResultGen.genSuccessResult(readplanMapper.selectList(wrapper));
		} else {
			Page<FilePdfReadplan> page2 = new Page<FilePdfReadplan>(page, size);
			IPage<FilePdfReadplan> list = readplanMapper.selectPage(page2, wrapper);

			return ResultGen.genSuccessResult(list);
		}
	}


	@RequestMapping("findList")
	public ResultObject findList(FilePdfReadplan bean, @RequestParam(defaultValue = "1") Integer page,
									@RequestParam(defaultValue = "10") Integer size, HttpServletRequest req) {

		IPage<FilePdfReadplan> queryPage = new Page<FilePdfReadplan>(page, size);
		List<FilePdfReadplan> list = readplanMapper.findList(queryPage, bean);

		return ResultGen.genSuccessResult(list);
	}


	@RequestMapping("get")
	public ResultObject get(FilePdfReadplan bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(readplanService.getById(bean.getId()));
	}


	@RequestMapping("getPastReadNum")
	public ResultObject getPastReadNum(FilePdfReadplan bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(readplanService.getPastReadNum(bean));
	}

	@RequestMapping("save")
	public ResultObject save(FilePdfReadplan bean, HttpServletRequest request) {
		readplanService.save(bean);
		return ResultGen.genSuccessResult();
	}

	@RequestMapping("delete")
	public ResultObject delete(FilePdfReadplan bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(readplanMapper.deleteById(bean.getId()));
	}

}