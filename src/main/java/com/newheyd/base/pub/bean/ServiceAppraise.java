package com.newheyd.base.pub.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.newheyd.base.base.BaseBean;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 服务评价Entity
 * @author zhangqb
 * @version 2020-06-19
 */
public class ServiceAppraise extends BaseBean {
	
	private static final long serialVersionUID = 1L;
	private String relationId;		// 关联业务
	private String serviceType;		// 服务类型
	private String areaCode;		// 行政区划
	private String name;		// 姓名
	private String idcard;		// 身份证号
	private String sex;		// 性别
	private String phone;		// 联系电话
	private String disabledType;		// 残疾类别
	private String disabledLevel;		// 残疾等级
	private String score;		// 评分
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date appraiseTime;		// 评价时间
	private String appraiseContent;		// 评价内容
	private String appraisePerson;		// 评价人
	private String appraiseSource;		// 评价来源1.工作者2残疾人
	private String feedback;		// 反馈
	private String orgbusno;		// 业务流水号
	private String projid;		// 申办号
	private String stdver;		// 标准版本号 : 描述使用的数据采集标准的版本号
	private String dataver;		// 数据版本号 : 用于重报数据的情况
	private String evalresult;		// 评价结果

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date evaldate;		// 评价时间
	private String regionId;		// 区级编码 : 区级编码
	private String signState;		// 数据同步状态

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date maketime;		// 数据存库时间

	private Integer a1;
	private Integer a2;
	private Integer a3;
	private Integer a4;
	private Integer a5;
	private String areaName;

	public ServiceAppraise() {
	}

	public ServiceAppraise(String id){
		super(id);
	}

	@Length(min=0, max=64, message="关联业务长度必须介于 0 和 64 之间")
	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	
	@Length(min=0, max=64, message="服务类型长度必须介于 0 和 64 之间")
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	@Length(min=0, max=12, message="行政区划长度必须介于 0 和 12 之间")
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	@Length(min=0, max=64, message="姓名长度必须介于 0 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=32, message="身份证号长度必须介于 0 和 32 之间")
	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	@Length(min=0, max=8, message="性别长度必须介于 0 和 8 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=18, message="联系电话长度必须介于 0 和 18 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=8, message="残疾类别长度必须介于 0 和 8 之间")
	public String getDisabledType() {
		return disabledType;
	}

	public void setDisabledType(String disabledType) {
		this.disabledType = disabledType;
	}
	
	@Length(min=0, max=8, message="残疾等级长度必须介于 0 和 8 之间")
	public String getDisabledLevel() {
		return disabledLevel;
	}

	public void setDisabledLevel(String disabledLevel) {
		this.disabledLevel = disabledLevel;
	}
	
	@Length(min=0, max=8, message="评分长度必须介于 0 和 8 之间")
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAppraiseTime() {
		return appraiseTime;
	}

	public void setAppraiseTime(Date appraiseTime) {
		this.appraiseTime = appraiseTime;
	}
	
	@Length(min=0, max=200, message="评价内容长度必须介于 0 和 200 之间")
	public String getAppraiseContent() {
		return appraiseContent;
	}

	public void setAppraiseContent(String appraiseContent) {
		this.appraiseContent = appraiseContent;
	}
	
	@Length(min=0, max=64, message="评价人长度必须介于 0 和 64 之间")
	public String getAppraisePerson() {
		return appraisePerson;
	}

	public void setAppraisePerson(String appraisePerson) {
		this.appraisePerson = appraisePerson;
	}
	

	public String getAppraiseSource() {
		return appraiseSource;
	}

	public void setAppraiseSource(String appraiseSource) {
		this.appraiseSource = appraiseSource;
	}
	
	@Length(min=0, max=512, message="反馈长度必须介于 0 和 512 之间")
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	@Length(min=0, max=40, message="业务流水号长度必须介于 0 和 40 之间")
	public String getOrgbusno() {
		return orgbusno;
	}

	public void setOrgbusno(String orgbusno) {
		this.orgbusno = orgbusno;
	}
	
	@Length(min=0, max=21, message="申办号长度必须介于 0 和 21 之间")
	public String getProjid() {
		return projid;
	}

	public void setProjid(String projid) {
		this.projid = projid;
	}
	
	public String getStdver() {
		return stdver;
	}

	public void setStdver(String stdver) {
		this.stdver = stdver;
	}
	
	public String getDataver() {
		return dataver;
	}

	public void setDataver(String dataver) {
		this.dataver = dataver;
	}
	
	@Length(min=0, max=10, message="评价结果长度必须介于 0 和 10 之间")
	public String getEvalresult() {
		return evalresult;
	}

	public void setEvalresult(String evalresult) {
		this.evalresult = evalresult;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEvaldate() {
		return evaldate;
	}

	public void setEvaldate(Date evaldate) {
		this.evaldate = evaldate;
	}
	
	@Length(min=0, max=6, message="区级编码 : 区级编码长度必须介于 0 和 6 之间")
	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	
	@Length(min=0, max=1, message="数据同步状态长度必须介于 0 和 1 之间")
	public String getSignState() {
		return signState;
	}

	public void setSignState(String signState) {
		this.signState = signState;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getMaketime() {
		return maketime;
	}

	public void setMaketime(Date maketime) {
		this.maketime = maketime;
	}

	public Integer getA1() {
		return a1;
	}

	public void setA1(Integer a1) {
		this.a1 = a1;
	}

	public Integer getA2() {
		return a2;
	}

	public void setA2(Integer a2) {
		this.a2 = a2;
	}

	public Integer getA3() {
		return a3;
	}

	public void setA3(Integer a3) {
		this.a3 = a3;
	}

	public Integer getA4() {
		return a4;
	}

	public void setA4(Integer a4) {
		this.a4 = a4;
	}

	public Integer getA5() {
		return a5;
	}

	public void setA5(Integer a5) {
		this.a5 = a5;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}