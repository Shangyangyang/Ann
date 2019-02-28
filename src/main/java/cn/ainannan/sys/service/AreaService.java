package cn.ainannan.sys.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.sys.bean.Area;
import cn.ainannan.sys.mapper.AreaMapper;

@Service
public class AreaService extends BaseService<AreaMapper, Area>{
	
	public List<Area> getListByRecursion(Area area){
		// Long startTime = new Date().getTime();
		if(StringUtils.isEmpty(area.getAreaCode())) return Lists.newArrayList();
		
		Area queryA = new Area();
		queryA.setAreaCodeL(this.splitCode(area.getAreaCode()));
		queryA.setIsRecursion("yes");
		List<Area> areaList = this.findList(queryA);
		List<Area> areaList2 = Lists.newArrayList();
		
		if(areaList.size() == 0) return Lists.newArrayList();
		
		for (Area area2 : areaList) {
			if(area2.getAreaCode().equals(area.getAreaCode())) {
				areaList2.add(area2);
				recursion(area2, areaList);
				break;
			}
		}
		// Long endTime = new Date().getTime();
		
		// System.out.println("耗时： " + ((endTime - startTime)) + " 毫秒");
		return areaList2;
	}
	
	public void recursion(Area area, List<Area> areaList){
		for (Area area2 : areaList) {
			if(null == area2.getParentCode()) continue;
			
			if(area2.getParentCode().equals(area.getAreaCode())) {
				if(area.getChildrenList() == null || area.getChildrenList().size() == 0) 
					area.setChildrenList(Lists.newArrayList());
				
				area.getChildrenList().add(area2);
				recursion(area2, areaList);
			}
		}
	}
	
	private String splitCode(String code) {
	    if(code.indexOf("0000000000") > -1)return code.substring(0, 2);
	    if(code.indexOf("00000000") > -1)return code.substring(0, 4);
	    if(code.indexOf("000000") > -1)return code.substring(0, 6);
	    if(code.indexOf("000") > -1)return code.substring(0, 9);
	    return code;
	}
}
