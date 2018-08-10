package cn.ainannan.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 获得以当前日期为基础的文件名后缀，如（20080808123005）
	 * @return
	 */
	public static String getFilenameByDate(){
		return "(" + getStrCurrDate("yyyyMMddHHmmss") + ")";
	}
	
	/**
	 * 判断两个日期是否同一天
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean sameDay(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);

		boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
		boolean isSameMonth = isSameYear
				&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		boolean isSameDate = isSameMonth
				&& cal1.get(Calendar.DAY_OF_MONTH) == cal2
						.get(Calendar.DAY_OF_MONTH);

		return isSameDate;
	}
	
	/**
	 * 获得当前年度，String类型
	 * @return
	 */
	public static String getCurrNiandu(){
		return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	}
	
	/**
	 * 无参的默认“yyyy-MM-dd”
	 * @return
	 */
	public static String getStrCurrDate(){
		return getStrDate(new Date(), "yyyy-MM-dd");
	}
	
	/**
	 * 获得当前日期指定格式的字符串
	 * @param format 指定格式
	 * @return 字符串
	 */
	public static String getStrCurrDate(String format){
		return getStrDate(new Date(), format);
	}
	
	/**
	 * 获得指定日期指定格式的字符串格式
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getStrDate(Date date, String format){
		if(null == date){
			return null;
		}
		return new SimpleDateFormat(format).format(date);
	}
	
	/**
	 * 默认“yyyy-MM-dd”
	 * @param date
	 * @return
	 */
	public static String getStrDate(Date date) {
		if(null == date){
			return null;
		}
		return getStrDate(date, "yyyy-MM-dd");
	}

	/**
	 * 默认“yyyy-MM-dd”
	 * @param date
	 * @return
	 */
	public static Date getDate(String date){
		if(null == date){
			return null;
		}
		return getDate("yyyy-MM-dd", date);
	}
	
	/**
	 * 根据字符串转换成日期类型
	 * @param format
	 * @param date
	 * @return
	 */
	public static Date getDate(String format, String date){
		Date d = null;
		
		try {
			d = new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return d;
	}

}	
