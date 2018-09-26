package cn.ainannan.tool.cost.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.ainannan.base.bean.BaseBean;

public class Large extends BaseBean {
	private Double money;
	private String type;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date costDate;
	private String reason;
	private String relatedPerson;
	private String jinpozhi;

	private String typeName;
	private String jinpozhiName;
	private String relatedPersonName;

	
	
	public Large() {
		super();
	}

	public Large(String id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCostDate() {
		return costDate;
	}

	public void setCostDate(Date costDate) {
		this.costDate = costDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRelatedPerson() {
		return relatedPerson;
	}

	public void setRelatedPerson(String relatedPerson) {
		this.relatedPerson = relatedPerson;
	}

	public String getJinpozhi() {
		return jinpozhi;
	}

	public void setJinpozhi(String jinpozhi) {
		this.jinpozhi = jinpozhi;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getJinpozhiName() {
		return jinpozhiName;
	}

	public void setJinpozhiName(String jinpozhiName) {
		this.jinpozhiName = jinpozhiName;
	}

	public String getRelatedPersonName() {
		return relatedPersonName;
	}

	public void setRelatedPersonName(String relatedPersonName) {
		this.relatedPersonName = relatedPersonName;
	}

}