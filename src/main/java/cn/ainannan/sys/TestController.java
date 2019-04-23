package cn.ainannan.sys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ainannan.AnnApplication;
import cn.ainannan.timeline.picManager.service.ImportPicService;

@RestController
@RequestMapping("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AnnApplication.class) // 指定spring-boot的启动类
public class TestController {

	@Autowired
	private ImportPicService iService;

	@Test()
	public void addPic() {
		iService.addPic();	
	}
}
