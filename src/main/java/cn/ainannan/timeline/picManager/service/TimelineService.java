package cn.ainannan.timeline.picManager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.timeline.picManager.bean.Timeline;
import cn.ainannan.timeline.picManager.bean.TimelineTongji;
import cn.ainannan.timeline.picManager.mapper.TimelineMapper;

/**
 * 时光轴Service
 * 
 * @author syy
 * @version 2018-09-26
 */
@Service
@Transactional(readOnly = true)
public class TimelineService extends BaseService<TimelineMapper, Timeline> {
	/**
	 * 获取时光轴已筛选未筛选的
	 * @return 统计对象
	 */
	public TimelineTongji getTimelineInfo() {
		return dao.getTimelineInfo();
	}
	
	/**
	 * 根据时间类型查询列表
	 * @return
	 */
	public List<Timeline> findListByTimeType(Timeline timeline){
		return dao.findListByTimeType(timeline);
	}
	
	
	public void saveSkip(Timeline timeline) {
		dao.insertSkip(timeline);
	}

	public Map<String, Integer> getAllLabel() {
		// 用于存放字符以及出现次数的map
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// 新特性来判空
		Optional<String> strs = Optional.ofNullable(dao.getAllLabel());
		strs.ifPresent((labelStr) -> {
			
			// 将标签组拆解成数组
			String[] labels = labelStr.split(",");
			
			// 用于存放已经出现过的标签，在for循环中，如果在该字符串中能查找出，就说明没有必要再计算或者再加入到map里了。
			StringBuffer appearStr = new StringBuffer();
			for (int i = 0; i < labels.length; i++) {
				
				String str = labels[i];
				// 如果在字符串中能查找到，则跳过。
				if(appearStr.indexOf(str + ",") > -1)continue;
				
				// 下面是map里不包含该标签的情况处理
				appearStr.append(str).append(",");
				
				map.put(str, getNum(labels, str));
				
			}
		});

		return map;
	}
	
	private Integer getNum(String [] strs, String str) {
		int num = 0;
		for (int i = 0; i < strs.length; i++) {
			if(strs[i].equals(str)) {
				num++;
			}
		}
		return num;
	}
}