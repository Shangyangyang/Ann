package cn.ainannan.fileSort.controller;

import cn.ainannan.base.result.ResultObject;
import cn.ainannan.fileSort.bean.FileSort;
import cn.ainannan.fileSort.service.FileSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 时光轴Controller
 * @author syy
 * @version 2018-09-26
 */
@RestController
@RequestMapping(value = "fileSort/fileSort")
public class FileSortController {

	@Autowired
	private FileSortService fileSortService;
	
	@RequestMapping({ "", "findFlieList" })
	public ResultObject list(FileSort bean, HttpServletRequest request) {

		System.out.println("bean.getFilePath() = " + bean.getFilePath());
		System.out.println("bean.getSuffixs() = " + bean.getSuffixs());

		return fileSortService.findFileList(bean);
	}
	


	
}