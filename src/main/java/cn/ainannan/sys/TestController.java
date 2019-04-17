package cn.ainannan.sys;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ainannan.AnnApplication;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.service.TimelinePicService;

@RestController
@RequestMapping("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AnnApplication.class) // 指定spring-boot的启动类
public class TestController {

	@Autowired
	private TimelinePicService timelinePicService;

	@Test()
	public void findListByTimeType() {
		
		TimelinePic tp = new TimelinePic();
		tp.setLimitNum(10);
		tp.setThumbnailFlag("0");
		
		List<TimelinePic> tpList = timelinePicService.findListFor1000(tp);
		
		for (TimelinePic timelinePic : tpList) {
			System.out.println(timelinePic.getPath() + timelinePic.getFilename());
		}
		
		
		
	}
}
