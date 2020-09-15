package cn.ainannan.tool.cost.mapper;


import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.tool.cost.bean.Car;
import cn.ainannan.tool.cost.bean.Tongji;

@Repository
public interface CarMapper extends BaseDao<Car> {
	List<Tongji> findColumnData(Tongji bean);
}
