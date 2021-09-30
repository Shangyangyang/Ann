package cn.ainannan.tool.cost.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.utils.DateUtil;
import cn.ainannan.commons.utils.excel.ExcelData;
import cn.ainannan.commons.utils.excel.ExportExcelUtils;
import cn.ainannan.tool.cost.bean.CostLijin;
import cn.ainannan.tool.cost.service.CostLijinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 礼金Controller
 * @author syy
 * @version 2018-08-31
 */
@RestController
@RequestMapping(value = "cost/lijin")
public class CostLijinController {

	@Autowired
	private CostLijinService costLijinService;
	@Value("${ecxel-basePath}")
	private String basePath;
    @Value("${myPanfu}")
    private String basePanfu;
	
	@RequestMapping({ "", "list" })
	public ResultObject list(CostLijin costLijin, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer size, HttpServletRequest request) {
		// Pagehelper.startPage(page, size);
		List<CostLijin> list = costLijinService.findList(costLijin);
		// PageInfo pageInfo = new PageInfo(list);
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("save")
	public ResultObject save(CostLijin lijin) {
		costLijinService.save(lijin);
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("delete")
	public ResultObject delete(String id) {
		
		costLijinService.delete(new CostLijin(id));
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("exportExcel")
	public ResultObject exportExcel(CostLijin costLijin, HttpServletResponse response) throws Exception {
		
		// 获取List
		List<CostLijin> lijinList = costLijinService.findList(costLijin);
		
		// 设置表头
		ExcelData data = new ExcelData();
        data.setName("礼金");
        List<String> titles = new ArrayList();
        titles.add("姓名");
        titles.add("金额");
        titles.add("录入日期");
        titles.add("说明");
        titles.add("类型");
        titles.add("关联人");
        titles.add("是否已还");
        titles.add("已还金额");
        titles.add("已还日期");
        data.setTitles(titles);
        
        List<List<Object>> rows = new ArrayList();
        
        for(CostLijin lj : lijinList) {
        	
        	List<Object> row = new ArrayList();
        	
            row.add(lj.getName());
            row.add(lj.getMoney());
            row.add(DateUtil.getStrDate(lj.getInputDate()));
            row.add(lj.getReason());
            row.add(lj.getTypeName());
            row.add(lj.getGuishurenName());
            row.add(lj.getIsyihuanName());
            row.add(lj.getYihuanMoney());
            row.add(DateUtil.getStrDate(lj.getYihuanDate()));
            
            rows.add(row);
        }


        data.setRows(rows);


        //生成本地
        String filePath = DateUtil.getStrCurrDate("yyyy-MM");
        String fileName = "礼金-" + DateUtil.getStrCurrDate("yyyyMMddHHmmss") + ".xlsx";
        String baseFileName = basePanfu + basePath + filePath + File.separatorChar + fileName;
        
        File f = new File(baseFileName);
        File path = new File(basePanfu + basePath + filePath);
        if(!path.exists()) {
        	path.mkdirs();  
        }
        
        FileOutputStream out = new FileOutputStream(f);
        ExportExcelUtils.exportExcel(data, out);
        out.close();
        
        // ExportExcelUtils.exportExcel(response,"hello.xlsx",data);
        
        return ResultGen.genSuccessResult(filePath + File.separatorChar + fileName);
	}

}