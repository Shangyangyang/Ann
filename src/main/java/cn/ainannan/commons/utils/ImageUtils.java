package cn.ainannan.commons.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.sanselan.Sanselan;
import org.apache.sanselan.common.IImageMetadata;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

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
	
	/**
	 * 读取照片里面的信息
	 */
	public static void printImageTags(File file) throws ImageProcessingException, Exception {
		Metadata metadata = ImageMetadataReader.readMetadata(file);
		for (Directory directory : metadata.getDirectories()) {
			for (Tag tag : directory.getTags()) {
				String tagName = tag.getTagName(); // 标签名
				String desc = tag.getDescription(); // 标签信息
				if (tagName.equals("Image Height")) {
					System.out.println("图片高度: " + desc);
				} else if (tagName.equals("Image Width")) {
					System.out.println("图片宽度: " + desc);
				} else if (tagName.equals("Date/Time Original")) {
					System.out.println("拍摄时间: " + desc);
				} else if (tagName.equals("GPS Latitude")) {
					// System.err.println("纬度 : " + desc);
					System.err.println("纬度(度分秒格式) : "+pointToLatlong(desc));
				} else if (tagName.equals("GPS Longitude")) {
					// System.err.println("经度: " + desc);
					System.err.println("经度(度分秒格式): "+pointToLatlong(desc));
				}
			}
		}
	}

	/**
	 * 经纬度格式 转换为 度分秒格式 ,如果需要的话可以调用该方法进行转换
	 * 
	 * @param point
	 *            坐标点
	 * @return
	 */
	public static String pointToLatlong(String point) {
		Double du = Double.parseDouble(point.substring(0, point.indexOf("°")).trim());
		Double fen = Double.parseDouble(point.substring(point.indexOf("°") + 1, point.indexOf("'")).trim());
		Double miao = Double.parseDouble(point.substring(point.indexOf("'") + 1, point.indexOf("\"")).trim());
		Double duStr = du + fen / 60 + miao / 60 / 60;
		return duStr.toString();
	}
	
}
