package com.newheyd.base.util;

public class ConstUtil {
	
	public static final String HAD_LOGINED = "had.logined";
	public static final String SESSION_USER = "session.user";

	public static final String SESSION_LOGIN_FLAG = "session.login.flag";
	
	public static final String SESSION_USER_CODE = "session.user.code";
	public static final String SESSION_USER_PHONE = "session.user.phone";
	public static final String SESSION_USER_CHECK = "session.user.check";
	public static final String SESSION_OFFICE_CODE = "session.office.code";
	public static final String SESSION_AREA_CODE = "session.area.code";

	public static final String SESSION_QRCODE = "login.qrcode";


	public static final String SESSION_OFFICE = "session.office";//officeName officeLevel officeCode
	public static final String SESSION_AREA = "session.area";//areaName areaLevel areaCode
	
	public static final String SESSION_USER_OBJECT = "session.user.object";
	public static final String SESSION_OFFICE_OBJECT = "session.office.object";
	public static final String SESSION_AREA_OBJECT = "session.area.object";

	public static final String SESSION_MENU_LIST = "session.menu.list";
	public static final String SESSION_MENU_MAPS = "session.menu.maps";
	public static final String SESSION_RESOURCE_LIST = "session.resource.list";

	public static final String SESSION_SERVICE = "session.service";
	public static final String SESSION_SMS_CODE = "session.sms.code";

	public static final String SESSION_ERROR_COUNT = "session.error.count";

	public static final String SESSION_KICK_OUT = "session.kick.out";

	public static final String SESSION_WEBSOCKET_SESSION = "session.websocket.session";

	public static final String JWT_ACCESS_TOKEN  = "accessToken";

	public static final String JWT_REFRESH_TOKEN  = "refreshToken";
	//token 过期时间 分钟
	public  static final long ACCESS_TOKEN_EXPIRES_MINS=1;
	public  static final long REFRESH_TOKEN_EXTEND_MINS=60;


	public static final String FLAG_KICK_OUT = "1";


	//token 过期时间 分钟
	public  static final long TOKEN_EXPIRES_MINS=180;
	public  static final long TOKEN_EXTEND_MINS=60;
	public  static final String AUTHORIZATION="authorization";
	public  static final String CURRENT_USER_CODE="user_code";

	/**
	 * 公共附件上传业务方法存储业务对象ID，供附件关联使用。
	 */
	public static final String UPLOAD_FILE_RELATION_ID = "uploadFileRelationId";


	//单独保存残疾人唯一编码，提供给公共附件拦截器使用
	public static final String SESSION_CITIZEN_CODE = "session.citizen.code";



}
