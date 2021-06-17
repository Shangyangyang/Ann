package com.newheyd.base.pub.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.newheyd.base.base.BaseBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SmsSendInfo extends BaseBean {


	@Excel(name = "接收人",orderNum="1")
	private String name;		// 用户名
	private String code;		// 验证码
	@Excel(name = "电话",orderNum="10", width = 15)
	private String phone;		// 电话
	@Excel(name = "短信签名",orderNum="20", width = 22)
	private String signName;		// 短信签名
	@Excel(name = "模板编号",orderNum="30", width = 15)
	private String temp;		// 模板编号
	private String time;		// 业务时间
	@Excel(name = "发送时间",orderNum="40",databaseFormat = "yyy-MM-dd HH:mm:ss" , width = 30)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date sendTime;		// 发送时间
	@Excel(name = "内容",orderNum="50", width = 100)
	private String content;		// 内容
	private String bizId;		// 发送回执
	private String outId;		// 扩展字段
	private String state;		// 状态1发送中2发送失败3发送成功
	@Excel(name = "状态",orderNum="30")
	private String stateName;		// 状态1发送中2发送失败3发送成功
	private String errCode;		// 错误码
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date receiveTime;		// 接收时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginSendTime;		// 开始 发送时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endSendTime;		// 结束 发送时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginReceiveTime;		// 开始 接收时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endReceiveTime;		// 结束 接收时间

	private String validateCode;//待验证验证码

	private String type;//类型
	private String idcard;	// 身份证号

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getOutId() {
		return outId;
	}

	public void setOutId(String outId) {
		this.outId = outId;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getBeginSendTime() {
		return beginSendTime;
	}

	public void setBeginSendTime(Date beginSendTime) {
		this.beginSendTime = beginSendTime;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getEndSendTime() {
		return endSendTime;
	}

	public void setEndSendTime(Date endSendTime) {
		this.endSendTime = endSendTime;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getBeginReceiveTime() {
		return beginReceiveTime;
	}

	public void setBeginReceiveTime(Date beginReceiveTime) {
		this.beginReceiveTime = beginReceiveTime;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getEndReceiveTime() {
		return endReceiveTime;
	}

	public void setEndReceiveTime(Date endReceiveTime) {
		this.endReceiveTime = endReceiveTime;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}