package cn.ainannan.tool.cost.mapper;


import cn.ainannan.base.bean.Tongji;
import cn.ainannan.tool.cost.bean.CostCar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostCarMapper extends BaseMapper<CostCar> {
	List<Tongji> findColumnData(Tongji bean);

	List<Tongji> tongjiByNianduCharts(CostCar bean);
	Tongji tongjiStr(CostCar bean);
}
