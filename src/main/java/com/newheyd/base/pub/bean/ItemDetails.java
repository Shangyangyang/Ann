package com.newheyd.base.pub.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.newheyd.base.base.BaseBean;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 网办事项明细Entity
 * @author whz
 * @version 2018-12-13
 */
public class ItemDetails extends BaseBean {

	private static final long serialVersionUID = 1L;
	

	private String ywid;		// 各自业务ID

	private String year;		// 年度

	private String itemname;		// 事项名称

	private String itemno;		// 事项编码

	private String itemId;		// 事项主键id

	private String applyfrom;		// 申报来源标识办件的申报源头：网上、窗口

	private String areaCode;		// area_code

	private String areaName;		// area_name

	private String applyname;		// 申报人姓名

	private String state;		// 状态


	private String projectname;		// 申请审批的项目的具体名称

	private String projectstate;		// 办件状态

	private String applyCardtype;		// 申报者证件类型

	private String applyCardtypenumber;		// 申报者提供的有效证件的识别

	private String contactman;		// 代理人，没有代理人填申报人

	private String contactmanCardtype;		// 联系人证件类型

	private String contactmanCardnumber;		// 联系人/代理人证件号码

	private String telphone;		// 联系人手机号码

	private String deptid;		// 收件部门编码(审批事项所对应的负责部门组织机构代码

	private String deptname;		// 收件部门名称审批事项所对应的负责部门名

	private String approveType;		// 审批类型

	private String regionId;		// regionId

	private String businessSubjectType;		// 1.个人2企业3其他

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")		
	private Date receivetime;		// 申报时间

	private String sysType;		// 系统类型
	private Integer commitmentDay; //办理事项承诺时限   单位：工作日

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;		// 事项办理截止日期

	private Integer remainingDay;//事项处理剩余天数
	private String subSystemType;//子系统类型

	private String shiState;//市级是否查看  1.已查看

	private Integer value; //统计事项

	//拓展属性
	private List<String> stateList;//用于多个状态值的查询，用state属性","分割传入
	
	private String startYear;
	private String endYear;

	private String password;//网办查询密码
	private String unitecode;//网办查询编号


	public ItemDetails() {
	}

	public ItemDetails(String id){
		super(id);
	}

	@Length(min=0, max=32, message="各自业务ID长度必须介于 0 和 32 之间")
	public String getYwid() {
		return ywid;
	}

	public void setYwid(String ywid) {
		this.ywid = ywid;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUnitecode() {
		return unitecode;
	}

	public void setUnitecode(String unitecode) {
		this.unitecode = unitecode;
	}

	@Length(min=0, max=10, message="年度长度必须介于 0 和 10 之间")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	



	@Length(min=0, max=100, message="事项名称长度必须介于 0 和 100 之间")
	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	



	@Length(min=0, max=100, message="事项编码长度必须介于 0 和 100 之间")
	public String getItemno() {
		return itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}
	



	@Length(min=0, max=32, message="事项主键id长度必须介于 0 和 32 之间")
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	



	@Length(min=0, max=10, message="申报来源标识办件的申报源头：网上、窗口长度必须介于 0 和 10 之间")
	public String getApplyfrom() {
		return applyfrom;
	}

	public void setApplyfrom(String applyfrom) {
		this.applyfrom = applyfrom;
	}
	



	@Length(min=0, max=32, message="area_code长度必须介于 0 和 32 之间")
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	



	@Length(min=0, max=32, message="area_name长度必须介于 0 和 32 之间")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	



	@Length(min=0, max=20, message="申报人姓名长度必须介于 0 和 20 之间")
	public String getApplyname() {
		return applyname;
	}

	public void setApplyname(String applyname) {
		this.applyname = applyname;
	}
	



	@Length(min=0, max=20, message="状态长度必须介于 0 和 20 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	



	@Length(min=0, max=200, message="申请审批的项目的具体名称长度必须介于 0 和 200 之间")
	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	



	@Length(min=0, max=2, message="办件状态长度必须介于 0 和 2 之间")
	public String getProjectstate() {
		return projectstate;
	}

	public void setProjectstate(String projectstate) {
		this.projectstate = projectstate;
	}
	



	@Length(min=0, max=2, message="申报者证件类型长度必须介于 0 和 2 之间")
	public String getApplyCardtype() {
		return applyCardtype;
	}

	public void setApplyCardtype(String applyCardtype) {
		this.applyCardtype = applyCardtype;
	}
	



	@Length(min=0, max=100, message="申报者提供的有效证件的识别长度必须介于 0 和 100 之间")
	public String getApplyCardtypenumber() {
		return applyCardtypenumber;
	}

	public void setApplyCardtypenumber(String applyCardtypenumber) {
		this.applyCardtypenumber = applyCardtypenumber;
	}
	



	@Length(min=0, max=100, message="代理人，没有代理人填申报人长度必须介于 0 和 100 之间")
	public String getContactman() {
		return contactman;
	}

	public void setContactman(String contactman) {
		this.contactman = contactman;
	}
	



	@Length(min=0, max=2, message="联系人证件类型长度必须介于 0 和 2 之间")
	public String getContactmanCardtype() {
		return contactmanCardtype;
	}

	public void setContactmanCardtype(String contactmanCardtype) {
		this.contactmanCardtype = contactmanCardtype;
	}
	



	@Length(min=0, max=100, message="联系人/代理人证件号码长度必须介于 0 和 100 之间")
	public String getContactmanCardnumber() {
		return contactmanCardnumber;
	}

	public void setContactmanCardnumber(String contactmanCardnumber) {
		this.contactmanCardnumber = contactmanCardnumber;
	}
	



	@Length(min=0, max=100, message="联系人手机号码长度必须介于 0 和 100 之间")
	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	



	@Length(min=0, max=100, message="收件部门编码(审批事项所对应的负责部门组织机构代码长度必须介于 0 和 100 之间")
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	



	@Length(min=0, max=100, message="收件部门名称审批事项所对应的负责部门名长度必须介于 0 和 100 之间")
	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	



	@Length(min=0, max=2, message="审批类型长度必须介于 0 和 2 之间")
	public String getApproveType() {
		return approveType;
	}

	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}
	



	@Length(min=0, max=12, message="regionId长度必须介于 0 和 12 之间")
	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	




	public String getBusinessSubjectType() {
		return businessSubjectType;
	}

	public void setBusinessSubjectType(String businessSubjectType) {
		this.businessSubjectType = businessSubjectType;
	}
	



	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReceivetime() {
		return receivetime;
	}

	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}
	



	@Length(min=0, max=10, message="系统类型长度必须介于 0 和 10 之间")
	public String getSysType() {
		return sysType;
	}

	public void setSysType(String sysType) {
		this.sysType = sysType;
	}

	public Integer getCommitmentDay() {
		return commitmentDay;
	}

	public void setCommitmentDay(Integer commitmentDay) {
		this.commitmentDay = commitmentDay;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getRemainingDay() {
		return remainingDay;
	}

	public void setRemainingDay(Integer remainingDay) {
		this.remainingDay = remainingDay;
	}

	public String getSubSystemType() {
		return subSystemType;
	}

	public void setSubSystemType(String subSystemType) {
		this.subSystemType = subSystemType;
	}

	public String getShiState() {
		return shiState;
	}

	public void setShiState(String shiState) {
		this.shiState = shiState;
	}

	public List<String> getStateList() {
		return stateList;
	}

	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
}