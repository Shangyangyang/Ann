package cn.ainannan.timeline.picManager.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.timeline.picManager.bean.TimelineLabel;

/**
 * 时光轴DAO
 * @author syy
 * @version 2018-09-26
 */
@Mapper
public interface TimelineLabelMapper extends BaseDao<TimelineLabel> {
	/**
	 * 更新选择次数，自增一
	 * @param timelineLabel
	 */
	void updateSelectNum(TimelineLabel timelineLabel);
}