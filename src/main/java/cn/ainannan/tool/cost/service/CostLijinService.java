package cn.ainannan.tool.cost.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ainannan.base.service.CrudService;
import cn.ainannan.tool.cost.bean.CostLijin;
import cn.ainannan.tool.cost.mapper.CostLijinMapper;

/**
 * 礼金Service
 * @author syy
 * @version 2018-08-31
 */
@Service
@Transactional(readOnly = true)
public class CostLijinService extends CrudService<CostLijinMapper, CostLijin> {
	
}