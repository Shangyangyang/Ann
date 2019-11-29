package cn.ainannan.timeline.picManager.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;

import cn.ainannan.commons.utils.ImageUtils;
import cn.ainannan.commons.utils.StringUtils;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.bean.TimelineSimilar;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;
import cn.ainannan.timeline.picManager.mapper.TimelineSimilarMapper;

@Service
public class SyncService{
	
	@Autowired
	private TimelinePicMapper picMapper;
	@Autowired
	private TimelineSimilarMapper similarMapper;
	
	private static final Float SIMILAR_MIN_SIZE = 90F;
	
	private static List<TimelinePic> picList2 = null;
	
	// @Scheduled(cron = "0 */3 * * * ?")
	public void executedSimilarityCompute() {
		// 调取整个表，循环判断，并存储
		
		TimelinePic query = new TimelinePic();
		query.setSimilarStatus(0);
		
		PageHelper.startPage(1, 150);
		List<TimelinePic> picList = picMapper.findList(query);
		
		if(picList == null || picList.size() == 0) return;
		
		if(null == picList2) {
			picList2 = picMapper.findTempList2();
		}
		
		TimelineSimilar ts = null;
		
		List<TimelineSimilar> tsList = Lists.newArrayList();
		List<TimelinePic> tpList = Lists.newArrayList();
		int count = 0;
		for (TimelinePic p1 : picList) {
			for (TimelinePic p2 : picList2) {
				if(!p1.getShortId().equals(p2.getShortId()) 
						&& p1.getFingerPrint() != null 
						&& p2.getFingerPrint() != null) {
					float similar = StringUtils.getSimilarityRatio(p1.getFingerPrint(), p2.getFingerPrint());
					
					System.out.println(similar);
					
					if(similar >= SIMILAR_MIN_SIZE) {
						ts = new TimelineSimilar();
						ts.setPicid(p1.getShortId());
						ts.setOtherid(p2.getShortId());
						ts.setSimilarity(similar);
						
						tsList.add(ts);
					}
				}
			}
			TimelinePic tp = new TimelinePic();
			tp.setId(p1.getId());
			tp.setSimilarStatus(1);
			
			tpList.add(tp);
			
			// 执行批量保存
			if(tsList.size() > 0) similarMapper.insertSimilarByList(tsList);
			count += tsList.size();
		}
		

		System.out.println("本次共发现： " + count);

		picMapper.updateByList(tpList);
	}
	
	
	@Scheduled(cron = "0 */1 * * * ?")
	public void computeGeoXY() {
		// 调取整个表，循环判断，并存储
		
		TimelinePic query = new TimelinePic();
		query.setGeoIsNull(0);
		
		PageHelper.startPage(1, 150);
		List<TimelinePic> picList = picMapper.findList(query);
		
		if(picList == null || picList.size() == 0) return;
		
		List<TimelinePic> tpList = Lists.newArrayList();
		
		for (TimelinePic item : picList) {
			try {
				String [] strs = ImageUtils.getGeoxy(item.getPath() + item.getFilename());
				
				if(StringUtils.isNotBlank(strs[0]) && StringUtils.isNotBlank(strs[1])) {
					TimelinePic tp = new TimelinePic();
					
					tp.setId(item.getId());
					tp.setGeox(strs[0]);
					tp.setGeoy(strs[1]);
					
					tpList.add(tp);
				}
				
			} catch (JpegProcessingException | IOException e) {
				e.printStackTrace();
			}
		}
		
		picMapper.updateByList(tpList);
	}
}