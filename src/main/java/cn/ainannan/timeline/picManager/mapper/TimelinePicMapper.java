package cn.ainannan.timeline.picManager.mapper;


import java.util.List;

import org.springframework.stereotype.Repository;

import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.timeline.picManager.bean.TimelinePic;

@Repository
public interface TimelinePicMapper extends BaseDao<TimelinePic> {
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
	
	/**
	 * 获取拍摄时间为空的记录
	 * @return
	 */
	TimelinePic getShotDateIsnull();
	List<TimelinePic> getAllShotDateIsnull();
	
	/**
	 * 根据指定条件查询指定条数的记录
	 * @param tp
	 * @return
	 */
	List<TimelinePic> findListFor1000(TimelinePic tp);

	void saveByList(TimelinePic savePic);
}
