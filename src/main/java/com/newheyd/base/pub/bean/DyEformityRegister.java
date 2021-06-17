package com.newheyd.base.pub.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.newheyd.base.base.BaseBean;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 已调查信息表Entity
 * @author ky
 * @version 2018-09-19
 */
public class DyEformityRegister extends BaseBean {

	private static final long serialVersionUID = 1L;
	

	private String g200;		// 所属机构编码

	private String g200Name;

	private String g205;		// 调查批次

	private String g206;		// 现居住地址

	@Excel(name = "姓名",orderNum="3")
	private String g1;		// 残疾人姓名

	private String o14;		// 残疾人年龄

	private String o15;		// 残疾类别
	@Excel(name = "残疾类别",orderNum="5")
	private String o15Name;

	private String o16;		// 残疾等级
	@Excel(name = "残疾等级",orderNum="6")
	private String o16Name;
	private String g207;		// 残疾等级字符串

	@Excel(name = "身份证号",orderNum="4", width = 20)
	private String o17;		// 残疾人身份证号

	private String o18;		// 残疾人性别

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")		
	private Date o19;		// 残疾人出生日期

	private String o20;		// 证件类型

	private String g2;		// 残疾人证号

	private String g3;		// 户口性质

	private String g4;		// 婚姻情况

	private String o1;		// 致残原因

	private String o2;		// 生活自理

	private String g7;		// 在敬（养）老院、福利院、荣军院等居住

	private String g9;		// 非农业户口住房状况

	private String g11;		// 农业户口住房状况

	private String o3;		// 农业户口自有住房情况

	private String g37;		// 家庭无障碍改造

	private String g8;		// 非农业户口家庭收入

	private String g10;		// 农业户口家庭收入

	private String g12;		// 是否识字（1 是；2 否）

	private String g13;		// 最高学历（1未上学;2小学;3初中;4高中（中专）;5大专;6本科;7研究生）

	private String g14;		// 就读学校类型

	private String g14A;		// 普通教育机构

	private String g14B;		// 特殊教育机构

	private String g15;		// 未入学原因

	private String g16;		// 是否就业（_1就业;_2未就业）

	private String g17;		// 就业状况

	private String g18;		// 未就业主要生活来源（_1退休金（养老金）;_2财产性收入;_3社会救助与社会福利;_4家庭成员供养;_5其他; ）

	private String g19;		// 未就业主要原因（_1在校学习;_2退休;_3丧失劳动能力;_4无就业意愿;_5无就业技能;_6农用土地被征用;_7其他）

	private String g20A;		// 一年内是否获得帮扶

	private String g20B;		// 一年内获得帮扶项目

	private String g22A;		// 是否有职工社会保险

	private String g22B;		// 缴纳职工社会保险项G22B_1养老保险;G22B_2医疗保险;G22B_3其他保险（失业保险、工伤保险、生育保险）;G22A_4未参加

	private String g23;		// 是否有居民养老保险

	private String g24;		// 是否享受居民养老保险缴费补贴

	private String g25;		// 是否有居民医疗保险

	private String g26;		// 是否享受居民医疗保险缴费补贴

	private String g27A;		// 是否有社会救助

	private String g27B;		// 得到社会救助项

	private String g28A;		// 是否享受社会福利

	private String g28B;		// 享受社会福利项

	private String g29;		// 托养服务

	private String g31;		// 过去两周是否患有其他疾病

	private String g32;		// 患病是否就诊

	private String g33;		// 未就诊原因

	private String g34A;		// 是否得到过康复治疗

	private String g34B;		// 使用康复治疗方式

	private String g35;		// 未得到康复治疗原因

	private String g39;		// 是否参加文体活动

	private String g40;		// 很少参加文体活动原因

	private String g36;		// 是否需要康复服务

	private String o4;		// 康复服务手术治疗项

	private String o5;		// 康复服务功能训练项

	private String o6;		// 康复服务辅助器具项

	private String o22;		// 假肢（上肢、小腿、大腿）

	private String o7;		// 其他康复项

	private String o10;		// 教育类型

	private String o10A;		// 是否需要教育

	private String o10B;		// 义务教育

	private String o10C;		// 高中及以上教育

	private String o10D;		// 教育资金资助
	@Excel(name = "需求类别",orderNum="7")
	private String o10Name;

	private String o11A;		// 是否需要就业

	private String o11B;		// 需要就业扶持项

	private String o11C;		// 需要就业职业指导项

	private String o12A;		// 是否需要培训

	private String o12B;		// 需要培训项目

	private String g30A;		// 是否需要托养需求

	private String g30B;		// 托养需求项

	private String g38A;		// 是否需要家庭无障碍改造

	private String g38B;		// 需要家庭无障碍改造项

	private String o13A;		// 是否需要体育活动  体育活动无需求

	private String o13B;		// 需要的文体活动项

	private String g203;		// 残疾人签字（申报人）

	private String g5;		// 联系人姓名

	private String g6A;		// 联系人固话

	private String g6B;		// 联系人手机

	private String g201;		// 调查员姓名

	private String o21;		// 调查员联系电话

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")		
	private Date g202;		// 填表日期

	private String hukouNum;		// 户口号码

	private String moreNum;		// 一户多残编码

	private String researchMethod;		// 调查方式

	private String checkState;		// 核查状态

	private String odataResourse;		// odata_resourse

	private String reportX;		// report_x

	private String reportY;		// 数据来源

	private String reportName;		// report_name




	private String ext1;		// ext1

	private String ext2;		// 上报位置经度

	private String poorman;		// 上报位置纬度

	private String ext4;		// 上报位置名称

	private String ext5;		// ext5

	private String ext6;		// ext6

	private String ext7;		// ext7

	private String ext8;		// ext8

	private String ext9;		// ext9

	private String ext10;		// ext10

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")		
	private Date inputDate;		// input_date

	@Excel(name = "年度",orderNum="1")
	private String niandu;		// 年度插入时填写
	private String luoshiState; //落实状态（1.已落实，2或者为空是未落实）

	private String eduState;//教育资助落实状态（0未落实1已落实）

	private String wrx;		// 未入学查询标志，查询g15不为空的数据

	private String userAreaCode;//当前用户行政区划
	private String userAreaLevel;//当前用户行政区划级别
	private String stDate; //查询开始年度
	private String edDate; //查询结束年度
	private String jichu; //百分比被除数
	private String shixian; //百分比除数
	private String result; //百分比
	private String other; //统计的其他参数 例送教上门需求

	@Excel(name = "行政区划", orderNum = "2", width = 50)
	private String fullAreaName;

	private String yeName;
	private String parentName;

	private String tyRequire;//查询托养需求使用

	private String wentiLike;//文体特长爱好
	private String wentiLikenotNull;//文体特长爱好
	private String wentiLikeQita;//文体特长其他爱好
	private String wentiType;		// 参加文体项目
	private String wentiQita;		// 文体其他项目内容
	
	public DyEformityRegister() {
	}

	public DyEformityRegister(String id){
		super(id);
	}

	@Length(min=0, max=32, message="所属机构编码长度必须介于 0 和 32 之间")
	public String getG200() {
		return g200;
	}

	public void setG200(String g200) {
		this.g200 = g200;
	}
	

	public String getG200Name() {
		return g200Name;
	}

	public void setG200Name(String  g200Name) {
		this.g200Name = g200Name;
	}


	@Length(min=0, max=16, message="调查批次长度必须介于 0 和 16 之间")
	public String getG205() {
		return g205;
	}

	public void setG205(String g205) {
		this.g205 = g205;
	}
	



	@Length(min=0, max=64, message="现居住地址长度必须介于 0 和 64 之间")
	public String getG206() {
		return g206;
	}

	public void setG206(String g206) {
		this.g206 = g206;
	}
	



	@Length(min=0, max=32, message="残疾人姓名长度必须介于 0 和 32 之间")
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
	



	@Length(min=0, max=32, message="残疾等级字符串长度必须介于 0 和 32 之间")
	public String getG207() {
		return g207;
	}

	public void setG207(String g207) {
		this.g207 = g207;
	}
	



	@Length(min=0, max=18, message="残疾人身份证号长度必须介于 0 和 18 之间")
	public String getO17() {
		return o17;
	}

	public void setO17(String o17) {
		this.o17 = o17;
	}
	



	@Length(min=0, max=8, message="残疾人性别长度必须介于 0 和 8 之间")
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
	



	@Length(min=0, max=8, message="证件类型长度必须介于 0 和 8 之间")
	public String getO20() {
		return o20;
	}

	public void setO20(String o20) {
		this.o20 = o20;
	}
	



	@Length(min=0, max=32, message="残疾人证号长度必须介于 0 和 32 之间")
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
	



	@Length(min=0, max=8, message="婚姻情况长度必须介于 0 和 8 之间")
	public String getG4() {
		return g4;
	}

	public void setG4(String g4) {
		this.g4 = g4;
	}
	



	@Length(min=0, max=8, message="致残原因长度必须介于 0 和 8 之间")
	public String getO1() {
		return o1;
	}

	public void setO1(String o1) {
		this.o1 = o1;
	}
	



	@Length(min=0, max=32, message="生活自理长度必须介于 0 和 32 之间")
	public String getO2() {
		return o2;
	}

	public void setO2(String o2) {
		this.o2 = o2;
	}
	



	@Length(min=0, max=8, message="在敬（养）老院、福利院、荣军院等居住长度必须介于 0 和 8 之间")
	public String getG7() {
		return g7;
	}

	public void setG7(String g7) {
		this.g7 = g7;
	}
	



	@Length(min=0, max=8, message="非农业户口住房状况长度必须介于 0 和 8 之间")
	public String getG9() {
		return g9;
	}

	public void setG9(String g9) {
		this.g9 = g9;
	}
	



	@Length(min=0, max=8, message="农业户口住房状况长度必须介于 0 和 8 之间")
	public String getG11() {
		return g11;
	}

	public void setG11(String g11) {
		this.g11 = g11;
	}
	



	@Length(min=0, max=8, message="农业户口自有住房情况长度必须介于 0 和 8 之间")
	public String getO3() {
		return o3;
	}

	public void setO3(String o3) {
		this.o3 = o3;
	}
	



	@Length(min=0, max=8, message="家庭无障碍改造长度必须介于 0 和 8 之间")
	public String getG37() {
		return g37;
	}

	public void setG37(String g37) {
		this.g37 = g37;
	}
	



	@Length(min=0, max=8, message="非农业户口家庭收入长度必须介于 0 和 8 之间")
	public String getG8() {
		return g8;
	}

	public void setG8(String g8) {
		this.g8 = g8;
	}
	



	@Length(min=0, max=8, message="农业户口家庭收入长度必须介于 0 和 8 之间")
	public String getG10() {
		return g10;
	}

	public void setG10(String g10) {
		this.g10 = g10;
	}
	



	@Length(min=0, max=8, message="是否识字（1 是；2 否）长度必须介于 0 和 8 之间")
	public String getG12() {
		return g12;
	}

	public void setG12(String g12) {
		this.g12 = g12;
	}
	



	@Length(min=0, max=8, message="最高学历（1未上学;2小学;3初中;4高中（中专）;5大专;6本科;7研究生）长度必须介于 0 和 8 之间")
	public String getG13() {
		return g13;
	}

	public void setG13(String g13) {
		this.g13 = g13;
	}
	



	@Length(min=0, max=8, message="就读学校类型长度必须介于 0 和 8 之间")
	public String getG14() {
		return g14;
	}

	public void setG14(String g14) {
		this.g14 = g14;
	}
	



	@Length(min=0, max=8, message="普通教育机构长度必须介于 0 和 8 之间")
	public String getG14A() {
		return g14A;
	}

	public void setG14A(String g14A) {
		this.g14A = g14A;
	}
	



	@Length(min=0, max=8, message="特殊教育机构长度必须介于 0 和 8 之间")
	public String getG14B() {
		return g14B;
	}

	public void setG14B(String g14B) {
		this.g14B = g14B;
	}
	



	@Length(min=0, max=8, message="未入学原因长度必须介于 0 和 8 之间")
	public String getG15() {
		return g15;
	}

	public void setG15(String g15) {
		this.g15 = g15;
	}
	



	@Length(min=0, max=8, message="是否就业（_1就业;_2未就业）长度必须介于 0 和 8 之间")
	public String getG16() {
		return g16;
	}

	public void setG16(String g16) {
		this.g16 = g16;
	}
	



	@Length(min=0, max=8, message="就业状况长度必须介于 0 和 8 之间")
	public String getG17() {
		return g17;
	}

	public void setG17(String g17) {
		this.g17 = g17;
	}
	



	@Length(min=0, max=8, message="未就业主要生活来源（_1退休金（养老金）;_2财产性收入;_3社会救助与社会福利;_4家庭成员供养;_5其他; ）长度必须介于 0 和 8 之间")
	public String getG18() {
		return g18;
	}

	public void setG18(String g18) {
		this.g18 = g18;
	}
	



	@Length(min=0, max=8, message="未就业主要原因（_1在校学习;_2退休;_3丧失劳动能力;_4无就业意愿;_5无就业技能;_6农用土地被征用;_7其他）长度必须介于 0 和 8 之间")
	public String getG19() {
		return g19;
	}

	public void setG19(String g19) {
		this.g19 = g19;
	}
	



	@Length(min=0, max=8, message="一年内是否获得帮扶长度必须介于 0 和 8 之间")
	public String getG20A() {
		return g20A;
	}

	public void setG20A(String g20A) {
		this.g20A = g20A;
	}
	



	@Length(min=0, max=64, message="一年内获得帮扶项目长度必须介于 0 和 64 之间")
	public String getG20B() {
		return g20B;
	}

	public void setG20B(String g20B) {
		this.g20B = g20B;
	}
	



	@Length(min=0, max=8, message="是否有职工社会保险长度必须介于 0 和 8 之间")
	public String getG22A() {
		return g22A;
	}

	public void setG22A(String g22A) {
		this.g22A = g22A;
	}
	



	@Length(min=0, max=32, message="缴纳职工社会保险项G22B_1养老保险;G22B_2医疗保险;G22B_3其他保险（失业保险、工伤保险、生育保险）;G22A_4未参加长度必须介于 0 和 32 之间")
	public String getG22B() {
		return g22B;
	}

	public void setG22B(String g22B) {
		this.g22B = g22B;
	}
	



	@Length(min=0, max=8, message="是否有居民养老保险长度必须介于 0 和 8 之间")
	public String getG23() {
		return g23;
	}

	public void setG23(String g23) {
		this.g23 = g23;
	}
	



	@Length(min=0, max=8, message="是否享受居民养老保险缴费补贴长度必须介于 0 和 8 之间")
	public String getG24() {
		return g24;
	}

	public void setG24(String g24) {
		this.g24 = g24;
	}
	



	@Length(min=0, max=8, message="是否有居民医疗保险长度必须介于 0 和 8 之间")
	public String getG25() {
		return g25;
	}

	public void setG25(String g25) {
		this.g25 = g25;
	}
	



	@Length(min=0, max=8, message="是否享受居民医疗保险缴费补贴长度必须介于 0 和 8 之间")
	public String getG26() {
		return g26;
	}

	public void setG26(String g26) {
		this.g26 = g26;
	}
	



	@Length(min=0, max=8, message="是否有社会救助长度必须介于 0 和 8 之间")
	public String getG27A() {
		return g27A;
	}

	public void setG27A(String g27A) {
		this.g27A = g27A;
	}
	



	@Length(min=0, max=32, message="得到社会救助项长度必须介于 0 和 32 之间")
	public String getG27B() {
		return g27B;
	}

	public void setG27B(String g27B) {
		this.g27B = g27B;
	}
	



	@Length(min=0, max=8, message="是否享受社会福利长度必须介于 0 和 8 之间")
	public String getG28A() {
		return g28A;
	}

	public void setG28A(String g28A) {
		this.g28A = g28A;
	}
	



	@Length(min=0, max=32, message="享受社会福利项长度必须介于 0 和 32 之间")
	public String getG28B() {
		return g28B;
	}

	public void setG28B(String g28B) {
		this.g28B = g28B;
	}
	



	@Length(min=0, max=8, message="托养服务长度必须介于 0 和 8 之间")
	public String getG29() {
		return g29;
	}

	public void setG29(String g29) {
		this.g29 = g29;
	}
	



	@Length(min=0, max=8, message="过去两周是否患有其他疾病长度必须介于 0 和 8 之间")
	public String getG31() {
		return g31;
	}

	public void setG31(String g31) {
		this.g31 = g31;
	}
	



	@Length(min=0, max=8, message="患病是否就诊长度必须介于 0 和 8 之间")
	public String getG32() {
		return g32;
	}

	public void setG32(String g32) {
		this.g32 = g32;
	}
	



	@Length(min=0, max=64, message="未就诊原因长度必须介于 0 和 64 之间")
	public String getG33() {
		return g33;
	}

	public void setG33(String g33) {
		this.g33 = g33;
	}
	



	@Length(min=0, max=8, message="是否得到过康复治疗长度必须介于 0 和 8 之间")
	public String getG34A() {
		return g34A;
	}

	public void setG34A(String g34A) {
		this.g34A = g34A;
	}
	



	@Length(min=0, max=64, message="使用康复治疗方式长度必须介于 0 和 64 之间")
	public String getG34B() {
		return g34B;
	}

	public void setG34B(String g34B) {
		this.g34B = g34B;
	}
	



	@Length(min=0, max=64, message="未得到康复治疗原因长度必须介于 0 和 64 之间")
	public String getG35() {
		return g35;
	}

	public void setG35(String g35) {
		this.g35 = g35;
	}
	



	@Length(min=0, max=8, message="是否参加文体活动长度必须介于 0 和 8 之间")
	public String getG39() {
		return g39;
	}

	public void setG39(String g39) {
		this.g39 = g39;
	}
	



	@Length(min=0, max=64, message="很少参加文体活动原因长度必须介于 0 和 64 之间")
	public String getG40() {
		return g40;
	}

	public void setG40(String g40) {
		this.g40 = g40;
	}
	



	@Length(min=0, max=8, message="是否需要康复服务长度必须介于 0 和 8 之间")
	public String getG36() {
		return g36;
	}

	public void setG36(String g36) {
		this.g36 = g36;
	}
	



	@Length(min=0, max=64, message="康复服务手术治疗项长度必须介于 0 和 64 之间")
	public String getO4() {
		return o4;
	}

	public void setO4(String o4) {
		this.o4 = o4;
	}
	



	@Length(min=0, max=128, message="康复服务功能训练项长度必须介于 0 和 128 之间")
	public String getO5() {
		return o5;
	}

	public void setO5(String o5) {
		this.o5 = o5;
	}
	



	@Length(min=0, max=128, message="康复服务辅助器具项长度必须介于 0 和 128 之间")
	public String getO6() {
		return o6;
	}

	public void setO6(String o6) {
		this.o6 = o6;
	}
	



	@Length(min=0, max=32, message="假肢（上肢、小腿、大腿）长度必须介于 0 和 32 之间")
	public String getO22() {
		return o22;
	}

	public void setO22(String o22) {
		this.o22 = o22;
	}
	



	@Length(min=0, max=128, message="其他康复项长度必须介于 0 和 128 之间")
	public String getO7() {
		return o7;
	}

	public void setO7(String o7) {
		this.o7 = o7;
	}
	



	@Length(min=0, max=8, message="教育类型长度必须介于 0 和 8 之间")
	public String getO10() {
		return o10;
	}

	public void setO10(String o10) {
		this.o10 = o10;
	}
	



	@Length(min=0, max=8, message="是否需要教育长度必须介于 0 和 8 之间")
	public String getO10A() {
		return o10A;
	}

	public void setO10A(String o10A) {
		this.o10A = o10A;
	}
	



	@Length(min=0, max=8, message="义务教育长度必须介于 0 和 8 之间")
	public String getO10B() {
		return o10B;
	}

	public void setO10B(String o10B) {
		this.o10B = o10B;
	}
	



	@Length(min=0, max=8, message="高中及以上教育长度必须介于 0 和 8 之间")
	public String getO10C() {
		return o10C;
	}

	public void setO10C(String o10C) {
		this.o10C = o10C;
	}
	



	@Length(min=0, max=8, message="教育资金资助长度必须介于 0 和 8 之间")
	public String getO10D() {
		return o10D;
	}

	public void setO10D(String o10D) {
		this.o10D = o10D;
	}
	



	@Length(min=0, max=8, message="是否需要就业长度必须介于 0 和 8 之间")
	public String getO11A() {
		return o11A;
	}

	public void setO11A(String o11A) {
		this.o11A = o11A;
	}
	



	@Length(min=0, max=128, message="需要就业扶持项长度必须介于 0 和 128 之间")
	public String getO11B() {
		return o11B;
	}

	public void setO11B(String o11B) {
		this.o11B = o11B;
	}
	



	@Length(min=0, max=16, message="需要就业职业指导项长度必须介于 0 和 16 之间")
	public String getO11C() {
		return o11C;
	}

	public void setO11C(String o11C) {
		this.o11C = o11C;
	}
	



	@Length(min=0, max=8, message="是否需要培训长度必须介于 0 和 8 之间")
	public String getO12A() {
		return o12A;
	}

	public void setO12A(String o12A) {
		this.o12A = o12A;
	}
	



	@Length(min=0, max=256, message="需要培训项目长度必须介于 0 和 256 之间")
	public String getO12B() {
		return o12B;
	}

	public void setO12B(String o12B) {
		this.o12B = o12B;
	}
	



	@Length(min=0, max=8, message="是否需要托养需求长度必须介于 0 和 8 之间")
	public String getG30A() {
		return g30A;
	}

	public void setG30A(String g30A) {
		this.g30A = g30A;
	}
	



	@Length(min=0, max=8, message="托养需求项长度必须介于 0 和 8 之间")
	public String getG30B() {
		return g30B;
	}

	public void setG30B(String g30B) {
		this.g30B = g30B;
	}
	



	@Length(min=0, max=8, message="是否需要家庭无障碍改造长度必须介于 0 和 8 之间")
	public String getG38A() {
		return g38A;
	}

	public void setG38A(String g38A) {
		this.g38A = g38A;
	}
	



	@Length(min=0, max=256, message="需要家庭无障碍改造项长度必须介于 0 和 256 之间")
	public String getG38B() {
		return g38B;
	}

	public void setG38B(String g38B) {
		this.g38B = g38B;
	}
	



	@Length(min=0, max=8, message="是否需要体育活动  体育活动无需求长度必须介于 0 和 8 之间")
	public String getO13A() {
		return o13A;
	}

	public void setO13A(String o13A) {
		this.o13A = o13A;
	}
	



	@Length(min=0, max=128, message="需要的文体活动项长度必须介于 0 和 128 之间")
	public String getO13B() {
		return o13B;
	}

	public void setO13B(String o13B) {
		this.o13B = o13B;
	}
	



	@Length(min=0, max=32, message="残疾人签字（申报人）长度必须介于 0 和 32 之间")
	public String getG203() {
		return g203;
	}

	public void setG203(String g203) {
		this.g203 = g203;
	}
	



	@Length(min=0, max=32, message="联系人姓名长度必须介于 0 和 32 之间")
	public String getG5() {
		return g5;
	}

	public void setG5(String g5) {
		this.g5 = g5;
	}
	



	@Length(min=0, max=32, message="联系人固话长度必须介于 0 和 32 之间")
	public String getG6A() {
		return g6A;
	}

	public void setG6A(String g6A) {
		this.g6A = g6A;
	}
	



	@Length(min=0, max=32, message="联系人手机长度必须介于 0 和 32 之间")
	public String getG6B() {
		return g6B;
	}

	public void setG6B(String g6B) {
		this.g6B = g6B;
	}
	



	@Length(min=0, max=32, message="调查员姓名长度必须介于 0 和 32 之间")
	public String getG201() {
		return g201;
	}

	public void setG201(String g201) {
		this.g201 = g201;
	}
	



	@Length(min=0, max=32, message="调查员联系电话长度必须介于 0 和 32 之间")
	public String getO21() {
		return o21;
	}

	public void setO21(String o21) {
		this.o21 = o21;
	}
	



	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getG202() {
		return g202;
	}

	public void setG202(Date g202) {
		this.g202 = g202;
	}
	



	@Length(min=0, max=32, message="户口号码长度必须介于 0 和 32 之间")
	public String getHukouNum() {
		return hukouNum;
	}

	public void setHukouNum(String hukouNum) {
		this.hukouNum = hukouNum;
	}
	



	@Length(min=0, max=32, message="一户多残编码长度必须介于 0 和 32 之间")
	public String getMoreNum() {
		return moreNum;
	}

	public void setMoreNum(String moreNum) {
		this.moreNum = moreNum;
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
	



	@Length(min=0, max=2, message="odata_resourse长度必须介于 0 和 2 之间")
	public String getOdataResourse() {
		return odataResourse;
	}

	public void setOdataResourse(String odataResourse) {
		this.odataResourse = odataResourse;
	}
	



	@Length(min=0, max=64, message="report_x长度必须介于 0 和 64 之间")
	public String getReportX() {
		return reportX;
	}

	public void setReportX(String reportX) {
		this.reportX = reportX;
	}
	



	@Length(min=0, max=64, message="数据来源长度必须介于 0 和 64 之间")
	public String getReportY() {
		return reportY;
	}

	public void setReportY(String reportY) {
		this.reportY = reportY;
	}
	



	@Length(min=0, max=256, message="report_name长度必须介于 0 和 256 之间")
	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	



	@Length(min=0, max=32, message="ext1长度必须介于 0 和 32 之间")
	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	



	@Length(min=0, max=32, message="上报位置经度长度必须介于 0 和 32 之间")
	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	



	@Length(min=0, max=32, message="上报位置纬度长度必须介于 0 和 32 之间")
	public String getPoorman() {
		return poorman;
	}

	public void setPoorman(String poorman) {
		this.poorman = poorman;
	}
	



	@Length(min=0, max=32, message="上报位置名称长度必须介于 0 和 32 之间")
	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}
	



	@Length(min=0, max=32, message="ext5长度必须介于 0 和 32 之间")
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
	



	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getNiandu() {
		return niandu;
	}

	public void setNiandu(String niandu) {
		this.niandu = niandu;
	}

	public String getWrx() {
		return wrx;
	}

	public void setWrx(String wrx) {
		this.wrx = wrx;
	}

	public String getLuoshiState() {
		return luoshiState;
	}

	public void setLuoshiState(String luoshiState) {
		this.luoshiState = luoshiState;
	}

	public String getUserAreaCode() {
		return userAreaCode;
	}

	public void setUserAreaCode(String userAreaCode) {
		this.userAreaCode = userAreaCode;
	}

	public String getUserAreaLevel() {
		return userAreaLevel;
	}

	public void setUserAreaLevel(String userAreaLevel) {
		this.userAreaLevel = userAreaLevel;
	}

	public String getStDate() {
		return stDate;
	}

	public void setStDate(String stDate) {
		this.stDate = stDate;
	}

	public String getEdDate() {
		return edDate;
	}

	public void setEdDate(String edDate) {
		this.edDate = edDate;
	}

	public String getJichu() {
		return jichu;
	}

	public void setJichu(String jichu) {
		this.jichu = jichu;
	}

	public String getShixian() {
		return shixian;
	}

	public void setShixian(String shixian) {
		this.shixian = shixian;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getO15Name() {
		return o15Name;
	}

	public void setO15Name(String o15Name) {
		this.o15Name = o15Name;
	}

	public String getO16Name() {
		return o16Name;
	}

	public void setO16Name(String o16Name) {
		this.o16Name = o16Name;
	}

	public String getO10Name() {
		return o10Name;
	}

	public void setO10Name(String o10Name) {
		this.o10Name = o10Name;
	}

	public String getYeName() {
		return yeName;
	}

	public void setYeName(String yeName) {
		this.yeName = yeName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getFullAreaName(){
		if(this.yeName == null) this.yeName = "";
		if(this.parentName == null) this.parentName = "";
		if(this.g200Name == null) this.g200Name = "";
		return this.yeName + this.parentName + this.g200Name;
	}

	public String getEduState() {
		return eduState;
	}

	public void setEduState(String eduState) {
		this.eduState = eduState;
	}

	public String getTyRequire() {
		return tyRequire;
	}

	public void setTyRequire(String tyRequire) {
		this.tyRequire = tyRequire;
	}

	public String getWentiLike() {
		return wentiLike;
	}

	public void setWentiLike(String wentiLike) {
		this.wentiLike = wentiLike;
	}

	public String getWentiLikenotNull() {
		return wentiLikenotNull;
	}

	public void setWentiLikenotNull(String wentiLikenotNull) {
		this.wentiLikenotNull = wentiLikenotNull;
	}

	public String getWentiLikeQita() {
		return wentiLikeQita;
	}

	public void setWentiLikeQita(String wentiLikeQita) {
		this.wentiLikeQita = wentiLikeQita;
	}

	public String getWentiType() {
		return wentiType;
	}

	public void setWentiType(String wentiType) {
		this.wentiType = wentiType;
	}

	public String getWentiQita() {
		return wentiQita;
	}

	public void setWentiQita(String wentiQita) {
		this.wentiQita = wentiQita;
	}
}