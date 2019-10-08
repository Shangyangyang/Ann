package cn.ainannan.timeline.picManager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.timeline.picManager.bean.TimelineSimilar;
import cn.ainannan.timeline.picManager.mapper.TimelineSimilarMapper;

/**
 * 时光轴Service
 * 
 * @author syy
 * @version 2018-09-26
 */
@Service
@Transactional(readOnly = true)
public class TimelineSimilarService extends BaseService<TimelineSimilarMapper, TimelineSimilar> {

}