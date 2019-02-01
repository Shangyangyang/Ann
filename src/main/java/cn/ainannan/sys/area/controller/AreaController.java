package cn.ainannan.sys.area.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.sys.area.bean.Area;
import cn.ainannan.sys.area.service.AreaService;

@RestController
@RequestMapping("sys/area")
public class AreaController {
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value="list")
    public ResultObject list(Area area){
        List<Area> list = areaService.findList(area); 
        return ResultGen.genSuccessResult(list);
    }
	
	/**
	 * 递归获取数据
	 * @param area
	 * @return
	 */
	@RequestMapping(value="getListByRecursion")
	public ResultObject getListByRecursion(Area area){
		return ResultGen.genSuccessResult(areaService.getListByRecursion(area));
	}
	
}
