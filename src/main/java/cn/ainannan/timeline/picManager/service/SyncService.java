package cn.ainannan.timeline.picManager.service;

import cn.ainannan.commons.utils.ImageUtils;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;
import com.drew.imaging.ImageProcessingException;
import com.google.common.collect.Lists;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class SyncService{
	
	@Autowired
	private TimelinePicMapper picMapper;

	// @PostConstruct
	public void linshi(){

		int totalLength = 15408;

		for(int i = 0; i < totalLength; i+=150){
			computeGeoXY();
		}


	}

	public void computeGeoXY() {
		// 调取整个表，循环判断，并存储

		TimelinePic query = new TimelinePic();
		List<TimelinePic> picList = picMapper.findGeoList(query);

		System.out.println("picList.size() = " + picList.size());

		if(picList == null || picList.size() == 0) return;
		List<TimelinePic> tpList = Lists.newArrayList();

		for (TimelinePic item : picList) {
			TimelinePic saveObj = new TimelinePic();

			saveObj.setId(item.getId());
			saveObj.preUpdate();

			if(item.getFilename().contains("gif")) {
				saveObj.setGeox("0");
				saveObj.setGeoy("0");
				saveObj.setId(item.getId());
			} else {

				String x = null;
				String y = null;
				String path = item.getPath() + File.separator + item.getFilename();

				try {
					x = ImageUtils.tranformPos(ImageUtils.getXYbyFile(path, "x"));
					y = ImageUtils.tranformPos(ImageUtils.getXYbyFile(path, "y"));

				} catch (ImageProcessingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				saveObj.setGeox(StringUtils.isBlank(x) ? "0" : x);
				saveObj.setGeoy(StringUtils.isBlank(y) ? "0" : y);

			}

			tpList.add(saveObj);
		}

		System.out.println("tpList.size() = " + tpList.size());
		System.out.println(" ====================================== ");

		if(tpList.size() > 0) picMapper.updateByList(tpList);
	}
}