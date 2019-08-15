package cn.ainannan.timeline.picManager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.timeline.picManager.bean.Timeline;
import cn.ainannan.timeline.picManager.bean.TimelineTongji;

/**
 * 时光轴DAO
 * @author syy
 * @version 2018-09-26
 */
@Mapper
public interface TimelineMapper extends BaseDao<Timeline> {
	void insertSkip(Timeline timeline);
	String getAllLabel();
	List<Timeline> findListByLabelNotNull();
	/**
	 * 根据时间类型查询列表
	 * @return
	 */
	List<Timeline> findListByTimeType(Timeline timeline);
	
	/**
	 * 获取时光轴已筛选未筛选的
	 * @return 统计对象
	 */
	TimelineTongji getTimelineInfo();
}