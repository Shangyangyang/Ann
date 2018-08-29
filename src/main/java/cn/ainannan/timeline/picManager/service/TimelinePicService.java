package cn.ainannan.timeline.picManager.service;

import org.springframework.stereotype.Service;

import cn.ainannan.base.service.CrudService;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;

@Service
public class TimelinePicService extends CrudService<TimelinePicMapper, TimelinePic>{
	/**
	 * 获取图片库最近状态（总数、最新拍摄日期、最近导入日期）
	 * @return
	 */
	public TimelinePic getLastStatus() {
		return dao.getLastStatus();
	}
}
