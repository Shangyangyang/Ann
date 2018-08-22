package cn.ainannan.commons.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.sanselan.Sanselan;
import org.apache.sanselan.common.IImageMetadata;

public class ImageUtils {
	
	/**
	 * 获取拍摄日期
	 * @param fileName
	 * @return
	 */
	public static Date getOriginalDate(String fileName) {
		File imageFile = new File(fileName);
		IImageMetadata metadata = null;
		try {
			metadata = Sanselan.getMetadata(imageFile);
		} catch (Exception e) {
			// System.out.println("异常:" + fileName);
			return null;
		}
		
		if (metadata == null) {
			// System.out.println("对象为空:" + fileName);
			return null;
		}
		
		Date d = null;
		ArrayList items = metadata.getItems();
		
		for (Object item : items) {
						
			String str = item.toString();
			
			if(str.indexOf("Date Time Original") > -1){
				String date = str.split(": ")[1].replace("'", "");
				// System.out.println(fileName + "::" + date);
				try {
					d = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(date);
				} catch (ParseException e) {
					return null;
				}
			}
		}
		
		return d;
	}
	
}
