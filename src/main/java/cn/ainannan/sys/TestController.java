package cn.ainannan.sys;

import java.io.File;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drew.imaging.ImageProcessingException;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.utils.ImageUtils;

@RestController
@RequestMapping("test")
public class TestController {
	
	@RequestMapping("getImageInfo")
	public ResultObject list() throws ImageProcessingException, Exception {
		File file = new File("H:\\尚羊羊\\图片\\个人相册\\2018\\IMG_20180803_150527.jpg");
		ImageUtils.printImageTags(file);
		return ResultGen.genSuccessResult();
	}
	
	
}
