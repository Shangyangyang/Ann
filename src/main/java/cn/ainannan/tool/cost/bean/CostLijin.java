package cn.ainannan.tool.cost.bean;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.ainannan.base.bean.BaseBean;

/**
 * 礼金Entity
 * 
 * @author syy
 * @version 2018-08-31
 */
public class CostLijin extends BaseBean<CostLijin> {

	private String name; // 姓名

	private String money; // 金额

	private String type; // 类型
	private String typeName; // 类型

	private String isyihuan; // 是否已还
	private String isyihuanName; // 是否已还

	private String guishuren; // 关联人
	private String guishurenName; // 关联人
	
	private String reason; // 说明
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date inputDate; // 入账日期

	private String yihuanMoney; // 已还金额

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date yihuanDate; // 已还日期

	public CostLijin() {
		
	}

	public CostLijin(String id) {
		super(id);
	}

	@Length(min = 0, max = 40, message = "姓名长度必须介于 0 和 40 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	@Length(min = 0, max = 2, message = "类型长度必须介于 0 和 2 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Length(min = 0, max = 2, message = "是否已还长度必须介于 0 和 2 之间")
	public String getIsyihuan() {
		return isyihuan;
	}

	public void setIsyihuan(String isyihuan) {
		this.isyihuan = isyihuan;
	}

	@Length(min = 0, max = 4, message = "关联人长度必须介于 0 和 4 之间")
	public String getGuishuren() {
		return guishuren;
	}

	public void setGuishuren(String guishuren) {
		this.guishuren = guishuren;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getYihuanMoney() {
		return yihuanMoney;
	}

	public void setYihuanMoney(String yihuanMoney) {
		this.yihuanMoney = yihuanMoney;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getYihuanDate() {
		return yihuanDate;
	}

	public void setYihuanDate(Date yihuanDate) {
		this.yihuanDate = yihuanDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getIsyihuanName() {
		return isyihuanName;
	}

	public void setIsyihuanName(String isyihuanName) {
		this.isyihuanName = isyihuanName;
	}

	public String getGuishurenName() {
		return guishurenName;
	}

	public void setGuishurenName(String guishurenName) {
		this.guishurenName = guishurenName;
	}

}