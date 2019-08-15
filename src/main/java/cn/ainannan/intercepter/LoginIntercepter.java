package cn.ainannan.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.ainannan.commons.Constant;
import cn.ainannan.sys.bean.User;

public class LoginIntercepter implements HandlerInterceptor {

	
	// 请求验证是否登录
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // HandlerMethod handlerMethod = (HandlerMethod) handler;
        //获取请求方法
        // Method method = handlerMethod.getMethod();
        //请求的url
        String url = request.getRequestURI().substring(request.getContextPath().length()); 
		
		if("/".equals(url) || "".equals(url) || this.checkUrl(url)) {
			return true;
		}
		
		// 判断sesson
		HttpSession session = request.getSession();
		// 取出userName信息
		User loginUser = (User) session.getAttribute(Constant.LOGIN_USER);
		
		if (null != loginUser) {
			return true;
		}
		
		response.setStatus(401);
		return false;
	}

	private boolean checkUrl(String url) {
		// 资源类
		if (url.startsWith("/css")) return true;
        if (url.startsWith("/error")) return true;
        if (url.startsWith("/fonts")) return true;
        if (url.startsWith("/iconfont")) return true;
        if (url.startsWith("/img")) return true;
        if (url.startsWith("/js")) return true;
        if (url.startsWith("/static")) return true;
        if (url.startsWith("/captcha")) return true;
        
        // 系统登录类
        if (url.startsWith("/sys/login")) return true;
        if (url.startsWith("/sys/login/login")) return true;
        
        // uniapp测试
        if (url.startsWith("/cost/car")) return true;
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
