package cn.ainannan.tool.cost.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.tool.cost.bean.Car;
import cn.ainannan.tool.cost.bean.Tongji;
import cn.ainannan.tool.cost.mapper.CarMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService extends BaseService<CarMapper, Car>{
	public List<Tongji> findColumnData(Tongji bean){
		return dao.findColumnData(bean);
	}
	public List<Tongji> tongjiByNianduCharts(Car bean){
		return dao.tongjiByNianduCharts(bean);
	}

}
