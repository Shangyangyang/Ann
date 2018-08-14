package cn.ainannan.tool.cost.dog.service;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.CrudService;
import cn.ainannan.tool.cost.dog.bean.Dog;
import cn.ainannan.tool.cost.dog.mapper.DogMapper;

@Service
public class DogService extends CrudService<DogMapper, Dog>{
}
