package cn.ainannan.sys;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.util.FileUtils;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.google.common.collect.Lists;

import cn.ainannan.AnnApplication;
import cn.ainannan.commons.utils.fingerPrint.FingerPrintUtils;
import cn.ainannan.sys.test.DemoData;
import cn.ainannan.sys.test.TestFileUtil;
import cn.ainannan.timeline.picManager.bean.TimelinePic;
import cn.ainannan.timeline.picManager.mapper.TimelinePicMapper;
import cn.ainannan.timeline.picManager.service.SyncService;

@RestController
@RequestMapping("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AnnApplication.class, 
				webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 指定spring-boot的启动类
public class TestController {
	@Autowired
	private TimelinePicMapper picDao;
	
	@Autowired
	private SyncService syncService;
	
/*	@Test()
	public void addPic() {
		syncService.executedSimilarityCompute();
	}
*/	
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
}
