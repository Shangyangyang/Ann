package com.newheyd.base.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 公安用户
 * @author zxh	
 * @version 2019-01-15
 */
public class GongAnUser {

	private String id;
	private String status;
	private String idcard;//公民身份号码
	private String  name ;//姓名
	private String  sex;// 性别
	private String  nation;// 民族
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  birthTime;// 出生日期

	private String  CSD_GJHDQ;// 出生地国家（地区） 
	private String  CSD_SSXQ;// 出生地省市县（区） 
	private String  CSD_QHNXXDZ;// 出生地详址 
	private String  JG_GJHDQ;// 籍贯国家（地区） 
	private String  JG_SSXQ;// 籍贯省市县（区）

	private String  education;// 文化程度

	private String  political;// 婚姻状况

	private String  BYZK;// 兵役状况 
	private String SG;// 身高 
	private String  ZY;// 职业 
	private String  FWCS;// 服务处所 
	private String domicileArea;// 户籍地址省市县（区）
	private String  residenceArea;// 户籍地址详址
	private String  ZXBZ;// 注销标识 
	private String PCS;// 所属公安机关名称 
	private String  CYM;// 曾用名 
	@Excel(name = "联系电话", orderNum = "11")
	private String conPhone; // 手机

	private String gahjStatus;//1 本市 2非本市
	private String gahjHjdssxq;//备注
	/*
	 * 公安户籍相关
	 */


	public GongAnUser() {
		super();

	}



	public String getCSD_GJHDQ() {
		return CSD_GJHDQ;
	}

	public void setCSD_GJHDQ(String cSD_GJHDQ) {
		CSD_GJHDQ = cSD_GJHDQ;
	}

	public String getCSD_SSXQ() {
		return CSD_SSXQ;
	}

	public void setCSD_SSXQ(String cSD_SSXQ) {
		CSD_SSXQ = cSD_SSXQ;
	}

	public String getCSD_QHNXXDZ() {
		return CSD_QHNXXDZ;
	}

	public void setCSD_QHNXXDZ(String cSD_QHNXXDZ) {
		CSD_QHNXXDZ = cSD_QHNXXDZ;
	}

	public String getJG_GJHDQ() {
		return JG_GJHDQ;
	}

	public void setJG_GJHDQ(String jG_GJHDQ) {
		JG_GJHDQ = jG_GJHDQ;
	}

	public String getJG_SSXQ() {
		return JG_SSXQ;
	}

	public void setJG_SSXQ(String jG_SSXQ) {
		JG_SSXQ = jG_SSXQ;
	}



	public String getBYZK() {
		return BYZK;
	}

	public void setBYZK(String bYZK) {
		BYZK = bYZK;
	}

	public String getSG() {
		return SG;
	}

	public void setSG(String sG) {
		SG = sG;
	}

	public String getZY() {
		return ZY;
	}

	public void setZY(String zY) {
		ZY = zY;
	}

	public String getFWCS() {
		return FWCS;
	}

	public void setFWCS(String fWCS) {
		FWCS = fWCS;
	}



	public String getZXBZ() {
		return ZXBZ;
	}

	public void setZXBZ(String zXBZ) {
		ZXBZ = zXBZ;
	}

	public String getPCS() {
		return PCS;
	}

	public void setPCS(String pCS) {
		PCS = pCS;
	}

	public String getCYM() {
		return CYM;
	}

	public void setCYM(String cYM) {
		CYM = cYM;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGahjStatus() {
		return gahjStatus;
	}

	public void setGahjStatus(String gahjStatus) {
		this.gahjStatus = gahjStatus;
	}

	public String getGahjHjdssxq() {
		return gahjHjdssxq;
	}

	public void setGahjHjdssxq(String gahjHjdssxq) {
		this.gahjHjdssxq = gahjHjdssxq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(Date birthTime) {
		this.birthTime = birthTime;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPolitical() {
		return political;
	}

	public void setPolitical(String political) {
		this.political = political;
	}

	public String getDomicileArea() {
		return domicileArea;
	}

	public void setDomicileArea(String domicileArea) {
		this.domicileArea = domicileArea;
	}

	public String getResidenceArea() {
		return residenceArea;
	}

	public void setResidenceArea(String residenceArea) {
		this.residenceArea = residenceArea;
	}

	public String getConPhone() {
		return conPhone;
	}

	public void setConPhone(String conPhone) {
		this.conPhone = conPhone;
	}
}