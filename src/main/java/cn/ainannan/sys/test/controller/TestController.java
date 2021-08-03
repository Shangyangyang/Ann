package cn.ainannan.sys.test.controller;

import cn.ainannan.AnnApplication;
import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.utils.fingerPrint.FingerPrintUtils;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;
import cn.ainannan.timeline.picManager.service.SyncService;
import cn.ainannan.tool.dj.service.DjService;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("test")
// @RunWith(SpringJUnit4ClassRunner.class)
// junit5 改用以下方式
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AnnApplication.class, 
				webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 指定spring-boot的启动类
public class TestController {
	@Autowired
	private TimelinePicMapper picDao;

	@Autowired
	private SyncService syncService;
	@Autowired
	private DjService djService;
	

	@RequestMapping("index")
	public String index(){
		return "hello ann";
	}

	@RequestMapping("abc")
	public String abc(){
		return "hello abc";
	}

	@RequestMapping("ccc")
	public String ccc(){
		return "hello ccc";
	}

	/**
	 * mybatis 查询子集合的试验
	 */
	@Test()
	public void method2() {

	}
	
	public void method() {
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


	@RequestMapping("pubuList")
	public ResultObject pubuList(
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,
			HttpServletRequest request){

		List<Integer> iList = Lists.newArrayList();

		int s = page * size - size + 1;
		int e = page * size;

		for (int i = s; i <= e; i++){
			iList.add(i);
		}


		return ResultGen.genSuccessResult(iList);
	}
}
