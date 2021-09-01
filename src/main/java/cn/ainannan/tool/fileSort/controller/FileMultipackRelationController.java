package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.tool.fileSort.bean.FileMultipackRelation;
import cn.ainannan.tool.fileSort.service.FileMultipackRelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

	@RequestMapping("list")
	public ResultObject getFileInfo(FileMultipackRelation bean, @RequestParam(defaultValue = "1") Integer page,
									@RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size);

		List<FileMultipackRelation> list = fileMultipackRelationService.findList(bean);
		PageInfo<FileMultipackRelation> pageInfo = new PageInfo<FileMultipackRelation>(list);

		return ResultGen.genSuccessResult(pageInfo);
	}

	@RequestMapping("get")
	public ResultObject get(FileMultipackRelation bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(fileMultipackRelationService.get(bean));
	}

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