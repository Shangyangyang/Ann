package cn.ainannan.tool.cost.car.bean;

import cn.ainannan.base.bean.BaseBean;

public class Car extends BaseBean<Car> {
	private Double money;
	private String type;
	private String typeName;
	private Integer licheng;
	private Double youjia;
	private String reason;
	private String inputDate;

	
	
	public Car() {
		super();
	}

	public Car(String id) {
		super();
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

	public Integer getLicheng() {
		return licheng;
	}

	public void setLicheng(Integer licheng) {
		this.licheng = licheng;
	}

	public Double getYoujia() {
		return youjia;
	}

	public void setYoujia(Double youjia) {
		this.youjia = youjia;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	
}
