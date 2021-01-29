package com.newheyd.pub.bean;

import cn.ainannan.base.bean.BaseBean;
import cn.ainannan.commons.utils.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Log extends BaseBean {

    public static final String TYPE_ACCESS = "访问日志";
    public static final String TYPE_EXCEPTION = "错误日志";

    private String sysName;                //系统名称

    private String loginName;            //登录名
    private String userName;            //用户名
    private String areacode;            //用户所在区划

    private String logType;            // 日志类型（访问日志、错误日志）
    private String logTitle;            // 日志标题

    private String remoteAddr;            // 操作用户的IP地址
    private String requestUri;            // 操作的URI

    private String requestMethod;        // 操作的方式

    private String httpParams;            // 操作提交的数据

    private String userAgent;            // 操作用户代理信息

    private String sysExp;                // 异常信息


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;        // 开始日期

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;        // 结束日期


    private String dateStr;
    private int allCnt;
    private int webCnt;
    private int appCnt;


    public Log() {
        super();
    }

    public Log(String id) {
        super(id);
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogTitle() {
        return logTitle;
    }

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getHttpParams() {
        return httpParams;
    }

    public void setHttpParams(String httpParams) {
        this.httpParams = httpParams;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getSysExp() {
        return sysExp;
    }

    public void setSysExp(String sysExp) {
        this.sysExp = sysExp;
    }


    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    private String getBeginDateStr(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(beginDate);
        return dateString;
    }

    private String getEndDateStr(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(endDate);
        return dateString;
    }

    public void setParams(Map paramMap) {
        if (paramMap == null) {
            return;
        }

        StringBuilder params = new StringBuilder();

        for (Map.Entry<String, String[]> param : ((Map<String, String[]>) paramMap).entrySet()) {
            params.append(("".equals(params.toString()) ? "" : "&") + param.getKey() + "=");
            String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
            params.append(StringUtils.abbr(StringUtils.endsWithIgnoreCase(param.getKey(), "userPass") ? "" : paramValue, 100));
        }

        this.httpParams = params.toString();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public int getAllCnt() {
        return allCnt;
    }

    public void setAllCnt(int allCnt) {
        this.allCnt = allCnt;
    }

    public int getWebCnt() {
        return webCnt;
    }

    public void setWebCnt(int webCnt) {
        this.webCnt = webCnt;
    }

    public int getAppCnt() {
        return appCnt;
    }

    public void setAppCnt(int appCnt) {
        this.appCnt = appCnt;
    }

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

}