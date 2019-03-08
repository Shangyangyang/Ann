package cn.ainannan.timeline.picManager.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.commons.Constant;
import cn.ainannan.commons.utils.UUIDUtils;
import cn.ainannan.timeline.picManager.bean.Timeline;
import cn.ainannan.timeline.picManager.bean.TimelineLabel;
import cn.ainannan.timeline.picManager.mapper.TimelineLabelMapper;
import cn.ainannan.timeline.picManager.mapper.TimelineMapper;

/**
 * 时光轴Service
 * 
 * @author syy
 * @version 2018-09-26
 */
@Service
@Transactional(readOnly = true)
public class TimelineLabelService extends BaseService<TimelineLabelMapper, TimelineLabel> {

	@Autowired
	private TimelineMapper timelineMapper;
	
	
	/**
	 * 更新选择次数，自增一
	 * @param timelineLabel
	 */
	@Transactional(readOnly = false)
	public void updateSelectNum(TimelineLabel timelineLabel) {
		dao.updateSelectNum(timelineLabel);
	}
	
	@Transactional(readOnly = false)
	public void save(TimelineLabel entity) {
		if (entity.isNewRecord()){
			entity.preInsert();
			entity.setId(UUIDUtils.generateShortUuid());
			dao.insert(entity);
		}else{
			entity.preUpdate();
			dao.update(entity);
		}
	}
	
	/**
	 * 将现有的标签与标签表中的数据对比，如果有则跳过，如果没有则插入到表中，
	 */
	@Transactional(readOnly = false)
	public void updateLabel() {
		/*
		 * 1. 取出标签表中的list集合
		 * 2. 取出所有的图片集合，过滤条件是标签不为空的
		 * 3. 判断如果标签ID为空的话，就是还没有转换的，
		 * 4. 将标签名分割为数组，挨个与标签表中的数据查询，
		 * 	如果没有则新增，并把新增的ID放到标签ID中，
		 * 	如果有则把ID放到标签ID中
		 * 
		 */
		
		// 获取数据
		List<TimelineLabel> tlList = this.findList(new TimelineLabel());
		List<Timeline> timelineList = timelineMapper.findListByLabelNotNull();
		// List<Timeline> newTimelineList = Lists.newArrayList();
		
		// 标签表的字符串集合，用作查询
		StringBuffer labelDB = new StringBuffer();
		
		for (TimelineLabel tl : tlList) {
			labelDB.append(tl.getName()).append(";");
		}
		
		// 分解、查询标签
		for (Timeline t : timelineList) {
			// 分解
			String [] labels = t.getLabel().split(",");

			StringBuffer labelIds = new StringBuffer();
			
			for (int i = 0; i < labels.length; i++) {
				// 保存用的图片对象，初始化数据
				Timeline tt = new Timeline();
				tt.setId(t.getId());
				
				// 如果标签在标签表的集合中能查询到，则进行for循环，查出ID
				if(labelDB.toString().indexOf(labels[i] + ";") > -1) {
					// 返回值是ID:NAME的字符串集合
					String str = this.getLabelId(tlList, labels[i]);
					String [] strs = str.split(",");
					
					labelIds.append(strs[0]).append(",");
				} else {
					// 如果没有在标签表里的新标签，进行新增操作
					/*
					 * 先创建标签，保存标签，返回ID/NAME给sb
					 * 把新增的标签名放到labelDB里
					 */
					
					// 初始化标签对象
					TimelineLabel tl = new TimelineLabel();
					tl.preInsert();
					tl.setId(UUIDUtils.generateShortUuid());
					tl.setName(labels[i]);
					tl.setStatus(Constant.LABEL_STATUS_WEI_TG);
					tl.setSelectNum(0);
					
					dao.insert(tl);
					
					labelIds.append(tl.getId()).append(",");
					
					labelDB.append(tl.getName()).append(";");
				}// 退出if
			}// 退出图片对象的labels循环
			
			// 这里封装pic对象，把labelId放到对象里， 并保存
			Timeline saveT = new Timeline();
			saveT.setId(t.getId());
			saveT.setLabelId(labelIds.toString());
			saveT.preUpdate();
			
			timelineMapper.update(saveT);
		}// 退回图片list循环
	}
	
	
	private String getLabelId(List<TimelineLabel> tlList, String label) {
		if(StringUtils.isBlank(label)) {
			return null;
		}
		
		StringBuffer str = new StringBuffer();
		
		for (TimelineLabel timelineLabel : tlList) {
			if(label.equals(timelineLabel.getName())) {
				str.append(timelineLabel.getId()).append(",").append(timelineLabel.getName());
				break;
			}
		}
		
		return str.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}