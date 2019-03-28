package cn.ainannan.timeline.picManager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.timeline.picManager.bean.TimelineLabelQuick;
import cn.ainannan.timeline.picManager.mapper.TimelineLabelQuickMapper;

/**
 * 时光轴标签快速选择service
 * @author syy
 * @version 2019年3月25日 上午9:07:31
 */
@Service
@Transactional(readOnly = true)
public class TimelineLabelQuickService extends BaseService<TimelineLabelQuickMapper, TimelineLabelQuick> {
	
}