package cn.ainannan.timeline.picManager.mapper;

import cn.ainannan.timeline.picManager.bean.TimelineLabel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 时光轴DAO
 * @author syy
 * @version 2018-09-26
 */
@Mapper
public interface TimelineLabelMapper extends BaseMapper<TimelineLabel> {
	/**
	 * 更新选择次数，自增一
	 * @param timelineLabel
	 */
	void updateSelectNum(TimelineLabel timelineLabel);
}