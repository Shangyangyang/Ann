package cn.ainannan.timeline.picManager.mapper;


import cn.ainannan.base.dao.BaseDao;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import org.springframework.stereotype.Repository;

import java.util.List;

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
	 * 获取相似照片的集合
	 * @return
	 */
	List<TimelinePic> findSimilarImgList(TimelinePic tp);
	
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

	List<TimelinePic> getFingerPrintList(TimelinePic tp);
	List<TimelinePic> findTempList();
	// 循环比对finger的列表
	List<TimelinePic> findTempList2();

	/**
	 * 获取去重对比的列表，特定字段。
	 * @return
	 */
	List<TimelinePic> findListByFinger(TimelinePic pic);

    /**
     * 根据短id获取相似图列表
     * @return
     */
	List<TimelinePic> findListByShortId(TimelinePic timelinePic);

	/**
	 * 批量插入，参数为list
	 * @param list
	 */
	void insertByList(List<TimelinePic> list);
	void saveByList(TimelinePic savePic);

	void updateByList(List<TimelinePic> list);

	TimelinePic getUrl(String id);
}
