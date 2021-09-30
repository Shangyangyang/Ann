package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.tool.fileSort.bean.FilePdfReadline;
import cn.ainannan.tool.fileSort.service.FilePdfReadlineService;
// import com.github.pagehelper.PageHelper;
// import com.github.pagehelper.PageInfo;
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
@RequestMapping(value = "fileSort/filePdfReadline")
public class FilePdfReadlineController {

	@Autowired
	private FilePdfReadlineService readlineService;
	
	@RequestMapping("list")
	public ResultObject getFileInfo(
			FilePdfReadline bean, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
		// Pagehelper.startPage(page, size);

		List<FilePdfReadline> list = readlineService.findList(bean);
		// PageInfo<w+> pageInfo = new PageInfo<FilePdfReadline>(list);

		return ResultGen.genSuccessResult();
	}
}