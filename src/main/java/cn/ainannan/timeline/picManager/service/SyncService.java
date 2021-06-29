package cn.ainannan.timeline.picManager.service;

import cn.ainannan.commons.utils.ImageUtils;
import cn.ainannan.commons.utils.StringUtils;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.bean.TimelineSimilar;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;
import cn.ainannan.timeline.picManager.mapper.TimelineSimilarMapper;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SyncService{
	
	@Autowired
	private TimelinePicMapper picMapper;
	@Autowired(required = false)
	private TimelineSimilarMapper similarMapper;
	
	private static final Float SIMILAR_MIN_SIZE = 90F;
	
	private static List<TimelinePic> picList2 = null;
	
	@Scheduled(cron = "0 */10 * * * ?")
	// @PostConstruct
	public void executedSimilarityCompute() {
		// 调取整个表，循环判断，并存储
		
		TimelinePic query = new TimelinePic();
		query.setSimilarStatus(0);
		query.setLimitNum(150);
		
		// PageHelper.startPage(1, 10);
		List<TimelinePic> picList = picMapper.findListFor1000(query);
		
		if(picList == null || picList.size() == 0) return;
		System.out.println("picList.size() = " + picList.size());
		if(null == picList2) {
			picList2 = picMapper.findTempList2();
		}
		
		TimelineSimilar ts = null;
		
		List<TimelineSimilar> saveList = Lists.newArrayList();

		List<TimelinePic> tpList = Lists.newArrayList();

		int count = 0;
		int computeNum = 0;
		Long curTime = new Date().getTime();

		for (TimelinePic p1 : picList) {
			Long curTime2 = new Date().getTime();
			List<TimelineSimilar> tsList = similarMapper.findList(new TimelineSimilar());
			for (TimelinePic p2 : picList2) {

				if(!p1.getShortId().equals(p2.getShortId()) 
						&& p1.getFingerPrint() != null 
						&& p2.getFingerPrint() != null) {
					float similar = StringUtils.getSimilarityRatio(p1.getFingerPrint(), p2.getFingerPrint());
										
					if(similar >= SIMILAR_MIN_SIZE) {

						ts = new TimelineSimilar();
						ts.setPicid(p1.getShortId());
						ts.setOtherid(p2.getShortId());
						ts.setSimilarity(similar);
						ts.setType(1);
						// 这里做数据库是否存在的判断
						Optional<TimelineSimilar> temp = tsList.stream()
								.filter(item ->
										(
												item.getPicid().equals(p1.getShortId()) &&
												item.getOtherid().equals(p2.getShortId())
										) ||
										(
												item.getPicid().equals(p2.getShortId()) &&
												item.getOtherid().equals(p1.getShortId())
										)
								).findAny();

						if(!temp.isPresent()) saveList.add(ts);
					}
				}

			}
			TimelinePic tp = new TimelinePic();
			tp.setId(p1.getId());
			tp.setSimilarStatus(1);

			tpList.add(tp);
			picMapper.updateByList(tpList);

			// 执行批量保存
			if(saveList.size() > 0) similarMapper.insertSimilarByList(saveList);
			computeNum += saveList.size();

			saveList = Lists.newArrayList();
			tpList = Lists.newArrayList();
			System.out.println("已处理条数 = " + ++count + ", 已发现重复条数 = " + computeNum
					+ ", 耗时 = " + (new Date().getTime() - curTime2));
		}

		System.out.println("本次共发现： " + computeNum);

	}
	
	
	//@Scheduled(cron = "*/20 * * * * ?")
	public void computeGeoXY() {
		// 调取整个表，循环判断，并存储
		
		TimelinePic query = new TimelinePic();
		query.setGeoIsNull("0");
		
		PageHelper.startPage(1, 150);
		List<TimelinePic> picList = picMapper.findList(query);
		
		if(picList == null || picList.size() == 0) return;
		
		List<TimelinePic> tpList = Lists.newArrayList();
		
		for (TimelinePic item : picList) {
			// gif跳过
			if(item.getFilename().contains("gif")) continue;
			
			try {
				String [] strs = ImageUtils.getGeoxy(item.getPath() + item.getFilename());
				
				TimelinePic tp = new TimelinePic();
				
				tp.setId(item.getId());
				
				if(strs != null && StringUtils.isNotBlank(strs[0]) && StringUtils.isNotBlank(strs[1])) {
					
					tp.setGeox(strs[0]);
					tp.setGeoy(strs[1]);
					
				} else {
					tp.setGeox("0");
					tp.setGeoy("0");
				}
				
				tpList.add(tp);
				
			} catch (JpegProcessingException | IOException e) {
				e.printStackTrace();
			}
		}
		
		if(tpList.size() > 0) picMapper.updateByList(tpList);
	}
}