package cn.ainannan.intercepter;

import cn.ainannan.sys.bean.User;
import cn.ainannan.sys.utils.UserUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntercepter implements HandlerInterceptor {

	
	// 请求验证是否登录
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        //请求的url
        String url = request.getRequestURI().substring(request.getContextPath().length());
		// 取出userName信息
		User loginUser = UserUtil.getUser();

		if (null != loginUser) {
			return true;
		}

		if("/".equals(url) || "".equals(url) || this.checkUrl(url)) {
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
        
        // 系统管理类
        // 字典
		if (url.startsWith("/sys/dict/list")) return true;

		// 下载
		if (url.startsWith("/sys/file/download")) return true;

        // 测试的
		if (url.startsWith("/test")) return true;
		if (url.startsWith("/cost/car")) return true;
        // uniapp测试
        // if (url.startsWith("/cost/car")) return true;
		
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
