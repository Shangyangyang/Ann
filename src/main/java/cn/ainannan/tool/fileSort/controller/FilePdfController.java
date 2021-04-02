package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.tool.fileSort.bean.FilePdf;
import cn.ainannan.tool.fileSort.service.FilePdfService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 时光轴Controller
 * @author syy
 * @version 2018-09-26
 */
@RestController
@RequestMapping(value = "fileSort/filePdf")
public class FilePdfController {

	@Autowired
	private FilePdfService filePdfService;
	
//	@RequestMapping({ "", "findFlieList" })
//	public ResultObject list(FilePdf bean, HttpServletRequest request) {
//
//		return fileSortService.findFileList(bean);
//	}

	@RequestMapping("list")
	public ResultObject getFileInfo(FilePdf bean,@RequestParam(defaultValue = "1") Integer page,
									@RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size);

		List<FilePdf> list = filePdfService.findList(bean);
		PageInfo<FilePdf> pageInfo = new PageInfo<FilePdf>(list);

		return ResultGen.genSuccessResult(pageInfo);
	}

	@RequestMapping("get")
	public ResultObject get(FilePdf bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(filePdfService.get(bean));
	}
}