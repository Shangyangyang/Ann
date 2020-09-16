package cn.ainannan.sys.test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import cn.ainannan.commons.utils.ImageUtils;

public class GeoTest {

	public static void main(String[] args) throws JpegProcessingException, IOException {
		try {
			// 将application/x-www-from-urlencoded字符串转换成普通字符串
			String keyWord = URLDecoder.decode("%C4%E3%BA%C3", "GBK");
			System.out.println(keyWord);  //输出你好
			// 将普通字符创转换成application/x-www-from-urlencoded字符串
			String urlString = URLEncoder.encode("你好", "UTF-8");  //输出%C4%E3%BA%C3

			System.out.println(urlString);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取图片的经纬度
	 * @throws JpegProcessingException
	 * @throws IOException
	 */
	public static void method1() throws JpegProcessingException, IOException{
		File jpegFile = new File("H:\\尚羊羊\\图片\\个人相册\\2019\\IMG_20190411_114610.jpg");
		Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
		for (Directory directory : metadata.getDirectories()) {
			for (Tag tag : directory.getTags()) {
				if ("GPS Longitude".equals(tag.getTagName()) || "GPS Latitude".equals(tag.getTagName())) {
					System.out.print("name : " + tag.getTagName() + "  -->");
					System.out.println("desc : " + tag.getDescription());
					System.out.println(ImageUtils.getGeoxy("H:\\尚羊羊\\图片\\个人相册\\2019\\IMG_20190411_114610.jpg")[0]);
					System.out.println(ImageUtils.getGeoxy("H:\\尚羊羊\\图片\\个人相册\\2019\\IMG_20190411_114610.jpg")[1]);
				}
			}
		}

	}

}
