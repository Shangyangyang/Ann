package cn.ainannan.sys;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import cn.ainannan.AnnApplication;
import cn.ainannan.commons.utils.fingerPrint.FingerPrintUtils;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;

@RestController
@RequestMapping("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AnnApplication.class, 
				webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 指定spring-boot的启动类
public class TestController {

	@Autowired
	private TimelinePicMapper picDao;

	@Test()
	public void addPic() {
		List<TimelinePic> picList = picDao.findTempList();
		
		int count = 0;
		
		while(picList.size() > 0) {
			
			List<TimelinePic> saveList = Lists.newArrayList();
			
			picList.stream().forEach(item -> {
				System.out.println("==============================");
				String finger = null;
				try {
					finger = FingerPrintUtils.produceFingerPrint(item.getPath() + item.getFilename());
				} catch (Exception e) {
					System.out.println("出错的文件名:");
					System.out.println(item.getPath() + item.getFilename());
				}
				
				System.out.println(finger);
				if(null != finger) {

					TimelinePic pic = new TimelinePic();
					pic.setId(item.getId());
					pic.setFingerPrint(finger);
					
					saveList.add(pic);
				} else {
					System.out.println(item.getPath() + item.getFilename());
				}
			});
			System.out.println(saveList.size());
			
			TimelinePic pic = new TimelinePic();
			pic.setPicList(saveList);
			
			picDao.saveByList(pic);
			
			System.out.println("第 " + (++count) + " 轮执行完毕，共生成 " + saveList.size() + " 条记录。");
			
			picList = picDao.findTempList();
		}
		
	}
}
