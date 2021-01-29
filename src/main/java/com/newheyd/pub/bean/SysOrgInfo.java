package com.newheyd.pub.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import cn.ainannan.base.bean.BaseBean;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 服务机构管理Entity
 * @author dd
 * @version 2019-09-17
 */
public class SysOrgInfo extends BaseBean {

	private static final long serialVersionUID = 1L;
	

	private String orgCode;		// 机构编码

	@Excel(name = "单位名称",orderNum="3",width = 30)
	private String orgName;		// 机构名称

	private String orgType;		// 机构类型

	@Excel(name = "类型",orderNum="6",width = 10)
	private String orgTypeName;		// 机构类型

	private String areaCode;		// 所属区域编码

	private String areaName;		// 所属区域名称

	@Excel(name = "负责人/联系人",orderNum="4",width = 16)
	private String orgContacter;		// 联系人

	@Excel(name = "地址",orderNum="7",width = 50)
	private String orgAddress;		// 地址

	@Excel(name = "联系电话",orderNum="5",width = 15)
	private String orgPhone;		// 联系电话

	private String orgEmail;		// 邮箱

	private String orgAffiliation;		// 机构隶属于

	private String orgLevel;		// 机构级别

	private String orgSerciveType;		// 机构服务类型

	private String orgSerciveTime;		// 机构服务时间

	private String orgSerciveIdtKind;		// 机构服务残疾人类别

	private String orgSerciveArea;		// 机构服务区域

	private String orgSerciveAbility;		// 机构服务能力 X人

	private String orgSerciveChildren;		// 是否儿童服务机构

	private String orgRemarks;		// 备注

	private BigDecimal geoLongitude;		// GPS经度

	private BigDecimal geoLatitude;		// GPS纬度

	private String account;		// 账号

	private String password;		// 密码

	private String state;		// 状态

	private int distance;	//距离

	private String personNum;

	@Excel(name = "年度",orderNum="1")
	private String ext1;		// 年度

	private String ext2;		// 创建单位

	private String ext3;		// 职务

	private String ext4;		// 法人

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ext5;		// 注册时间
	private String quAreaName;
	@Excel(name = "行政区划",orderNum="2",width = 20)
	private String areaNameFull;
	private String areaCodeFull;
	
	public SysOrgInfo() {
	}

	public SysOrgInfo(String id){
		super(id);
	}

	@Length(min=0, max=50, message="机构编码长度必须介于 0 和 50 之间")
	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}


	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Length(min=0, max=100, message="机构名称长度必须介于 0 和 100 之间")
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	



	@Length(min=0, max=50, message="机构类型长度必须介于 0 和 50 之间")
	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	



	@Length(min=0, max=12, message="所属区域编码长度必须介于 0 和 12 之间")
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getQuAreaName() {
		return quAreaName;
	}

	public void setQuAreaName(String quAreaName) {
		this.quAreaName = quAreaName;
	}

	public String getAreaNameFull() {
		if(quAreaName != null && !quAreaName.equals(areaName)){
			return quAreaName+areaName;
		}
		return areaName;
	}

	public void setAreaNameFull(String areaNameFull) {
		this.areaNameFull = areaNameFull;
	}

	@Length(min=0, max=100, message="所属区域名称长度必须介于 0 和 100 之间")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	public String getOrgTypeName() {
		return orgTypeName;
	}

	public void setOrgTypeName(String orgTypeName) {
		this.orgTypeName = orgTypeName;
	}

	@Length(min=0, max=50, message="联系人长度必须介于 0 和 50 之间")
	public String getOrgContacter() {
		return orgContacter;
	}

	public void setOrgContacter(String orgContacter) {
		this.orgContacter = orgContacter;
	}
	



	@Length(min=0, max=200, message="地址长度必须介于 0 和 200 之间")
	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}
	



	@Length(min=0, max=20, message="联系电话长度必须介于 0 和 20 之间")
	public String getOrgPhone() {
		return orgPhone;
	}

	public void setOrgPhone(String orgPhone) {
		this.orgPhone = orgPhone;
	}
	



	@Length(min=0, max=50, message="邮箱长度必须介于 0 和 50 之间")
	public String getOrgEmail() {
		return orgEmail;
	}

	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}
	



	@Length(min=0, max=2, message="机构隶属于长度必须介于 0 和 2 之间")
	public String getOrgAffiliation() {
		return orgAffiliation;
	}

	public void setOrgAffiliation(String orgAffiliation) {
		this.orgAffiliation = orgAffiliation;
	}
	



	@Length(min=0, max=2, message="机构级别长度必须介于 0 和 2 之间")
	public String getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}
	



	@Length(min=0, max=2, message="机构服务类型长度必须介于 0 和 2 之间")
	public String getOrgSerciveType() {
		return orgSerciveType;
	}

	public void setOrgSerciveType(String orgSerciveType) {
		this.orgSerciveType = orgSerciveType;
	}
	



	@Length(min=0, max=50, message="机构服务时间长度必须介于 0 和 50 之间")
	public String getOrgSerciveTime() {
		return orgSerciveTime;
	}

	public void setOrgSerciveTime(String orgSerciveTime) {
		this.orgSerciveTime = orgSerciveTime;
	}
	



	@Length(min=0, max=50, message="机构服务残疾人类别长度必须介于 0 和 50 之间")
	public String getOrgSerciveIdtKind() {
		return orgSerciveIdtKind;
	}

	public void setOrgSerciveIdtKind(String orgSerciveIdtKind) {
		this.orgSerciveIdtKind = orgSerciveIdtKind;
	}
	



	@Length(min=0, max=50, message="机构服务区域长度必须介于 0 和 50 之间")
	public String getOrgSerciveArea() {
		return orgSerciveArea;
	}

	public void setOrgSerciveArea(String orgSerciveArea) {
		this.orgSerciveArea = orgSerciveArea;
	}
	



	@Length(min=0, max=50, message="机构服务能力 X人长度必须介于 0 和 50 之间")
	public String getOrgSerciveAbility() {
		return orgSerciveAbility;
	}

	public void setOrgSerciveAbility(String orgSerciveAbility) {
		this.orgSerciveAbility = orgSerciveAbility;
	}
	



	@Length(min=0, max=2, message="是否儿童服务机构长度必须介于 0 和 2 之间")
	public String getOrgSerciveChildren() {
		return orgSerciveChildren;
	}

	public void setOrgSerciveChildren(String orgSerciveChildren) {
		this.orgSerciveChildren = orgSerciveChildren;
	}
	



	@Length(min=0, max=255, message="备注长度必须介于 0 和 255 之间")
	public String getOrgRemarks() {
		return orgRemarks;
	}

	public void setOrgRemarks(String orgRemarks) {
		this.orgRemarks = orgRemarks;
	}


	public BigDecimal getGeoLongitude() {
		return geoLongitude;
	}

	public void setGeoLongitude(BigDecimal geoLongitude) {
		this.geoLongitude = geoLongitude;
	}

	public BigDecimal getGeoLatitude() {
		return geoLatitude;
	}

	public void setGeoLatitude(BigDecimal geoLatitude) {
		this.geoLatitude = geoLatitude;
	}

	@Length(min=0, max=50, message="账号长度必须介于 0 和 50 之间")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	



	@Length(min=0, max=50, message="密码长度必须介于 0 和 50 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	



	@Length(min=0, max=2, message="状态长度必须介于 0 和 2 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	



	@Length(min=0, max=255, message="ext1长度必须介于 0 和 255 之间")
	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	



	@Length(min=0, max=255, message="ext2长度必须介于 0 和 255 之间")
	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	



	@Length(min=0, max=255, message="ext3长度必须介于 0 和 255 之间")
	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}




	@Length(min=0, max=255, message="ext4长度必须介于 0 和 255 之间")
	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}




	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getExt5() {
		return ext5;
	}

	public void setExt5(Date ext5) {
		this.ext5 = ext5;
	}


	public String getPersonNum() {
		return personNum;
	}

	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}

	public String getAreaCodeFull() {
		return areaCodeFull;
	}

	public void setAreaCodeFull(String areaCodeFull) {
		this.areaCodeFull = areaCodeFull;
	}
}