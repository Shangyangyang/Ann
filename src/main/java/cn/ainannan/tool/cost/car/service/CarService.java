package cn.ainannan.tool.cost.car.service;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.CrudService;
import cn.ainannan.tool.cost.car.bean.Car;
import cn.ainannan.tool.cost.car.mapper.CarMapper;

@Service
public class CarService extends CrudService<CarMapper, Car>{
}
