package cn.ainannan.timeline.picManager.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.timeline.picManager.bean.Timeline;

/**
 * 时光轴DAO
 * @author syy
 * @version 2018-09-26
 */
@Mapper
public interface TimelineMapper extends BaseDao<Timeline> {
	void insertSkip(Timeline timeline);
}