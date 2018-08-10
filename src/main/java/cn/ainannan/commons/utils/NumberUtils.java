package cn.ainannan.commons.utils;

import java.math.BigDecimal;

public class NumberUtils {
	
	/**
	 * 将小数截取成2位的
	 * @param d
	 * @return
	 */
	public static Double getSubDouble(Double d) {
        return getSubDouble(d, 2);
	}
	
	/**
	 * 将小数截取成指定位的
	 * @param d
	 * @param index
	 * @return
	 */
	public static Double getSubDouble(Double d, int index) {
		BigDecimal bg = new BigDecimal(d);
        double d3 = bg.setScale(index, BigDecimal.ROUND_HALF_UP).doubleValue();
        return d3;
	}
	
}
