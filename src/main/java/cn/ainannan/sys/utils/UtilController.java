package cn.ainannan.sys.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.utils.UuidUtils;

@RestController
@RequestMapping("sys/util")
public class UtilController {
	
	
	@RequestMapping(value = "getShotUUID")
	public ResultObject getShotUUID() {
		return ResultGen.genSuccessResult(UuidUtils.generateShortUuid());
	}
}
