package cn.ainannan.timeline.picManager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.timeline.picManager.bean.TimelineSimilar;

@Mapper
public interface TimelineSimilarMapper extends BaseDao<TimelineSimilar> {

	@Transactional(readOnly = false)
	void insertSimilarByList(List<TimelineSimilar> list);
}