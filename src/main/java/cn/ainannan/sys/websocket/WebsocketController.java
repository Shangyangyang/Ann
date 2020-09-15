package cn.ainannan.sys.websocket;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;

@RestController
@RequestMapping("sys/websocket-test")
public class WebsocketController {
	
	@RequestMapping(value = "getFuseridList")
	public ResultObject getFuseridList() {
		return ResultGen.genSuccessResult(WebSocketUtil.getFuseridList());
	}
	
	@RequestMapping(value = "websocketTest")
	public ResultObject websocketTest(String uuid) throws InterruptedException {
		
		if(null == uuid) return ResultGen.genSuccessResult();
		
		int i = 0;
		int sleepNum = 1000;
		
		while(i <= 100) {
			WebSocketUtil.sendMessage(uuid, String.valueOf(i));
			i = (int) (Math.random() * 5) + 1 + i;
			Thread.sleep(sleepNum);
		}
		
		return ResultGen.genSuccessResult();
	}

	@RequestMapping(value = "imitate")
	public void imitate(String uuid) throws InterruptedException {

		WebSocketUtil.sendObj(uuid, ResultGen.genSuccessResult(0).setName("jindutiao"));
		Thread.sleep(1000);
		for (int i = 0; i < 100;) {
			i += (int)(Math.random() * 40 + 1);
			if(i>100) i = 100;
			WebSocketUtil.sendObj(uuid, ResultGen.genSuccessResult(i).setName("jindutiao"));
			Thread.sleep(1000);
		}
	}
	
	// @Scheduled(cron = "0 */1 * * * ? ")
	public void testWebsocket() {
		System.out.println("定时任务执行");
		
		List<String> strList = WebSocketUtil.getFuseridList();

		System.out.println("strList = " + strList);

		strList.stream().forEach(item -> {

			WebSocketUtil.sendObj(item, ResultGen.genSuccessResult(item + ": 你好!").setName("test"));
		});
		
		
		
	}
}
