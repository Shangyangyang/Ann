package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.tool.fileSort.bean.FileMultipack;
import cn.ainannan.tool.fileSort.service.FileMultipackService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping(value = "file/multipack")
public class FileMultipackController {

	@Autowired
	private FileMultipackService fileMultipackService;

	@RequestMapping("list")
	public ResultObject getFileInfo(FileMultipack bean, @RequestParam(defaultValue = "1") Integer page,
									@RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size);

		List<FileMultipack> list = fileMultipackService.findList(bean);
		PageInfo<FileMultipack> pageInfo = new PageInfo<FileMultipack>(list);

		return ResultGen.genSuccessResult(pageInfo);
	}

	@RequestMapping("get")
	public ResultObject get(FileMultipack bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(fileMultipackService.get(bean));
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
		return fileMultipackService.delete(bean);
	}

}