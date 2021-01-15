package cn.ainannan.tool.cost.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.ainannan.base.bean.BaseBean;

public class Car extends BaseBean {
	@Excel(name = "金额", orderNum="1")
	private Double money;
	@Excel(name = "类型", orderNum="2", replace= {"油费_1", "过路费_2", "罚款_3", "保险_4", "其它_5"})
	private String type;
	private String typeName;
	@Excel(name = "里程数", orderNum="3")
	private Integer licheng;
	@Excel(name = "油价", orderNum="4")
	private Double youjia;
	@Excel(name = "说明", orderNum="6")
	private String reason;
	@Excel(name = "日期", orderNum="5")
	private String inputDate;
	private String niandu;

	public Car() {
		super();
	}

	public Car(String id) {
		super();
		this.id = id;
	}

	public String getNiandu() {
		return niandu;
	}

	public void setNiandu(String niandu) {
		this.niandu = niandu;
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
