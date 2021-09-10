package cn.ainannan.commons.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * 新版Date处理类
 */
public class LocalDateUtil {

	public static LocalDate parseLocalDate(Date date){
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
