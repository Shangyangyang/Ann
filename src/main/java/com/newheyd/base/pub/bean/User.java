package com.newheyd.base.pub.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.newheyd.base.base.BaseBean;
import com.newheyd.base.util.Collections3;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@ExcelTarget("user")
public class User extends BaseBean {

    private static final long serialVersionUID = -3490477574308163325L;

    @Excel(name = "登录名", orderNum = "0",  isImportField = "userCode")
    @NotBlank(message = "登录名不能为空")
    private String userCode;// 登录名
    @NotBlank(message = "密码不能为空")
    private String userPass;// 密码

    @Excel(name = "姓名", orderNum = "1" , isImportField = "userName")
    @NotBlank(message = "姓名不能为空")

    private String userName; // 姓名
	
	private String qqId;//qq
    private String wxId;//微信
    private String wbId;//微博
    private String zwId;//政务网
    private String ddId;//钉钉
    private String loginType;//第三方类型（0普通登录1QQ2微信3微博4钉钉）

    private String clientId;//消息推送标识

    private String token;

    private String accessToken;

    private String refreshToken;

    private String mobileCode;

    @Excel(name = " 电话", orderNum = "2" )
    private String phoneNum; // 电话
    
    /*
    @NotBlank(message = "用户类型不能为空")
    private String userType;// 用户类型
    private String userTypeName;// 用户类型
    */
    
    private String oldLoginName;// 原登录名
    private String newUserPass; // 新密码
    @NotBlank(message = "证件号码不能为空")
    private String cardNum;//证件号码
    @NotBlank(message = "证件类型不能为空")
    private String cardType;//证件类型
    private String cardTypeName;//证件类型名称
    private String familyAddr;//家庭住址
    private String remarks;//备注
    private Role role; // 根据角色查询用户条件
    private List<Role> roleList = Lists.newArrayList(); // 拥有角色列表

    private Area area;//机构所在行政区划
    private String areaName;
    @NotBlank(message = "行政区划不能为空")
    private String areaCode;
    private String areaLevel;

    private Office office; // 归属部门
    private String officeName;//用于页面显示归属机构名称
    private String officeCode;//用于查询机构下用户 officeCode和userOfficeCode不可同时存在

    private String officeLevel;//用于查询机构下用户

    private  Boolean isAdmin;

    private String appCode;

    private String appState;

    private String roleCode;
    private List<String> resourceList;

    private String userOfficeCode;//用于查询用户所在机构及以下用户数据  officeCode和userOfficeCode不可同时存在

    private String ableInsert;//用于查询，'1' 已经有某角色的用户，'2' 没有某角色的用户

    private String minRoleLevel;//最高级别角色 （键值最小） 主要用来控制 省级角色及以上可以新增角色
    private String maxRoleLevel; //最低级别角色 （键值最大） 判断是否拥有机构管理角色， 键值6为机构管理角色
    
    private String workPhone;   //办公电话
    private String workDuty;    //职务
    private String workEmail;   //电子邮件

    private String loginFlag; //1启用2停用 //3注销 暂未启用

    // Web登录时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date webLoginTime;

    // App登录时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date appLoginTime;

    //上次Web登录时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date webLastTime;

    //上次App登录时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date appLastTime;


    private String loginErrorDate;
    private int loginErrorNum;


    public User() {
        super();
        //this.loginFlag = Global.YES;
    }

    public String getLoginErrorDate() {
        return loginErrorDate;
    }

    public void setLoginErrorDate(String loginErrorDate) {
        this.loginErrorDate = loginErrorDate;
    }

    public int getLoginErrorNum() {
        return loginErrorNum;
    }

    public void setLoginErrorNum(int loginErrorNum) {
        this.loginErrorNum = loginErrorNum;
    }

    /*  public User(String id) {
            super(id);
        }*/
    public User(String userCode) {
        this.userCode=userCode;
    }

    public User(String id, String userCode) {
        super(id);
        this.userCode = userCode;
    }

    public User(Role role) {
        super();
        this.role = role;
    }

    @Override
    public String getId() {
        return id;
    }

    @JsonIgnore
   // @NotNull(message = "归属部门不能为空")
    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Length(min = 1, max = 100, message = "登录名长度必须介于 1 和 100 之间")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @JsonIgnore
    @Length(min = 1, max = 100, message = "密码长度必须介于 1 和 100 之间")
    public String getUserPass() {
        return userPass;
    }

    @JsonProperty
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getNewUserPass() {
        return newUserPass;
    }

    public void setNewUserPass(String newUserPass) {
        this.newUserPass = newUserPass;
    }

    @Length(min = 1, max = 100, message = "姓名长度必须介于 1 和 100 之间")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Length(min = 0, max = 200, message = "电话长度必须介于 1 和 200 之间")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String getRemarks() {
        return remarks;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getMobileCode() {
        return mobileCode;
    }

    public void setMobileCode(String mobileCode) {
        this.mobileCode = mobileCode;
    }
    /*
    @Length(min = 0, max = 100, message = "用户类型长度必须介于 1 和 100 之间")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
    */

    public String getOldLoginName() {
        return oldLoginName;
    }

    public void setOldLoginName(String oldLoginName) {
        this.oldLoginName = oldLoginName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @JsonIgnore
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @JsonIgnore
    public List<String> getRoleIdList() {
        List<String> roleIdList = Lists.newArrayList();
        for (Role role : roleList) {
            roleIdList.add(role.getRoleCode());
        }
        return roleIdList;
    }

    public void setRoleIdList(List<String> roleIdList) {
        roleList = Lists.newArrayList();
        for (String roleCode : roleIdList) {
            Role role = new Role();
            role.setRoleCode(roleCode);
            roleList.add(role);
        }
    }

    /**
     * 用户拥有的角色名称字符串, 多个角色名称用','分隔.
     */
    public String getRoleNames() {
        return Collections3.extractToString(roleList, "name", ",");
    }

    public String[] getRoleCodes() {
        if( Collections3.extractToString(roleList, "roleCode", ",")==""){
            return null;
        }
        return Collections3.extractToString(roleList, "roleCode", ",").split(",");
    }

    public boolean isAdmin() {
        this.isAdmin = isAdmin(this.id);
        return this.isAdmin;
    }

    public static boolean isAdmin(String id) {

        return id != null && "10000000000000000000000000000000".equals(id);
    }

    @Override
    public String toString() {
        return id;
    }
    
    @NotNull(message = "证件号码不能为空")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @NotNull(message = "证件类型不能为空")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    public String getFamilyAddr() {
        return familyAddr;
    }

    public void setFamilyAddr(String familyAddr) {
        this.familyAddr = familyAddr;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(String areaLevel) {
        this.areaLevel = areaLevel;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getOfficeLevel() {
        return officeLevel;
    }

    public void setOfficeLevel(String officeLevel) {
        this.officeLevel = officeLevel;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppState() {
        return appState;
    }

    public void setAppState(String appState) {
        this.appState = appState;
    }

    public List<String> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<String> resourceList) {
        this.resourceList = resourceList;
    }

    public String getUserOfficeCode() {
        return userOfficeCode;
    }

    public void setUserOfficeCode(String userOfficeCode) {
        this.userOfficeCode = userOfficeCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getWbId() {
        return wbId;
    }

    public void setWbId(String wbId) {
        this.wbId = wbId;
    }

    public String getZwId() {
        return zwId;
    }

    public void setZwId(String zwId) {
        this.zwId = zwId;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
	
	public String getAbleInsert() {
        return ableInsert;
    }

    public void setAbleInsert(String ableInsert) {
        this.ableInsert = ableInsert;
    }

    public String getMinRoleLevel() {
        return minRoleLevel;
    }

    public void setMinRoleLevel(String minRoleLevel) {
        this.minRoleLevel = minRoleLevel;
    }

    public String getMaxRoleLevel() {
        return maxRoleLevel;
    }

    public void setMaxRoleLevel(String maxRoleLevel) {
        this.maxRoleLevel = maxRoleLevel;
    }


    public Date getWebLoginTime() {
        return webLoginTime;
    }

    public void setWebLoginTime(Date webLoginTime) {
        this.webLoginTime = webLoginTime;
    }

    public Date getAppLoginTime() {
        return appLoginTime;
    }

    public void setAppLoginTime(Date appLoginTime) {
        this.appLoginTime = appLoginTime;
    }

    public Date getWebLastTime() {
        return webLastTime;
    }

    public void setWebLastTime(Date webLastTime) {
        this.webLastTime = webLastTime;
    }

    public Date getAppLastTime() {
        return appLastTime;
    }

    public void setAppLastTime(Date appLastTime) {
        this.appLastTime = appLastTime;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkDuty() {
        return workDuty;
    }

    public void setWorkDuty(String workDuty) {
        this.workDuty = workDuty;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    public String getDdId() {
        return ddId;
    }

    public void setDdId(String ddId) {
        this.ddId = ddId;
    }

	public String toString2() {
		return "User [userCode=" + userCode + ", userPass=" + userPass + ", userName=" + userName + ", qqId=" + qqId
				+ ", wxId=" + wxId + ", wbId=" + wbId + ", zwId=" + zwId + ", ddId=" + ddId + ", loginType=" + loginType
				+ ", clientId=" + clientId + ", token=" + token + ", phoneNum=" + phoneNum + ", oldLoginName="
				+ oldLoginName + ", newUserPass=" + newUserPass + ", cardNum=" + cardNum + ", cardType=" + cardType
				+ ", cardTypeName=" + cardTypeName + ", familyAddr=" + familyAddr + ", remarks=" + remarks + ", role="
				+ role + ", roleList=" + roleList + ", area=" + area + ", areaName=" + areaName + ", areaCode="
				+ areaCode + ", areaLevel=" + areaLevel + ", office=" + office + ", officeName=" + officeName
				+ ", officeCode=" + officeCode + ", officeLevel=" + officeLevel + ", isAdmin=" + isAdmin + ", appCode="
				+ appCode + ", appState=" + appState + ", roleCode=" + roleCode + ", resourceList=" + resourceList
				+ ", userOfficeCode=" + userOfficeCode + ", ableInsert=" + ableInsert + ", minRoleLevel=" + minRoleLevel
				+ ", maxRoleLevel=" + maxRoleLevel + ", workPhone=" + workPhone + ", workDuty=" + workDuty
				+ ", workEmail=" + workEmail + ", loginFlag=" + loginFlag + ", webLoginTime=" + webLoginTime
				+ ", appLoginTime=" + appLoginTime + ", webLastTime=" + webLastTime + ", appLastTime=" + appLastTime
				+ "]";
	}
}