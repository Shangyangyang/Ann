package cn.ainannan.tool.cost.service;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.CrudService;
import cn.ainannan.tool.cost.bean.Car;
import cn.ainannan.tool.cost.mapper.CarMapper;

@Service
public class CarService extends CrudService<CarMapper, Car>{
}
