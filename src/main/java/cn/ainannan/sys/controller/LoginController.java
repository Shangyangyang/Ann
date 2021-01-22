package cn.ainannan.sys.controller;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.sys.bean.User;
import cn.ainannan.sys.service.UserService;
import cn.ainannan.sys.utils.PassUtil;
import cn.ainannan.sys.utils.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;

@RestController
@RequestMapping("sys/login")
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping({ "", "login" })
	public ResultObject checkUserName(HttpSession session, HttpServletRequest request, Model model) {
		String reg = request.getParameter("reg");
		if (StringUtils.isEmpty(reg)) {
			return ResultGen.genFailResult("请填写验证码");
		}

		String userName = request.getParameter("userName");
		if (StringUtils.isEmpty(userName)) {
			return ResultGen.genFailResult("请填写用户名");
		}

		String password = request.getParameter("password");
		if (StringUtils.isEmpty(password)) {
			return ResultGen.genFailResult("请填写密码");
		}

		/*if (!CaptchaController.check(session, reg)) {
			return ResultGen.genFailResult("验证码错误");
		}*/

		// 查询并验证用户密码
		User sysUser = getUserByUserName(userName);
		if (sysUser == null) {
			return ResultGen.genFailResult("用户名或密码错误");
		}

		if (!PassUtil.matches(password, sysUser.getPassword())) {
			return ResultGen.genFailResult("用户名或密码错误");
		}
		
		// 获取ip
		sysUser.setIp(this.getIpAddr(request));

		return writeSession(sysUser, session, false);
	}

	@RequestMapping("m/login")
	public ResultObject checkUserNameM(HttpSession session, HttpServletRequest request, Model model) {

		String userName = request.getParameter("userName");
		if (StringUtils.isEmpty(userName)) {
			return ResultGen.genFailResult("请填写用户名");
		}

		String password = request.getParameter("password");
		if (StringUtils.isEmpty(password)) {
			return ResultGen.genFailResult("请填写密码");
		}

		// 查询并验证用户密码
		User sysUser = getUserByUserName(userName);
		if (sysUser == null) {
			return ResultGen.genFailResult("用户名或密码错误");
		}

		if (!PassUtil.matches(password, sysUser.getPassword())) {
			return ResultGen.genFailResult("用户名或密码错误");
		}
		
		// 获取ip
		sysUser.setIp(this.getIpAddr(request));

		return writeSession(sysUser, session, true);
	}

    @RequestMapping ("getUser")
    public ResultObject getUser() {
        return ResultGen.genSuccessResult(UserUtil.getUser());
    }
	
	/**
	 * 登录成功后的写缓存操作
	 * 
	 * @param sysUser
	 * @param session
	 * @param isApp
	 *            移动端处理
	 * @return
	 */
	private ResultObject writeSession(User sysUser, HttpSession session, boolean isApp) {

		// 新增登录记录
		User recordUser = new User();
		recordUser.setUserName(sysUser.getUserName());
		recordUser.setPassword(sysUser.getPassword());
		recordUser.setIp(sysUser.getIp());
		recordUser.preInsert();

		userService.insertLoginRecord(recordUser);
		
		// 写入缓存
		UserUtil.setUserSession(sysUser);

		if (isApp) {
			return ResultGen.genSuccessResult(sysUser).setData2(session.getId());
		} else {
			return ResultGen.genSuccessResult(sysUser);
		}
	}

	/**
	 * 通过userName获取user对象
	 * 
	 * @param userName
	 * @return
	 */
	protected User getUserByUserName(String userName) {
		User user = new User();
		user.setUserName(userName);
		return userService.getUserByUserName(user);
	}

	/**
	 * @Description: 获取客户端IP地址
	 */
	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if (ip.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ip = inet.getHostAddress();
			}
		}
		// 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ip != null && ip.length() > 15) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		return ip;

	}
}
