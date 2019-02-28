package cn.ainannan.sys.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.commons.utils.MD5Utils;
import cn.ainannan.sys.bean.User;
import cn.ainannan.sys.service.UserService;

@RestController
@RequestMapping("sys/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping({"","list"})
	public ResultObject list(User user, @RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "20") Integer size, HttpServletRequest request) {
		PageHelper.startPage(page, size);
		
		List<User> list = userService.findList(user);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGen.genSuccessResult(pageInfo);
	}
	
	@RequestMapping("add")
	public ResultObject add(User user) {
		// 检查空值，检查用户名是否存在
		if(null == user.getUserName() || null == user.getName() || null == user.getPassword())
			return ResultGen.genFailResult("用户信息不完整，注册失败！");
		User serarch = new User();
		serarch.setUserName(user.getUserName());
		if(userService.checkUserName(serarch) != null) return ResultGen.genFailResult("该账号已经存在！");
		
		user.setState("1");
		user.setPassword(MD5Utils.getMD5(user.getPassword()));	// 转码
		userService.save(user);
		
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("updateState")
	public ResultObject freeze(User user) {
		if(user.getId() == null || "".equals(user.getId()) 
				|| user.getState() == null || "".equals(user.getState()))
			return ResultGen.genFailResult("缺少关键参数！");
		userService.save(user);
		return ResultGen.genSuccessResult();
	}
	
	@RequestMapping("checkUserName")
	public ResultObject checkUserName(User user){
		if(userService.checkUserName(user) != null) {
			return ResultGen.genFailResult("该账号已经存在！");
		}else {
			return ResultGen.genSuccessResult();
		}
	}
	
}
