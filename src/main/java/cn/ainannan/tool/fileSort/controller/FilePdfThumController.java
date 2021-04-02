package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.tool.fileSort.bean.FilePdfThum;
import cn.ainannan.tool.fileSort.service.FilePdfThumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 时光轴Controller
 * @author syy
 * @version 2018-09-26
 */
@RestController
@RequestMapping(value = "fileSort/filePdfThum")
public class FilePdfThumController {

	@Autowired
	private FilePdfThumService filePdfThumService;
	
	@RequestMapping("list")
	public ResultObject getFileInfo(
			FilePdfThum bean, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size);

		List<FilePdfThum> list = filePdfThumService.findList(bean);
		PageInfo<FilePdfThum> pageInfo = new PageInfo<FilePdfThum>(list);

		return ResultGen.genSuccessResult(pageInfo);
	}

	@RequestMapping("get")
	public ResultObject get(FilePdfThum bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(filePdfThumService.get(bean));
	}

	@RequestMapping("getImg")
	public void getImg(String id, HttpServletRequest request, HttpServletResponse resp) {
		filePdfThumService.getImg(id, resp);
	}

	@RequestMapping("getImgByThum")
	public void getImgByThum(FilePdfThum thum, HttpServletRequest request, HttpServletResponse resp) {
		filePdfThumService.getImgByThum(thum, resp);
	}

}