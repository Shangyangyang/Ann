package cn.ainannan.tool.cost.mapper;


import org.springframework.stereotype.Repository;

import cn.ainannan.base.dao.CrudDao;
import cn.ainannan.tool.cost.bean.Dog;

@Repository
public interface DogMapper extends CrudDao<Dog> {
}
