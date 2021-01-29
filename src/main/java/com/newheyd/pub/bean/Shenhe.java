package com.newheyd.pub.bean;

import cn.ainannan.base.bean.BaseBean;
import cn.ainannan.commons.utils.UUIDUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 审核记录Entity
 * 
 * @author syy
 * @version 2018-12-21
 */
public class Shenhe extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String relationId; // 主键关联ID

	private String shenheState; // 审核状态

	private String shenheYijian; // 审核意见
	
	private String shenhePerson; // 审核说明

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date shenheDate; // 审核日期

	private String shenheLevel; // 审核级别

	private String officeCode; // 审核节点（审核者所在机构）

	private String officeName; // 审核者所在机构名称

	private String areaCode; // 审核者所在行政区划

	private String areaName; // 审核者所在行政区划名称

	private String createname; // 创建人姓名

	private String moduletype; // 审核操作模块业务类型
	private String backLevel; // 退回节点

	/**
	 * 
	 * @param relationId 	关联id
	 * @param shenheState	审核状态
	 * @param shenheYijian	意见
	 * @param shenhePerson	人
	 * @param shenheDate	时间
	 * @param shenheLevel	等级
	 * @param officeCode	机构code
	 * @param officeName	机构
	 * @param areaCode		行政区划code
	 * @param areaName		行政区划
	 * @param moduletype	模块业务类型
	 */
	public Shenhe(/*Integer type,*/ String relationId, String shenheState, String shenheYijian, 
			String shenhePerson, Date shenheDate, String shenheLevel, String officeCode,
			String officeName, String areaCode, String areaName, String moduletype, String createBy) {
		
			this.relationId = relationId;
			this.shenheState = shenheState;
			this.shenheYijian = shenheYijian;
			this.shenhePerson = shenhePerson;
			this.shenheDate = shenheDate;
			this.shenheLevel = shenheLevel;
			this.officeCode = officeCode;
			this.officeName = officeName;
			this.areaCode = areaCode;
			this.areaName = areaName;
			this.moduletype = moduletype;

			
			this.id = UUIDUtils.getUUID().toUpperCase();
			this.createDate = new Date();
			/*
			switch (type) {
			case 1:
				this.preInsert();
				break;
			case 2:
				this.preUpdate();
				break;
			}*/
	}
	
	
	
	public Shenhe() {
	}

	public Shenhe(String id) {
		super(id);
	}
	
	

	@Length(min = 0, max = 32, message = "主键关联ID长度必须介于 0 和 32 之间")
	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	@Length(min = 0, max = 4, message = "审核状态长度必须介于 0 和 4 之间")
	public String getShenheState() {
		return shenheState;
	}

	public void setShenheState(String shenheState) {
		this.shenheState = shenheState;
	}

	@Length(min = 0, max = 500, message = "审核意见长度必须介于 0 和 500 之间")
	public String getShenheYijian() {
		return shenheYijian;
	}

	public void setShenheYijian(String shenheYijian) {
		this.shenheYijian = shenheYijian;
	}

	@Length(min = 0, max = 20, message = "审核说明长度必须介于 0 和 20 之间")
	public String getShenhePerson() {
		return shenhePerson;
	}

	public void setShenhePerson(String shenhePerson) {
		this.shenhePerson = shenhePerson;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getShenheDate() {
		return shenheDate;
	}

	public void setShenheDate(Date shenheDate) {
		this.shenheDate = shenheDate;
	}

	@Length(min = 0, max = 4, message = "审核级别长度必须介于 0 和 4 之间")
	public String getShenheLevel() {
		return shenheLevel;
	}

	public void setShenheLevel(String shenheLevel) {
		this.shenheLevel = shenheLevel;
	}

	@Length(min = 0, max = 12, message = "审核节点（审核者所在机构）长度必须介于 0 和 12 之间")
	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	@Length(min = 0, max = 100, message = "审核者所在机构名称长度必须介于 0 和 100 之间")
	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	@Length(min = 0, max = 32, message = "审核者所在行政区划长度必须介于 0 和 32 之间")
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@Length(min = 0, max = 100, message = "审核者所在行政区划名称长度必须介于 0 和 100 之间")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Length(min = 0, max = 100, message = "创建人姓名长度必须介于 0 和 100 之间")
	public String getCreatename() {
		return createname;
	}

	public void setCreatename(String createname) {
		this.createname = createname;
	}

	@Length(min = 0, max = 5, message = "审核操作模块业务类型长度必须介于 0 和 5 之间")
	public String getModuletype() {
		return moduletype;
	}

	public void setModuletype(String moduletype) {
		this.moduletype = moduletype;
	}

	public String getBackLevel() {
		return backLevel;
	}

	public void setBackLevel(String backLevel) {
		this.backLevel = backLevel;
	}

}