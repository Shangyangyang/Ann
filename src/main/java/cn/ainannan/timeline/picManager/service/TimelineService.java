package cn.ainannan.timeline.picManager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.timeline.picManager.bean.Timeline;
import cn.ainannan.timeline.picManager.mapper.TimelineMapper;

/**
 * 时光轴Service
 * @author syy
 * @version 2018-09-26
 */
@Service
@Transactional(readOnly = true)
public class TimelineService extends BaseService<TimelineMapper, Timeline> {
	
	@Transactional(readOnly = false)
	public void saveSkip(Timeline timeline) {
		dao.insertSkip(timeline);		
	}
	
}