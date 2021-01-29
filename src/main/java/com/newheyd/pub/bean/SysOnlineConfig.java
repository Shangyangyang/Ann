package com.newheyd.pub.bean;

import cn.ainannan.base.bean.BaseBean;
import org.hibernate.validator.constraints.Length;

/**
 * 网办事项配置管理Entity
 * @author whz
 * @version 2018-12-10
 */
public class SysOnlineConfig extends BaseBean {

	private static final long serialVersionUID = 1L;
	

	private String itemName;		// 事项名称

	private String acceptPlace;		// 受理地点

	private String itemType;		// 事项类型

	private String itemNo;        //事项编码
	private String isfee; //是否收费
	private String feeScale;		// 收费标准

	private String consultPhone;		// 咨询电话

	private String implementOrgan;		// 实施机构

	private String[] transactType;		// 办理类型
	private String banliType;// 办理类型

	private Integer commitmentDay;		// 承诺时限
	private Integer legalDay;             //法定办结时限
	private String transactTime;		// 办理时间

	private String transactBeginDay;		// 办理开始时间（天）
	private String transactBeginHm;		// 办理开始时间（时分）
	private String transactEndDay;		// 办理结束时间（天）
	private String transactEndHm;		// 办理结束时间（时分）

	private String zwurl;		// zwurl

	private String appurl;		// appurl

	
	private String beginTransactTime;		// 开始 办理时间
	private String endTransactTime;		// 结束 办理时间
	private String areaCode;//地区
	private String areaCodeName;//地区
	private String subSystemType;//子系统类型

	public SysOnlineConfig() {
	}

	public SysOnlineConfig(String id){
		super(id);
	}

	@Length(min=0, max=100, message="事项名称长度必须介于 0 和 100 之间")
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	



	@Length(min=0, max=50, message="受理地点长度必须介于 0 和 50 之间")
	public String getAcceptPlace() {
		return acceptPlace;
	}

	public void setAcceptPlace(String acceptPlace) {
		this.acceptPlace = acceptPlace;
	}
	



	@Length(min=0, max=50, message="办理类型长度必须介于 0 和 50 之间")
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	



	@Length(min=0, max=50, message="收费标准长度必须介于 0 和 50 之间")
	public String getFeeScale() {
		return feeScale;
	}

	public void setFeeScale(String feeScale) {
		this.feeScale = feeScale;
	}
	



	@Length(min=0, max=20, message="咨询电话长度必须介于 0 和 20 之间")
	public String getConsultPhone() {
		return consultPhone;
	}

	public void setConsultPhone(String consultPhone) {
		this.consultPhone = consultPhone;
	}
	



	@Length(min=0, max=100, message="实施机构长度必须介于 0 和 100 之间")
	public String getImplementOrgan() {
		return implementOrgan;
	}

	public void setImplementOrgan(String implementOrgan) {
		this.implementOrgan = implementOrgan;
	}

	@Length(min=0, max=50, message="办理类型长度必须介于 0 和 50 之间")
	public String[] getTransactType() {
		return transactType;
	}

	public void setTransactType(String[] transactType) {
		this.transactType = transactType;
	}

	public Integer getCommitmentDay() {
		return commitmentDay;
	}

	public void setCommitmentDay(Integer commitmentDay) {
		this.commitmentDay = commitmentDay;
	}



	@Length(min=0, max=50, message="办理时间长度必须介于 0 和 50 之间")
	public String getTransactTime() {
		return transactTime;
	}

	public void setTransactTime(String transactTime) {
		this.transactTime = transactTime;
	}
	



	@Length(min=0, max=200, message="zwurl长度必须介于 0 和 200 之间")
	public String getZwurl() {
		return zwurl;
	}

	public void setZwurl(String zwurl) {
		this.zwurl = zwurl;
	}
	



	@Length(min=0, max=200, message="appurl长度必须介于 0 和 200 之间")
	public String getAppurl() {
		return appurl;
	}

	public void setAppurl(String appurl) {
		this.appurl = appurl;
	}
	



	
	public String getBeginTransactTime() {
		return beginTransactTime;
	}

	public void setBeginTransactTime(String beginTransactTime) {
		this.beginTransactTime = beginTransactTime;
	}
	
	public String getEndTransactTime() {
		return endTransactTime;
	}

	public void setEndTransactTime(String endTransactTime) {
		this.endTransactTime = endTransactTime;
	}

	public String getTransactBeginDay() {
		return transactBeginDay;
	}

	public void setTransactBeginDay(String transactBeginDay) {
		this.transactBeginDay = transactBeginDay;
	}

	public String getTransactBeginHm() {
		return transactBeginHm;
	}

	public void setTransactBeginHm(String transactBeginHm) {
		this.transactBeginHm = transactBeginHm;
	}

	public String getTransactEndDay() {
		return transactEndDay;
	}

	public void setTransactEndDay(String transactEndDay) {
		this.transactEndDay = transactEndDay;
	}

	public String getTransactEndHm() {
		return transactEndHm;
	}

	public void setTransactEndHm(String transactEndHm) {
		this.transactEndHm = transactEndHm;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getIsfee() {
		return isfee;
	}

	public void setIsfee(String isfee) {
		this.isfee = isfee;
	}

	public Integer getLegalDay() {
		return legalDay;
	}

	public void setLegalDay(Integer legalDay) {
		this.legalDay = legalDay;
	}

	public String getBanliType() {
		return banliType;
	}

	public void setBanliType(String banliType) {
		this.banliType = banliType;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getSubSystemType() {
		return subSystemType;
	}

	public void setSubSystemType(String subSystemType) {
		this.subSystemType = subSystemType;
	}

	public String getAreaCodeName() {
		return areaCodeName;
	}

	public void setAreaCodeName(String areaCodeName) {
		this.areaCodeName = areaCodeName;
	}
}