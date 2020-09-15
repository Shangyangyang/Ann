package cn.ainannan.tool.cost.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.tool.cost.bean.Car;
import cn.ainannan.tool.cost.bean.Tongji;
import cn.ainannan.tool.cost.mapper.CarMapper;

@Service
public class CarService extends BaseService<CarMapper, Car>{
	public List<Tongji> findColumnData(Tongji bean){
		return dao.findColumnData(bean);
	}
}
