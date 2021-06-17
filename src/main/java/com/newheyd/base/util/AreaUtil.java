package com.newheyd.base.util;


import com.newheyd.base.pub.bean.Area;

public class AreaUtil {
    public static String AreaJQ(Area a) {
        if(a==null){
            return  null;
        }
        if(StringUtils.isNotBlank(a.getAreaLevel())&&StringUtils.isNotBlank(a.getCode())){
            switch (a.getAreaLevel()) {
                case "1":
                    return   a.getCode().substring(0,2);
                case "2":
                    return   a.getCode().substring(0,4);
                case "3":
                    return   a.getCode().substring(0,6);
                case "4":
                    return   a.getCode().substring(0,9);
            }

        }
        return  a.getCode();
    }

	public static String splitCode2(String code) {
        if(StringUtils.isBlank(code))return code;
		int len = code.length();
		String newCode = "";
		switch (len) {
		case 12:
			newCode = code.substring(0, 9);
			break;
		case 9:
			newCode = code.substring(0, 6);
			break;
		case 6:
			newCode = code.substring(0, 4);
			break;
		case 4:
			newCode = code.substring(0, 2);
			break;

		default:
			break;
		}
		
		return newCode;
	}

    public static String AreaLevel(String areaCode) {
        if(areaCode==null){
            return  "5";
        }
        if(StringUtils.isNotBlank(areaCode)){
            switch (areaCode.length()) {
                case 2:
                    return   "1";
                case 4:
                    return   "2";
                case 6:
                    return   "3";
                case 9:
                    return   "4";
                case 12:
                    return   "5";
            }

        }
        return  "5";
    }

    public static String splitCode(String code) {
        if(code.indexOf("0000000000") > -1)return code.substring(0, 2);
        if(code.indexOf("00000000") > -1)return code.substring(0, 4);
        if(code.indexOf("000000") > -1)return code.substring(0, 6);
        if(code.indexOf("000") > -1)return code.substring(0, 9);
        return code;
    }

    public static String getFullCode(String areaCode) {
        if(areaCode==null){
            return  null;
        }
        if(StringUtils.isNotBlank(areaCode)){
            switch (areaCode.length()) {
                case 2:
                    return   areaCode+"0000000000";
                case 4:
                    return   areaCode+"00000000";
                case 6:
                    return   areaCode+"000000";
                case 9:
                    return   areaCode+"000";
                case 12:
                    return   areaCode;
            }

        }
        return  areaCode;
    }
}
