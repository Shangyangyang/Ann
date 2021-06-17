package com.newheyd.base.pub.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.newheyd.base.base.BaseBean;
import com.newheyd.base.util.StringUtils;
import org.hibernate.validator.constraints.Length;

import java.util.Date;


/**
 * 残疾人调查补充表Entity
 * @author 魏红珍
 * @version 2019-06-25
 */
public class DyEformityRegisterReplenish extends BaseBean {
	
	private static final long serialVersionUID = 1L;
	private Office g200;		// 残疾人所属区划
	private String g205;		// 批次
	private String registerid;		// 残疾人表id
	private String g1;		// 姓名
	private String o14;		// 年龄
	private String o15;		// 残疾类别
	private String o16;		// 残疾等级
	private String g207;		// 残疾等级串
	private String o17;		// 身份证
	private String o18;		// 性别
	private Date o19;		// 出生日期
	private String o20;		// o20
	private String g2;		// 残疾证号
	private String g3;		// 户口性质
	private String g4;		// 婚姻状况
	private String shouruly;		// 收入来源
	private String zhichuxm;		// 支出项目
	private String changzhuAddressType;		// 现常住地址是否改变
	private String changzhuAddressButongType;		// 现常住地址不同类型
	private String changzhuAddressArea;		// 现常住地址区划编码
	private String shiAddress;		// 市内详细地址
	private String banqianReason;		// 搬迁原因
	private String kfxqNum;		// 康复需求项目编号
	private String kfxqType;		// 康复需求类型
	private String kfxqQita;		// 康复需求其他需求
	private String xueshengZizhu;		// 学生资助
	private String jiatingzinvZizhu;		// 残疾家庭子女资助
	private String benrenJinxiu;		// 残疾本人进修资助
	private String eduXq;		// 学前及义务教育教育需求
	private String peixunXq;		// 培训需求
	private String peixunXqQt;		// 培训需求其他内容
	private String peixunWxq;		// 培训需求无需求
	private String peixunWxqReason;		// 培训需求无需求原因
	private String getiShifou;		// 经营类型是否为个体工商需求
	private String shangyeBaoxian;		// 参加商业保险类型
	private String tuoyangType;		// 享受托养服务类型
	private String tuoyangCost;		// 托养服务费用
	private String gooutType;		// 出行交通方式
	private String wentiType;		// 参加文体项目
	private String wentiQita;		// 文体其他项目内容
	private String wentiLike;		// 文体爱好及特长
	private String wentiLikeQita;		// 文体爱好及特长其他内容
	private String noJoinQita;		// 不参加问题活动选项其他内容
	private String researchMethod;		// 调查方式
	private String checkState;		// 核查状态
	private String odataResourse;		// 数据采集来源
	private String ext1;		// ext1
	private String ext2;		// ext2
	private String ext3;		// ext3
	private String ext4;		// ext4
	private String ext5;		// ext5
	private String ext6;		// ext6
	private String ext7;		// ext7
	private String ext8;		// ext8
	private String ext9;		// ext9
	private String ext10;		// ext10
	
	private String isEduSupport;//是否享受教育资助
	//补充调查表
    private String personalSupportFlag;//个体扶持标识
    private String xueshengZizhuFlag;		// 学生资助
	private String jiatingzinvZizhuFlag;		// 残疾家庭子女资助
	private String benrenJinxiuFlag;		// 残疾本人进修资助
    
	private String shourulyCheckBoxArrary;
	private String zhichuxmCheckBoxArrary;		// 支出项目
	private String shangyeBaoxianCheckBoxArrary;		// 参加商业保险类型
	private String gooutTypeCheckBoxArrary;		// 出行交通方式
	private String wentiTypeCheckBoxArrary;		// 参加文体项目
	private String wentiLikeCheckBoxArrary;		// 文体爱好及特长
	
	private String peixunXqCheckBoxArrary;
	
	public DyEformityRegisterReplenish() {
	}

	public DyEformityRegisterReplenish(String id){
		super(id);
	}

	public Office getG200() {
		return g200;
	}

	public void setG200(Office g200) {
		this.g200 = g200;
	}
	
	@Length(min=0, max=16, message="批次长度必须介于 0 和 16 之间")
	public String getG205() {
		return g205;
	}

	public void setG205(String g205) {
		this.g205 = g205;
	}
	
	@Length(min=1, max=32, message="残疾人表id长度必须介于 1 和 32 之间")
	public String getRegisterid() {
		return registerid;
	}

	public void setRegisterid(String registerid) {
		this.registerid = registerid;
	}
	
	@Length(min=0, max=32, message="姓名长度必须介于 0 和 32 之间")
	public String getG1() {
		return g1;
	}

	public void setG1(String g1) {
		this.g1 = g1;
	}
	
	public String getO14() {
		return o14;
	}

	public void setO14(String o14) {
		this.o14 = o14;
	}
	
	@Length(min=0, max=8, message="残疾类别长度必须介于 0 和 8 之间")
	public String getO15() {
		return o15;
	}

	public void setO15(String o15) {
		this.o15 = o15;
	}
	
	@Length(min=0, max=8, message="残疾等级长度必须介于 0 和 8 之间")
	public String getO16() {
		return o16;
	}

	public void setO16(String o16) {
		this.o16 = o16;
	}
	
	@Length(min=0, max=32, message="残疾等级串长度必须介于 0 和 32 之间")
	public String getG207() {
		return g207;
	}

	public void setG207(String g207) {
		this.g207 = g207;
	}
	
	@Length(min=0, max=18, message="身份证长度必须介于 0 和 18 之间")
	public String getO17() {
		return o17;
	}

	public void setO17(String o17) {
		this.o17 = o17;
	}
	
	@Length(min=0, max=8, message="性别长度必须介于 0 和 8 之间")
	public String getO18() {
		return o18;
	}

	public void setO18(String o18) {
		this.o18 = o18;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getO19() {
		return o19;
	}

	public void setO19(Date o19) {
		this.o19 = o19;
	}
	
	@Length(min=0, max=8, message="o20长度必须介于 0 和 8 之间")
	public String getO20() {
		return o20;
	}

	public void setO20(String o20) {
		this.o20 = o20;
	}
	
	@Length(min=0, max=32, message="残疾证号长度必须介于 0 和 32 之间")
	public String getG2() {
		return g2;
	}

	public void setG2(String g2) {
		this.g2 = g2;
	}
	
	@Length(min=0, max=8, message="户口性质长度必须介于 0 和 8 之间")
	public String getG3() {
		return g3;
	}

	public void setG3(String g3) {
		this.g3 = g3;
	}
	
	@Length(min=0, max=8, message="婚姻状况长度必须介于 0 和 8 之间")
	public String getG4() {
		return g4;
	}

	public void setG4(String g4) {
		this.g4 = g4;
	}
	
	@Length(min=0, max=50, message="收入来源长度必须介于 0 和 50 之间")
	public String getShouruly() {
		return shouruly;
	}

	public void setShouruly(String shouruly) {
		this.shouruly = shouruly;
	}
	
	@Length(min=0, max=50, message="支出项目长度必须介于 0 和 50 之间")
	public String getZhichuxm() {
		return zhichuxm;
	}

	public void setZhichuxm(String zhichuxm) {
		this.zhichuxm = zhichuxm;
	}
	
	@Length(min=0, max=8, message="现常住地址是否改变长度必须介于 0 和 8 之间")
	public String getChangzhuAddressType() {
		return changzhuAddressType;
	}

	public void setChangzhuAddressType(String changzhuAddressType) {
		this.changzhuAddressType = changzhuAddressType;
	}
	
	@Length(min=0, max=12, message="先常住地址不同类型长度必须介于 0 和 12 之间")
	public String getChangzhuAddressButongType() {
		return changzhuAddressButongType;
	}

	public void setChangzhuAddressButongType(String changzhuAddressButongType) {
		this.changzhuAddressButongType = changzhuAddressButongType;
	}
	
	@Length(min=0, max=12, message="现常住地址区划编码长度必须介于 0 和 12 之间")
	public String getChangzhuAddressArea() {
		return changzhuAddressArea;
	}

	public void setChangzhuAddressArea(String changzhuAddressArea) {
		this.changzhuAddressArea = changzhuAddressArea;
	}
	
	@Length(min=0, max=128, message="市内详细地址长度必须介于 0 和 128 之间")
	public String getShiAddress() {
		return shiAddress;
	}

	public void setShiAddress(String shiAddress) {
		this.shiAddress = shiAddress;
	}
	
	@Length(min=0, max=8, message="搬迁原因长度必须介于 0 和 8 之间")
	public String getBanqianReason() {
		return banqianReason;
	}

	public void setBanqianReason(String banqianReason) {
		this.banqianReason = banqianReason;
	}
	
	@Length(min=0, max=128, message="康复需求项目编号长度必须介于 0 和 128 之间")
	public String getKfxqNum() {
		return kfxqNum;
	}

	public void setKfxqNum(String kfxqNum) {
		this.kfxqNum = kfxqNum;
	}
	
	@Length(min=0, max=8, message="康复需求类型长度必须介于 0 和 8之间")
	public String getKfxqType() {
		return kfxqType;
	}

	public void setKfxqType(String kfxqType) {
		this.kfxqType = kfxqType;
	}
	
	@Length(min=0, max=128, message="康复需求其他需求长度必须介于 0 和 128 之间")
	public String getKfxqQita() {
		return kfxqQita;
	}

	public void setKfxqQita(String kfxqQita) {
		this.kfxqQita = kfxqQita;
	}
	
	@Length(min=0, max=8, message="学生资助长度必须介于 0 和 8 之间")
	public String getXueshengZizhu() {
		return xueshengZizhu;
	}

	public void setXueshengZizhu(String xueshengZizhu) {
		this.xueshengZizhu = xueshengZizhu;
	}
	
	@Length(min=0, max=8, message="残疾家庭子女资助长度必须介于 0 和 8 之间")
	public String getJiatingzinvZizhu() {
		return jiatingzinvZizhu;
	}

	public void setJiatingzinvZizhu(String jiatingzinvZizhu) {
		this.jiatingzinvZizhu = jiatingzinvZizhu;
	}
	
	@Length(min=0, max=8, message="残疾本人进修资助长度必须介于 0 和 8 之间")
	public String getBenrenJinxiu() {
		return benrenJinxiu;
	}

	public void setBenrenJinxiu(String benrenJinxiu) {
		this.benrenJinxiu = benrenJinxiu;
	}
	
	@Length(min=0, max=50, message="学前及义务教育教育需求长度必须介于 0 和 50 之间")
	public String getEduXq() {
		return eduXq;
	}

	public void setEduXq(String eduXq) {
		this.eduXq = eduXq;
	}
	
	@Length(min=0, max=100, message="培训需求长度必须介于 0 和 100 之间")
	public String getPeixunXq() {
		return peixunXq;
	}

	public void setPeixunXq(String peixunXq) {
		this.peixunXq = peixunXq;
	}
	
	@Length(min=0, max=128, message="培训需求其他内容长度必须介于 0 和 128 之间")
	public String getPeixunXqQt() {
		return peixunXqQt;
	}

	public void setPeixunXqQt(String peixunXqQt) {
		this.peixunXqQt = peixunXqQt;
	}
	
	@Length(min=0, max=10, message="培训需求无需求长度必须介于 0 和 10 之间")
	public String getPeixunWxq() {
		return peixunWxq;
	}

	public void setPeixunWxq(String peixunWxq) {
		this.peixunWxq = peixunWxq;
	}
	
	@Length(min=0, max=8, message="培训需求无需求原因长度必须介于 0 和 8 之间")
	public String getPeixunWxqReason() {
		return peixunWxqReason;
	}

	public void setPeixunWxqReason(String peixunWxqReason) {
		this.peixunWxqReason = peixunWxqReason;
	}
	
	@Length(min=0, max=8, message="经营类型是否为个体工商需求长度必须介于 0 和 8 之间")
	public String getGetiShifou() {
		return getiShifou;
	}

	public void setGetiShifou(String getiShifou) {
		this.getiShifou = getiShifou;
	}
	
	@Length(min=0, max=20, message="参加商业保险类型长度必须介于 0 和 20 之间")
	public String getShangyeBaoxian() {
		return shangyeBaoxian;
	}

	public void setShangyeBaoxian(String shangyeBaoxian) {
		this.shangyeBaoxian = shangyeBaoxian;
	}
	
	@Length(min=0, max=8, message="享受托养服务类型长度必须介于 0 和 8 之间")
	public String getTuoyangType() {
		return tuoyangType;
	}

	public void setTuoyangType(String tuoyangType) {
		this.tuoyangType = tuoyangType;
	}
	
	@Length(min=0, max=8, message="托养服务费用长度必须介于 0 和 8之间")
	public String getTuoyangCost() {
		return tuoyangCost;
	}

	public void setTuoyangCost(String tuoyangCost) {
		this.tuoyangCost = tuoyangCost;
	}
	
	@Length(min=0, max=50, message="出行交通方式长度必须介于 0 和 50 之间")
	public String getGooutType() {
		return gooutType;
	}

	public void setGooutType(String gooutType) {
		this.gooutType = gooutType;
	}
	
	@Length(min=0, max=50, message="参加文体项目长度必须介于 0 和 50 之间")
	public String getWentiType() {
		return wentiType;
	}

	public void setWentiType(String wentiType) {
		this.wentiType = wentiType;
	}
	
	@Length(min=0, max=128, message="文体其他项目内容长度必须介于 0 和 128 之间")
	public String getWentiQita() {
		return wentiQita;
	}

	public void setWentiQita(String wentiQita) {
		this.wentiQita = wentiQita;
	}
	
	@Length(min=0, max=100, message="文体爱好及特长长度必须介于 0 和 100 之间")
	public String getWentiLike() {
		return wentiLike;
	}

	public void setWentiLike(String wentiLike) {
		this.wentiLike = wentiLike;
	}
	
	@Length(min=0, max=128, message="文体爱好及特长其他内容长度必须介于 0 和 128 之间")
	public String getWentiLikeQita() {
		return wentiLikeQita;
	}

	public void setWentiLikeQita(String wentiLikeQita) {
		this.wentiLikeQita = wentiLikeQita;
	}
	
	@Length(min=0, max=2, message="调查方式长度必须介于 0 和 2 之间")
	public String getResearchMethod() {
		return researchMethod;
	}

	public void setResearchMethod(String researchMethod) {
		this.researchMethod = researchMethod;
	}
	
	@Length(min=0, max=2, message="核查状态长度必须介于 0 和 2 之间")
	public String getCheckState() {
		return checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}
	
	@Length(min=0, max=2, message="数据采集来源长度必须介于 0 和 2 之间")
	public String getOdataResourse() {
		return odataResourse;
	}

	public void setOdataResourse(String odataResourse) {
		this.odataResourse = odataResourse;
	}
	
	@Length(min=0, max=32, message="ext1长度必须介于 0 和 32 之间")
	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	
	@Length(min=0, max=32, message="ext2长度必须介于 0 和 32 之间")
	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	
	@Length(min=0, max=32, message="ext3长度必须介于 0 和 32 之间")
	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}
	
	@Length(min=0, max=32, message="ext4长度必须介于 0 和 32 之间")
	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}
	
	@Length(min=0, max=128, message="ext5长度必须介于 0 和 128 之间")
	public String getExt5() {
		return ext5;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}
	
	@Length(min=0, max=32, message="ext6长度必须介于 0 和 32 之间")
	public String getExt6() {
		return ext6;
	}

	public void setExt6(String ext6) {
		this.ext6 = ext6;
	}
	
	@Length(min=0, max=32, message="ext7长度必须介于 0 和 32 之间")
	public String getExt7() {
		return ext7;
	}

	public void setExt7(String ext7) {
		this.ext7 = ext7;
	}
	
	@Length(min=0, max=32, message="ext8长度必须介于 0 和 32 之间")
	public String getExt8() {
		return ext8;
	}

	public void setExt8(String ext8) {
		this.ext8 = ext8;
	}
	
	@Length(min=0, max=256, message="ext9长度必须介于 0 和 256 之间")
	public String getExt9() {
		return ext9;
	}

	public void setExt9(String ext9) {
		this.ext9 = ext9;
	}
	
	@Length(min=0, max=2000, message="ext10长度必须介于 0 和 2000 之间")
	public String getExt10() {
		return ext10;
	}

	public void setExt10(String ext10) {
		this.ext10 = ext10;
	}
	
	@Length(min=0, max=128, message="不参加问题活动选项其他内容长度必须介于 0 和 128 之间")
	public String getNoJoinQita() {
		return noJoinQita;
	}

	public void setNoJoinQita(String noJoinQita) {
		this.noJoinQita = noJoinQita;
	}

	public String getIsEduSupport() {
		return isEduSupport;
	}

	public void setIsEduSupport(String isEduSupport) {
		this.isEduSupport = isEduSupport;
	}

	public String getPersonalSupportFlag() {
		return personalSupportFlag;
	}

	public void setPersonalSupportFlag(String personalSupportFlag) {
		this.personalSupportFlag = personalSupportFlag;
	}

	public String getXueshengZizhuFlag() {
		return xueshengZizhuFlag;
	}

	public void setXueshengZizhuFlag(String xueshengZizhuFlag) {
		this.xueshengZizhuFlag = xueshengZizhuFlag;
	}

	public String getJiatingzinvZizhuFlag() {
		return jiatingzinvZizhuFlag;
	}

	public void setJiatingzinvZizhuFlag(String jiatingzinvZizhuFlag) {
		this.jiatingzinvZizhuFlag = jiatingzinvZizhuFlag;
	}

	public String getBenrenJinxiuFlag() {
		return benrenJinxiuFlag;
	}

	public void setBenrenJinxiuFlag(String benrenJinxiuFlag) {
		this.benrenJinxiuFlag = benrenJinxiuFlag;
	}
	
	public String[] getShourulyCheckBoxArrary(){
		if(shouruly == null || shouruly.trim().length() == 0)return "".split(",");
		return shouruly.split(",");
	}
	
	public void setShourulyCheckBoxArrary(String[] shourulyCheckBoxArrary){
	  if(null !=shourulyCheckBoxArrary && shourulyCheckBoxArrary.length >0){
		  StringBuffer sb = new StringBuffer();
			for(int i = 0;i<shourulyCheckBoxArrary.length;i++){
				if(StringUtils.isNotBlank(shourulyCheckBoxArrary[i])) {
				sb.append(shourulyCheckBoxArrary[i]);
				sb.append(",");
				}
			}
			this.shouruly = sb.toString(); 
	  }	
	}
	
	public String[] getZhichuxmCheckBoxArrary(){
		if(zhichuxm == null || zhichuxm.trim().length() == 0)return "".split(",");
		return zhichuxm.split(",");
	}
	
	public void setZhichuxmCheckBoxArrary(String[] zhichuxmCheckBoxArrary){
	  if(null !=zhichuxmCheckBoxArrary && zhichuxmCheckBoxArrary.length >0){
		  StringBuffer sb = new StringBuffer();
			for(int i = 0;i<zhichuxmCheckBoxArrary.length;i++){
				if(StringUtils.isNotBlank(zhichuxmCheckBoxArrary[i])) {
				sb.append(zhichuxmCheckBoxArrary[i]);
				sb.append(",");
				}
			}
			this.zhichuxm = sb.toString(); 
	  }	
	}
	
	public String[] getShangyeBaoxianCheckBoxArrary(){
		if(shangyeBaoxian == null || shangyeBaoxian.trim().length() == 0)return "".split(",");
		return shangyeBaoxian.split(",");
	}
	
	public void setShangyeBaoxianCheckBoxArrary(String[] shangyeBaoxianCheckBoxArrary){
	  if(null !=shangyeBaoxianCheckBoxArrary && shangyeBaoxianCheckBoxArrary.length >0){
		  StringBuffer sb = new StringBuffer();
			for(int i = 0;i<shangyeBaoxianCheckBoxArrary.length;i++){
				if(StringUtils.isNotBlank(shangyeBaoxianCheckBoxArrary[i])) {
				sb.append(shangyeBaoxianCheckBoxArrary[i]);
				sb.append(",");
				}
			}
			this.shangyeBaoxian = sb.toString(); 
	  }	
	}
	
	public String[] getGooutTypeCheckBoxArrary(){
		if(gooutType == null || gooutType.trim().length() == 0)return "".split(",");
		return gooutType.split(",");
	}
	
	public void setGooutTypeCheckBoxArrary(String[] gooutTypeCheckBoxArrary){
	  if(null !=gooutTypeCheckBoxArrary && gooutTypeCheckBoxArrary.length >0){
		  StringBuffer sb = new StringBuffer();
			for(int i = 0;i<gooutTypeCheckBoxArrary.length;i++){
				if(StringUtils.isNotBlank(gooutTypeCheckBoxArrary[i])) {
				sb.append(gooutTypeCheckBoxArrary[i]);
				sb.append(",");
				}
			}
			this.gooutType = sb.toString(); 
	  }	
	}
	
	public String[] getWentiTypeCheckBoxArrary(){
		if(wentiType == null || wentiType.trim().length() == 0)return "".split(",");
		return wentiType.split(",");
	}
	
	public void setWentiTypeCheckBoxArrary(String[] wentiTypeCheckBoxArrary){
	  if(null !=wentiTypeCheckBoxArrary && wentiTypeCheckBoxArrary.length >0){
		  StringBuffer sb = new StringBuffer();
			for(int i = 0;i<wentiTypeCheckBoxArrary.length;i++){
				if(StringUtils.isNotBlank(wentiTypeCheckBoxArrary[i])) {
				sb.append(wentiTypeCheckBoxArrary[i]);
				sb.append(",");
				}
			}
			this.wentiType = sb.toString(); 
	  }	
	}
	
	public String[] getWentiLikeCheckBoxArrary(){
		if(wentiLike == null || wentiLike.trim().length() == 0)return "".split(",");
		return wentiLike.split(",");
	}
	
	public void setWentiLikeCheckBoxArrary(String[] wentiLikeCheckBoxArrary){
	  if(null !=wentiLikeCheckBoxArrary && wentiLikeCheckBoxArrary.length >0){
		  StringBuffer sb = new StringBuffer();
			for(int i = 0;i<wentiLikeCheckBoxArrary.length;i++){
				if(StringUtils.isNotBlank(wentiLikeCheckBoxArrary[i])) {
				sb.append(wentiLikeCheckBoxArrary[i]);
				sb.append(",");
				}
			}
			this.wentiLike = sb.toString(); 
	  }	
	}
	
	public String[] getPeixunXqCheckBoxArrary(){
		if(peixunXq == null || peixunXq.trim().length() == 0)return "".split(",");
		return peixunXq.split(",");
	}
	
	public void setPeixunXqCheckBoxArrary(String[] peixunXqCheckBoxArrary){
	  if(null !=peixunXqCheckBoxArrary && peixunXqCheckBoxArrary.length >0){
		  StringBuffer sb = new StringBuffer();
			for(int i = 0;i<peixunXqCheckBoxArrary.length;i++){
				if(StringUtils.isNotBlank(peixunXqCheckBoxArrary[i])) {
				sb.append(peixunXqCheckBoxArrary[i]);
				sb.append(",");
				}
			}
			this.peixunXq = sb.toString(); 
	  }	
	}
	
}