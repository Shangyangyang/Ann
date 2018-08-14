package cn.ainannan.tool.cost.dog.bean;

import java.util.Date;

import cn.ainannan.base.bean.BaseBean;

public class Dog extends BaseBean<Dog> {
	private Double money;
	private String type;
	private Date costDate;
	private String reason;
	private String relatedPerson;

	
	
	public Dog() {
		super();
	}

	public Dog(String id) {
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

}
