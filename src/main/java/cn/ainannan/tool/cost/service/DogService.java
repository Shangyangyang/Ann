package cn.ainannan.tool.cost.service;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.CrudService;
import cn.ainannan.tool.cost.bean.Dog;
import cn.ainannan.tool.cost.mapper.DogMapper;

@Service
public class DogService extends CrudService<DogMapper, Dog>{
}
