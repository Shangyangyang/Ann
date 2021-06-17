package com.newheyd.base.util;

import com.newheyd.base.pub.bean.Area;
import com.newheyd.base.pub.bean.Office;
import com.newheyd.base.pub.bean.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {


    public static void setUserSession(User sysUser) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (sysUser != null&&!"".equals(sysUser)) {
            request.getSession().setAttribute(ConstUtil.SESSION_USER_OBJECT, sysUser);
            if (StringUtils.isNotBlank(sysUser.getUserCode())) {
                request.getSession().setAttribute(ConstUtil.SESSION_USER, sysUser.getUserCode());
            }
        }

        if (sysUser != null&&!"".equals(sysUser)&&StringUtils.isNotBlank(sysUser.getOfficeCode()) && StringUtils.isNotBlank(sysUser.getOfficeName()) && StringUtils.isNotBlank(sysUser.getOfficeLevel())) {
            Office office = new Office();
            office.setCode(sysUser.getOfficeCode());
            office.setName(sysUser.getOfficeName());
            office.setOfficeLevel(sysUser.getOfficeLevel());
            request.getSession().setAttribute(ConstUtil.SESSION_OFFICE, office);
        }

        if (sysUser != null&&!"".equals(sysUser)&&StringUtils.isNotBlank(sysUser.getAreaCode()) && StringUtils.isNotBlank(sysUser.getAreaName()) && StringUtils.isNotBlank(sysUser.getAreaLevel())) {
            Area area = new Area();
            area.setCode(sysUser.getAreaCode());
            area.setName(sysUser.getAreaName());
            area.setAreaLevel(sysUser.getAreaLevel());
            request.getSession().setAttribute(ConstUtil.SESSION_AREA, area);
        }
    }

    public static User getUser() {
        if (RequestContextHolder.getRequestAttributes() == null) return new User();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User)request.getSession().getAttribute(ConstUtil.SESSION_USER_OBJECT);
        if(user == null || StringUtils.isBlank(user.getUserCode())){
            try {
                user = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public static String getUserCode() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String userCode = (String) request.getSession().getAttribute(ConstUtil.SESSION_USER);
        User user = null;
        if(StringUtils.isBlank(userCode)){
            try {
                user = null;
                userCode = user.getUserCode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userCode;
    }

    public static Area getArea() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Area area = (Area) request.getSession().getAttribute(ConstUtil.SESSION_AREA);
        User user = getUser();
        if(area == null || StringUtils.isBlank(area.getCode())){
            area = new Area();
            area.setCode(user.getAreaCode());
            area.setAreaLevel(user.getAreaLevel());
            area.setName(user.getAreaName());
        }
        return area;
    }

    public static String getAreaCode() {
        return getArea().getCode();
    }

    public static String getAreaCodeJQ() {
        return AreaUtil.AreaJQ(getArea());
    }

    public static Office getOffice() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Office office = (Office) request.getSession().getAttribute(ConstUtil.SESSION_OFFICE);
        User user = getUser();
        if(office == null || StringUtils.isBlank(office.getCode())){
            office = new Office();
            office.setCode(user.getOfficeCode());
            office.setName(user.getOfficeName());
            office.setOfficeLevel(user.getOfficeLevel());
        }
        return office;
    }

    public static String getOfficeCode() {
        return getOffice().getCode();
    }
}
