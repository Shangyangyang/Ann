package cn.ainannan.sys.websocket;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;

@RestController
@RequestMapping("sys/websocket")
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
	
	// @Scheduled(cron = "0 */1 * * * ? ")
	public void testWebsocket() {
		System.out.println("定时任务执行");
		
		List<String> strList = WebSocketUtil.getFuseridList();
		
		strList.stream().forEach(item -> {
			System.out.println(item);
			WebSocketUtil.sendMessage(item, item + "： 你好！");
		});
		
		
		
	}
}
