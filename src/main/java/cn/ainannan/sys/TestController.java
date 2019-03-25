package cn.ainannan.sys;

import java.util.Random;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.ainannan.AnnApplication;
import cn.ainannan.timeline.picManager.service.TimelineLabelService;

@RestController
@RequestMapping("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AnnApplication.class) // 指定spring-boot的启动类
public class TestController {

	@Autowired
	private TimelineLabelService tlService;

	@Test()
	public void test() throws InterruptedException {
		getCitizen("周继鹏", "230506198411250712");
	}

	public static String getCitizen(String name, String idcard) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	
		map.add("name", name);
		map.add("idcard", idcard);
	
		String ret = restPost("http://zhcl.jinandpf.org/rkk/citizenInfoAPI/getByIdcard", map);
		
		getObj(ret);
		
		return null;
	}
	
	public static Object getObj(String jsonStr) {
		JSONObject json = null;
		try {
			json = new JSONObject(jsonStr);
			System.out.println(((JSONObject) json.get("data")).get("conPhone"));
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static String restPost(String getUrl, MultiValueMap<String, String> map) {
		// 请求头设置
		HttpHeaders headers = new HttpHeaders();
		// 设置contentType为表单提交
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// 参数，以map的形式传递，并加上请求头
		HttpEntity<MultiValueMap<String, String>> request2 = new HttpEntity<MultiValueMap<String, String>>(map,
				headers);
		
		// 创建结果集模板
		RestTemplate restTemplate = new RestTemplate();
		 
        /**
         * exchange 方法的参数说明
         * url - 网址
		 * method - HTTP方法（GET，POST等）
		 * requestEntity- 写入请求的实体（标题和/或正文）可能是null）
		 * responseType - 返回值的类型
		 * uriVariables - 要在模板中展开的变量
         */
		ResponseEntity<String> retStr1 = restTemplate.exchange(getUrl, HttpMethod.POST, request2, String.class);
		
		// 返回值是ResponseEntity，返回值是带着code的模板，通过getBody获取json内容
		return retStr1.getBody();
	}

	public static String getColor() {
		int r = new Random().nextInt(255 - 150) + 150;
		int g = new Random().nextInt(255 - 150) + 150;
		int b = new Random().nextInt(255 - 150) + 150;

		String rgb = r + "," + g + "," + b;

		return "rgb(" + rgb + ")";
	}

}
