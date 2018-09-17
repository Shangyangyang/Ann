package cn.ainannan.timeline.picManager.mapper;


import java.util.List;

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
	
	/**
	 * 获取相同MD5的数据
	 * @return
	 */
	List<TimelinePic> getEqualMd5();
	
	/**
	 * 获取文件指纹相同的数据
	 * @return
	 */
	List<TimelinePic> getEqualFingerPrint();
}
