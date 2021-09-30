package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.mybatisPlus.QueryGenerator;
import cn.ainannan.tool.fileSort.bean.FileMultipackRelation;
import cn.ainannan.tool.fileSort.mapper.FileMultipackRelationMapper;
import cn.ainannan.tool.fileSort.service.FileMultipackRelationService;
import com.alibaba.fastjson.JSONArray;
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
@RequestMapping(value = "file/multipack/relation")
public class FileMultipackRelationController {

	@Autowired
	private FileMultipackRelationService fileMultipackRelationService;
	@Autowired
	private FileMultipackRelationMapper relationMapper;

	@RequestMapping("list")
	public ResultObject getFileInfo(FileMultipackRelation bean, @RequestParam(defaultValue = "1") Integer page,
									@RequestParam(defaultValue = "10") Integer size, HttpServletRequest req) {
		QueryWrapper<FileMultipackRelation> wrapper = QueryGenerator.initQueryWrapper(bean, req.getParameterMap());

		if(page == 0 && size == 0){
			return ResultGen.genSuccessResult(relationMapper.selectList(wrapper));
		} else {
			Page<FileMultipackRelation> page2 = new Page<FileMultipackRelation>(page, size);
			IPage<FileMultipackRelation> list = relationMapper.selectPage(page2, wrapper);

			return ResultGen.genSuccessResult(list);
		}

	}

	@RequestMapping("get")
	public ResultObject get(FileMultipackRelation bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(fileMultipackRelationService.getById(bean.getId()));
	}

	@RequestMapping("save")
	public ResultObject save(FileMultipackRelation bean, HttpServletRequest request) {
		fileMultipackRelationService.save(bean);
		return ResultGen.genSuccessResult();
	}

	@RequestMapping("saveByList")
	public ResultObject saveByList(FileMultipackRelation bean, HttpServletRequest request) {
	    List<FileMultipackRelation> fmrList = JSONArray.parseArray(bean.getList(), FileMultipackRelation.class);
		bean.setFmrList(fmrList);
	    fileMultipackRelationService.saveByList(bean);
		return ResultGen.genSuccessResult();
	}

	@RequestMapping("delete")
	public ResultObject delete(FileMultipackRelation bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(relationMapper.deleteById(bean.getId()));
	}

}