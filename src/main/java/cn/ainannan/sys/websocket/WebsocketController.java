package cn.ainannan.sys.websocket;

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
}
