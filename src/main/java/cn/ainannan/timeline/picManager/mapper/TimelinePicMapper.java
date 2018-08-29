package cn.ainannan.timeline.picManager.mapper;


import org.springframework.stereotype.Repository;

import cn.ainannan.base.dao.CrudDao;
import cn.ainannan.timeline.picManager.bean.TimelinePic;

@Repository
public interface TimelinePicMapper extends CrudDao<TimelinePic> {
	/**
	 * 获取图片库最近状态（总数、最新拍摄日期、最近导入日期）
	 * @return
	 */
	TimelinePic getLastStatus();
}
