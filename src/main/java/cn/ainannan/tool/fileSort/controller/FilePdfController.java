package cn.ainannan.tool.fileSort.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.mybatisPlus.QueryGenerator;
import cn.ainannan.tool.fileSort.bean.FilePdf;
import cn.ainannan.tool.fileSort.bean.FilePdfReadplan;
import cn.ainannan.tool.fileSort.mapper.FilePdfMapper;
import cn.ainannan.tool.fileSort.service.FilePdfReadlineService;
import cn.ainannan.tool.fileSort.service.FilePdfReadplanService;
import cn.ainannan.tool.fileSort.service.FilePdfService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

// import com.github.pagehelper.PageHelper;
// import com.github.pagehelper.PageInfo;

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
	@Autowired
	private FilePdfReadlineService readlineService;
	@Autowired
	private FilePdfReadplanService readplanService;
	@Autowired
	private FilePdfMapper filePdfMapper;

	@RequestMapping("list")
	public ResultObject getFileInfo(FilePdf bean,@RequestParam(defaultValue = "1") Integer pageNum,
									@RequestParam(defaultValue = "10") Integer pageSize, HttpServletRequest req) {
		QueryWrapper<FilePdf> wrapper = QueryGenerator.initQueryWrapper(bean, req.getParameterMap());

		Page<FilePdf> page = new Page<FilePdf>(pageNum, pageSize);
		IPage<FilePdf> list = filePdfMapper.selectPage(page, wrapper);

		return ResultGen.genSuccessResult(list);
	}

	@RequestMapping("get")
	public ResultObject get(FilePdf bean, HttpServletRequest request) {
		return ResultGen.genSuccessResult(filePdfService.getById(bean.getId()));
	}

	@RequestMapping("save")
	public ResultObject save(FilePdf bean, HttpServletRequest request) {
		filePdfService.save(bean);

		// 阅读进度的判断
		if(bean.getIsRead() != null && bean.getIsRead() == 1){
			bean.getReadline().setReadtime(new Date());
			readlineService.save(bean.getReadline());
		}

		return ResultGen.genSuccessResult();
	}

	@RequestMapping("endRead")
	public ResultObject endRead(FilePdf bean, HttpServletRequest request) {
		filePdfService.save(bean);

		// 阅读计划

		FilePdfReadplan queryFpr = new FilePdfReadplan();
		// 完成计划

		queryFpr.setPid(bean.getId());

		QueryWrapper<FilePdfReadplan> fprQuery = new QueryWrapper<FilePdfReadplan>();
		fprQuery.eq("pid", bean.getId());

		List<FilePdfReadplan> fprList = readplanService.list(fprQuery);

		if(fprList.size() <= 0) {
			return ResultGen.genSuccessResult();
		} else {
			queryFpr.setState("9");
			queryFpr.setId(fprList.get(0).getId());

			readplanService.save(queryFpr);
		}

		return ResultGen.genSuccessResult();
	}

	@RequestMapping("findAuthorList")
	public ResultObject findAuthorList(FilePdf bean, HttpServletRequest request) {

		return ResultGen.genSuccessResult(filePdfService.findAuthorList());
	}

	@RequestMapping("delete")
	public ResultObject delete(FilePdf bean, HttpServletRequest request) {
		return filePdfService.delete(bean);
	}
}