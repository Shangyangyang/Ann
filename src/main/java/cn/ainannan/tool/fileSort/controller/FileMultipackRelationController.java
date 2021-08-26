package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.tool.fileSort.bean.FileMultipackRelation;
import cn.ainannan.tool.fileSort.service.FileMultipackRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "file/multipack/relation")
public class FileMultipackRelationController {

	@Autowired
	private FileMultipackRelationService fileMultipackRelationService;
//
//	@RequestMapping("list")
//	public ResultObject getFileInfo(FileMultipack bean, @RequestParam(defaultValue = "1") Integer page,
//									@RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
//		PageHelper.startPage(page, size);
//
//		List<FileMultipack> list = fileMultipackService.findList(bean);
//		PageInfo<FileMultipack> pageInfo = new PageInfo<FileMultipack>(list);
//
//		return ResultGen.genSuccessResult(pageInfo);
//	}
//
//	@RequestMapping("get")
//	public ResultObject get(FileMultipack bean, HttpServletRequest request) {
//		return ResultGen.genSuccessResult(fileMultipackService.get(bean));
//	}

	@RequestMapping("save")
	public ResultObject save(FileMultipackRelation bean, HttpServletRequest request) {
		fileMultipackRelationService.save(bean);
		return ResultGen.genSuccessResult();
	}

	@RequestMapping("delete")
	public ResultObject delete(FileMultipackRelation bean, HttpServletRequest request) {
		return fileMultipackRelationService.delete(bean);
	}

}