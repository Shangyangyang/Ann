package com.newheyd.pub.bean;

import cn.ainannan.base.bean.BaseBean;

/**
 * 已调查信息表Entity
 * 
 * @author ky
 * @version 2018-09-19
 */
public class DyHuizong extends BaseBean {
	private static final long serialVersionUID = 1L;

	private Integer g8_1; // 低于低保标准
	private Integer g8_1_per; // 低于低保标准
	private Integer g8_2; // 低于低收入或低保边缘标准
	private Integer g8_2_per; // 低于低收入或低保边缘标准
	private Integer g8_3; // 其他
	private Integer g8_3_per; // 其他

	private Integer g10_1; // 国家建档立卡贫困户
	private Integer g10_1_per; // 国家建档立卡贫困户
	private Integer g10_2; // 其他贫困人口
	private Integer g10_2_per; // 其他贫困人口
	private Integer g10_3; // 其他
	private Integer g10_3_per; // 其他
	private Integer total; // 总记录数
	private Integer heji; // 总记录数

	private int value1;			// 统计项值1
	private int value2;			// 统计项值2
	private int value3;			// 统计项值3
	private int value4;			// 统计项值4
	private int value5;			// 统计项值5
	private int value6;			// 统计项值6
	private int value7;			// 统计项值7
	private int value8;			// 统计项值8
	private int value9;			// 统计项值9
	private int value10;		// 统计项值10
	private int value11;		// 统计项值11
	private int value12;		// 统计项值12
	private int value13;		// 统计项值13
	private int value14;		// 统计项值14
	private int value15;		// 统计项值15

	private String yue;
	private String year;
	private String type;

	private String areaCode;
	private String areaName;

	public Integer getG8_1() {
		return g8_1;
	}

	public void setG8_1(Integer g8_1) {
		this.g8_1 = g8_1;
	}

	public Integer getG8_2() {
		return g8_2;
	}

	public void setG8_2(Integer g8_2) {
		this.g8_2 = g8_2;
	}

	public Integer getG8_3() {
		return g8_3;
	}

	public void setG8_3(Integer g8_3) {
		this.g8_3 = g8_3;
	}

	public Integer getG10_1() {
		return g10_1;
	}

	public void setG10_1(Integer g10_1) {
		this.g10_1 = g10_1;
	}

	public Integer getG10_2() {
		return g10_2;
	}

	public void setG10_2(Integer g10_2) {
		this.g10_2 = g10_2;
	}

	public Integer getG10_3() {
		return g10_3;
	}

	public void setG10_3(Integer g10_3) {
		this.g10_3 = g10_3;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getG8_1_per() {
		return g8_1_per;
	}

	public void setG8_1_per(Integer g8_1_per) {
		this.g8_1_per = g8_1_per;
	}

	public Integer getG8_2_per() {
		return g8_2_per;
	}

	public void setG8_2_per(Integer g8_2_per) {
		this.g8_2_per = g8_2_per;
	}

	public Integer getG8_3_per() {
		return g8_3_per;
	}

	public void setG8_3_per(Integer g8_3_per) {
		this.g8_3_per = g8_3_per;
	}

	public Integer getG10_1_per() {
		return g10_1_per;
	}

	public void setG10_1_per(Integer g10_1_per) {
		this.g10_1_per = g10_1_per;
	}

	public Integer getG10_2_per() {
		return g10_2_per;
	}

	public void setG10_2_per(Integer g10_2_per) {
		this.g10_2_per = g10_2_per;
	}

	public Integer getG10_3_per() {
		return g10_3_per;
	}

	public void setG10_3_per(Integer g10_3_per) {
		this.g10_3_per = g10_3_per;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getHeji() {
		return heji;
	}

	public void setHeji(Integer heji) {
		this.heji = heji;
	}

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public int getValue3() {
		return value3;
	}

	public void setValue3(int value3) {
		this.value3 = value3;
	}

	public int getValue4() {
		return value4;
	}

	public void setValue4(int value4) {
		this.value4 = value4;
	}

	public int getValue5() {
		return value5;
	}

	public void setValue5(int value5) {
		this.value5 = value5;
	}

	public int getValue6() {
		return value6;
	}

	public void setValue6(int value6) {
		this.value6 = value6;
	}

	public int getValue7() {
		return value7;
	}

	public void setValue7(int value7) {
		this.value7 = value7;
	}

	public int getValue8() {
		return value8;
	}

	public void setValue8(int value8) {
		this.value8 = value8;
	}

	public int getValue9() {
		return value9;
	}

	public void setValue9(int value9) {
		this.value9 = value9;
	}

	public int getValue10() {
		return value10;
	}

	public void setValue10(int value10) {
		this.value10 = value10;
	}

	public int getValue11() {
		return value11;
	}

	public void setValue11(int value11) {
		this.value11 = value11;
	}

	public int getValue12() {
		return value12;
	}

	public void setValue12(int value12) {
		this.value12 = value12;
	}

	public int getValue13() {
		return value13;
	}

	public void setValue13(int value13) {
		this.value13 = value13;
	}

	public int getValue14() {
		return value14;
	}

	public void setValue14(int value14) {
		this.value14 = value14;
	}

	public int getValue15() {
		return value15;
	}

	public void setValue15(int value15) {
		this.value15 = value15;
	}

	public String getYue() {
		return yue;
	}

	public void setYue(String yue) {
		this.yue = yue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}