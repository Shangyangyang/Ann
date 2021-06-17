package com.newheyd.base.util;

import com.alibaba.fastjson.JSONObject;
import com.newheyd.base.bean.GongAnUser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GonganUtil {

	//private static String URL = "172.20.0.40";//济南正式环境地址
	private static String URL = "172.19.220.158";//历下服务器访问地址
	//private static String URL = "localhost";//测试环境地址
	private static String POST = "9960";

	private static String GAHJ_URL = "/gateway/api/1/gaj/sel/hjxxcx";//公安接口
	private static String GAHJ_APIKEY = "504954306781249536";
	private static String GAHJ_ORGAN_ID = "JNCJRLHH";		// organ_id
	private static String GAHJ_END_USER_ID_CODE = "2";		// end_user_id_code
	private static String GAHJ_END_USER_IP = "10.15.6.246";	// end_user_ip
	

	public static GongAnUser validateGAHJ(String idcard) throws Exception{
		
		if (StringUtils.isBlank(idcard)) return null;
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("gmsfhm", idcard);
		param.put("organ_id", GAHJ_ORGAN_ID);
		param.put("end_user_id_code", GAHJ_END_USER_ID_CODE);
		param.put("end_user_ip", GAHJ_END_USER_IP);
		
		String result = HttpApiUtil.postRequest(URL, POST, GAHJ_URL, GAHJ_APIKEY, param);

		while (null == result) {
			if (result == null) {
				System.out.println("接口返回结果为空！");
			}

			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			result = HttpApiUtil.postRequest(URL, POST, GAHJ_URL, GAHJ_APIKEY, param);
		}
		//String result ="{\"code\":200,\"data\":\"{\\\"status\\\":\\\"0\\\",\\\"msg\\\":\\\"\\\",\\\"data\\\":{\\\"GMSFHM\\\":\\\"370124198903187520\\\",\\\"XM\\\":\\\"张晓慧\\\",\\\"XB\\\":\\\"女\\\",\\\"MZ\\\":\\\"汉\\\",\\\"CSRQ\\\":\\\"19890318\\\",\\\"CSD_GJHDQ\\\":\\\"中国\\\",\\\"CSD_SSXQ\\\":\\\"山东省济南市平阴县\\\",\\\"CSD_QHNXXDZ\\\":null,\\\"JG_GJHDQ\\\":\\\"中国\\\",\\\"JG_SSXQ\\\":\\\"山东省济南市平阴县\\\",\\\"WHCD\\\":\\\"小学教育\\\",\\\"HYZK\\\":\\\"未婚\\\",\\\"BYZK\\\":\\\"未服兵役\\\",\\\"SG\\\":null,\\\"ZY\\\":\\\"无业\\\",\\\"FWCS\\\":\\\"平阴县平阴镇尹庄村\\\",\\\"HJD_SSXQ\\\":\\\"山东省济南市平阴县\\\",\\\"HJD_QHNXXDZ\\\":\\\"榆山街道办事处尹庄村41号\\\",\\\"ZXBZ\\\":\\\"正常\\\",\\\"PCS\\\":\\\"山东省平阴县公安局榆山第二派出所\\\",\\\"CYM\\\":null,\\\"LXFS\\\":\\\"87868791\\\"},\\\"pageNum\\\":null,\\\"totalPage\\\":null}\",\"message\":\"\"}";
		//String result ="{\"code\":200,\"data\":\"{\\\"status\\\":\\\"0\\\",\\\"msg\\\":\\\"\\\",\\\"data\\\":{},\\\"pageNum\\\":null,\\\"totalPage\\\":null}\",\"message\":\"\"}";
		JSONObject jsonObject = JSONObject.parseObject(result);
		
		if(null == jsonObject) throw new Exception("jsonObject返回结果为空");
		
		JSONObject data = jsonObject.getJSONObject("data").getJSONObject("data");
		GongAnUser info = new GongAnUser();
		if(null == data ){
			System.out.println("data返回结果为空++++++++++++++++++++"+data);
			info.setGahjStatus("2");
			info.setGahjHjdssxq("非本市");
			return info;
		}
		info.setIdcard(idcard);
		info.setBirthTime(getDateByStr(idcard.substring(6,14)));
		if(data.getString("XM")== null || "".equals(data.getString("XM"))){
			System.out.println("data.xm 返回结果为空++++++++++++++++++++"+data);
			info.setGahjStatus("2");
			info.setGahjHjdssxq("非本市");
			return info;
			//throw new Exception("data返回结果为空");

		}
		//if(null == data) throw new Exception("data返回结果为空");
		System.out.println("data:"+data);
		info.setGahjStatus("1");
		info.setName(data.getString("XM"));
		info.setSex(data.getString("XB"));
		info.setNation(data.getString("MZ"));
		info.setBirthTime(getDateByStr(data.getString("CSRQ")));
		info.setEducation(data.getString("WHCD"));
		info.setConPhone(data.getString("LXFS"));
		info.setPolitical(data.getString("HYZK"));
		info.setDomicileArea(data.getString("HJD_SSXQ"));
		info.setResidenceArea(data.getString("HJD_QHNXXDZ"));

		info.setBYZK(data.getString("BYZK"));
		info.setSG(data.getString("SG"));
		info.setZY(data.getString("ZY"));
		info.setFWCS(data.getString("FWCS"));
		info.setStatus(data.getString("status"));
		info.setCSD_GJHDQ(data.getString("CSD_GJHDQ"));
		info.setCSD_SSXQ(data.getString("CSD_SSXQ"));
		info.setCSD_QHNXXDZ(data.getString("CSD_QHNXXDZ"));
		info.setJG_GJHDQ(data.getString("JG_GJHDQ"));
		info.setJG_SSXQ(data.getString("JG_SSXQ"));

		return info;
	}

	/**
	 * 行政区划编码去0 操作
	 * @param code
	 * @return
	 */
	public static String splitCode(String code) {

		if (code == null || "".equals(code.trim()))
			return null;
		if (code.length() != 12)
			return null;

		if (code.indexOf("0000000000") > -1)
			return code.substring(0, 2);
		if (code.indexOf("00000000") > -1)
			return code.substring(0, 4);
		if (code.indexOf("000000") > -1)
			return code.substring(0, 6);
		if (code.indexOf("000") > -1)
			return code.substring(0, 9);
		return code;
	}

	/**
	 * 字符串转日期
	 * @param yyyyMM
	 * @return
	 */
	private static Date getDateByMonth(String yyyyMM) {

		Calendar a = Calendar.getInstance();
		
		try {
			a.setTime(new SimpleDateFormat("yyyy-MM").parse(yyyyMM));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		a.roll(Calendar.DATE, -1); // 日期回滚一天，也就是最后一天
		
		a.set(Calendar.HOUR_OF_DAY, 23);
		// 分
		a.set(Calendar.MINUTE, 59);
		// 秒
		a.set(Calendar.SECOND, 59);
		// 毫秒
		a.set(Calendar.MILLISECOND, 0);
		
		return a.getTime();
	}
	private static Date getDateByStr(String dateStr) throws ParseException{
		// 2016.08.20
		// 201607
		// 2016.1
		// 2017-12-1
		// 2013-04-
		Date date = null;

		if("-".equals(dateStr.substring(4, 5))) {
			switch (dateStr.length()) {
				case 7:
					date = new SimpleDateFormat("yyyy-MM").parse(dateStr);
					break;
				case 8:
					date = new SimpleDateFormat("yyyy-MM-").parse(dateStr);
					break;
				case 9:
					date = new SimpleDateFormat("yyyy-MM-d").parse(dateStr);
					break;
				case 10:
					date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
					break;
				default:
					break;
			}
		} else if(".".equals(dateStr.substring(4, 5))) {

			switch (dateStr.length()) {
				case 6:
					date = new SimpleDateFormat("yyyy.M").parse(dateStr);
					break;
				case 7:
					date = new SimpleDateFormat("yyyy.MM").parse(dateStr);
					break;
				case 10:
					date = new SimpleDateFormat("yyyy.MM.dd").parse(dateStr);
					break;
				default:
					break;
			}
		}else{//支持身份证号截取的值 19890318
			switch (dateStr.length()) {
				case 8:
					date = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
					break;
				default:
					break;
			}
		}

		return date;
	}

	/**
	 * 根据身份证号获取年龄
	 * @param idcard
	 * @return
	 */
	public static String getAge(String idcard) {
		int nian = Integer.parseInt(idcard.substring(6, 10));
		int yue =Integer.parseInt(idcard.substring(10, 12));
		int now = Integer.parseInt(DateUtils.getDate("yyyy"));
		int age = 0;
		if(yue<=6){
			age = now - nian;
		}else{
			age = now-nian-1;
		}
		return String.valueOf(age);
	}
}
