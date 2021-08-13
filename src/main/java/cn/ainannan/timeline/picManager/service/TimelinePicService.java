package cn.ainannan.timeline.picManager.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.commons.utils.FileUtils;
import cn.ainannan.commons.utils.StringUtils;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimelinePicService extends BaseService<TimelinePicMapper, TimelinePic>{

	@Value("${myPic-basePath}")
	private String BASE_PATH;
	@Value("${myPanfu}")
	private String BASE_PANFU;

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

	public List<TimelinePic> findListFor1000(TimelinePic tp) {
		return dao.findListFor1000(tp);
	}
	
	/**
	 * 获取相似照片的集合
	 * @param tp
	 * @return
	 */
	public List<TimelinePic> findSimilarImgList(TimelinePic tp) {
		return dao.findSimilarImgList(tp);
	}

	/**
	 * 获取到指定经纬度附近的照片列表
	 * @param tp
	 * @return
	 */
	public List<TimelinePic> findGeoAdjoinList(TimelinePic tp) {
		return dao.findGeoAdjoinList(tp);
	}

	/**
	 * 以list的形式更新数据
	 * @param savePic
	 */
	public void saveByList(TimelinePic savePic) {
		dao.saveByList(savePic);
	}

	/**
	 * 获取指定图片相似的图片的集合
	 * @param timelinePic
	 * @return
	 */
	public List<TimelinePic> getSimilarImgList(TimelinePic timelinePic) {
		TimelinePic thisPic = dao.get(timelinePic.getId());
		
		List<TimelinePic> list = dao.getFingerPrintList(timelinePic);
		
		List<TimelinePic> resultList = list.stream().filter(item -> 
			StringUtils.getSimilarityRatio(thisPic.getFingerPrint(), item.getFingerPrint()) > 88F && !thisPic.getId().equals(item.getId()))
			.collect(Collectors.toList());
		
		System.out.println("thisFinger: " + thisPic.getFingerPrint());
		
		resultList.stream().forEach(item -> {
			System.out.println(item.getFingerPrint());
		});
		
		return resultList;
	}

	public List<TimelinePic> getFingerPrintList(TimelinePic queryPic) {
		return dao.getFingerPrintList(queryPic);
	}
	
	
	
	public List<TimelinePic> findListByFinger(TimelinePic pic){
		return dao.findListByFinger(pic);
	}
	public List<TimelinePic> findListByShortId(TimelinePic timelinePic){
		return dao.findListByShortId(timelinePic);
	}

	public void getImg(String id, String type, HttpServletResponse resp) {
		if(type == null || "".equals(type.trim())) return;
		TimelinePic bean = dao.getUrl(id);
		String filePath = this.changePath("1".equals(type) ? bean.getSrcThumbnail() : bean.getSrc());
		returnImg(filePath, resp);
	}

	public void returnImg(String filePath, HttpServletResponse resp) {
		File file = new File(filePath);

		try {
			FileUtils.sendFile(file, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String changePath(String path) {
		return this.BASE_PANFU + File.separator + this.BASE_PATH + File.separator + path;
	}

    public TimelinePic getRandomImg() {
		return dao.getRandomImg();
    }
}
