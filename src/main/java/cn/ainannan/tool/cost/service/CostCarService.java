package cn.ainannan.tool.cost.service;

import cn.ainannan.base.bean.Tongji;
import cn.ainannan.base.service.MyBaseService;
import cn.ainannan.tool.cost.bean.CostCar;
import cn.ainannan.tool.cost.mapper.CostCarMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostCarService extends MyBaseService<CostCarMapper, CostCar> {
	public List<Tongji> findColumnData(Tongji bean){
		return baseMapper.findColumnData(bean);
	}
	public List<Tongji> tongjiByNianduCharts(CostCar bean){
		return baseMapper.tongjiByNianduCharts(bean);
	}
	public Tongji tongjiStr(CostCar bean){
		return baseMapper.tongjiStr(bean);
	}

}
