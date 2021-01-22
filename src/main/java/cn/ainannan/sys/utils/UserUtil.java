package cn.ainannan.sys.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.ainannan.commons.Constant;
import cn.ainannan.sys.bean.User;

public class UserUtil {
	
	/**
	 * 将user存入session中
	 * @param user
	 * @param session
	 */
	public static void setUserSession(User user) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		request.getSession().setAttribute(Constant.LOGIN_USER, user);
	}
	
	/**
	 * 获取session中的user
	 * @return
	 */
	public static User getUser() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		return user;
	}
	
	
}
