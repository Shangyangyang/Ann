package com.newheyd.pub.bean;

import cn.ainannan.base.bean.BaseBean;

import java.util.Date;

/**
 * 审核记录Entity
 * 
 * @author syy
 * @version 2018-12-21
 */
public class ShenhePrint extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String shequShenheYijian;
	private Date shequShenheDate;
	private String shequShenhePerson;
	private String jiedaoShenheYijian;
	private Date jiedaoShenheDate;
	private String jiedaoShenhePerson;
	private String quShenheYijian;
	private Date quShenheDate;
	private String quShenhePerson;
	private String shiShenheYijian;
	private Date shiShenheDate;
	private String shiShenhePerson;

	public String getJiedaoShenheYijian() {
		return jiedaoShenheYijian;
	}

	public void setJiedaoShenheYijian(String jiedaoShenheYijian) {
		this.jiedaoShenheYijian = jiedaoShenheYijian;
	}

	public Date getJiedaoShenheDate() {
		return jiedaoShenheDate;
	}

	public void setJiedaoShenheDate(Date jiedaoShenheDate) {
		this.jiedaoShenheDate = jiedaoShenheDate;
	}

	public String getJiedaoShenhePerson() {
		return jiedaoShenhePerson;
	}

	public void setJiedaoShenhePerson(String jiedaoShenhePerson) {
		this.jiedaoShenhePerson = jiedaoShenhePerson;
	}

	public String getQuShenheYijian() {
		return quShenheYijian;
	}

	public void setQuShenheYijian(String quShenheYijian) {
		this.quShenheYijian = quShenheYijian;
	}

	public Date getQuShenheDate() {
		return quShenheDate;
	}

	public void setQuShenheDate(Date quShenheDate) {
		this.quShenheDate = quShenheDate;
	}

	public String getQuShenhePerson() {
		return quShenhePerson;
	}

	public void setQuShenhePerson(String quShenhePerson) {
		this.quShenhePerson = quShenhePerson;
	}

	public String getShequShenheYijian() {
		return shequShenheYijian;
	}

	public void setShequShenheYijian(String shequShenheYijian) {
		this.shequShenheYijian = shequShenheYijian;
	}

	public Date getShequShenheDate() {
		return shequShenheDate;
	}

	public void setShequShenheDate(Date shequShenheDate) {
		this.shequShenheDate = shequShenheDate;
	}

	public String getShequShenhePerson() {
		return shequShenhePerson;
	}

	public void setShequShenhePerson(String shequShenhePerson) {
		this.shequShenhePerson = shequShenhePerson;
	}

	public String getShiShenheYijian() {
		return shiShenheYijian;
	}

	public void setShiShenheYijian(String shiShenheYijian) {
		this.shiShenheYijian = shiShenheYijian;
	}

	public Date getShiShenheDate() {
		return shiShenheDate;
	}

	public void setShiShenheDate(Date shiShenheDate) {
		this.shiShenheDate = shiShenheDate;
	}

	public String getShiShenhePerson() {
		return shiShenhePerson;
	}

	public void setShiShenhePerson(String shiShenhePerson) {
		this.shiShenhePerson = shiShenhePerson;
	}
}