package cn.ainannan.tool.cost.mapper;


import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.tool.cost.bean.Car;
import cn.ainannan.tool.cost.bean.Tongji;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper extends BaseDao<Car> {
	List<Tongji> findColumnData(Tongji bean);

	List<Tongji> tongjiByNianduCharts(Car bean);
}
