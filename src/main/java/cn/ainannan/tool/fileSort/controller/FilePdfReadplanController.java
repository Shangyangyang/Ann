package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.tool.fileSort.bean.FilePdfReadplan;
import cn.ainannan.tool.fileSort.service.FilePdfReadplanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

	@RequestMapping("list")
	public ResultObject getFileInfo(FilePdfReadplan bean, @RequestParam(defaultValue = "1") Integer page,
									@RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size);

		List<FilePdfReadplan> list = readplanService.findList(bean);
		PageInfo<FilePdfReadplan> pageInfo = new PageInfo<FilePdfReadplan>(list);

		return ResultGen.genSuccessResult(pageInfo);
	}

	@RequestMapping("get")
	public ResultObject get(FilePdfReadplan bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(readplanService.get(bean));
	}

	@RequestMapping("save")
	public ResultObject save(FilePdfReadplan bean, HttpServletRequest request) {
		readplanService.save(bean);
		return ResultGen.genSuccessResult();
	}

	@RequestMapping("delete")
	public ResultObject delete(FilePdfReadplan bean, HttpServletRequest request) {
		return readplanService.delete(bean);
	}

}