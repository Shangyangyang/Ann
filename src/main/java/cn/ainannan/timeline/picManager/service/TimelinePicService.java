package cn.ainannan.timeline.picManager.service;

import java.util.List;

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

	/**
	 * 获取相同MD5的数据
	 * @return
	 */
	public List<TimelinePic> getEqualMd5(){
		return dao.getEqualMd5();
	}
	
	/**
	 * 获取相同文件指纹的数据
	 * @return
	 */
	public List<TimelinePic> getEqualFingerPrint(){
		return dao.getEqualFingerPrint();
	}
	
	/**
	 * 获取拍摄时间为空的记录
	 * @return
	 */
	public TimelinePic getShotDateIsnull() {
		return dao.getShotDateIsnull();
	}

	public List<TimelinePic> getAllShotDateIsnull() {
		return dao.getAllShotDateIsnull();
	}
}
