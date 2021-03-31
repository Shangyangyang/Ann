package cn.ainannan.sys.utils;

import cn.ainannan.commons.Constant;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtil {
	
	/**
	 * 不改变分辨率的情况下减少体积
	 * @param srcfile
	 * @param descfile
	 * @param qality
	 * @return
	 * @throws IOException
	 */
	public static File compressPictureByQality(File srcfile, File descfile, float qality) throws IOException {

		BufferedImage src = null;
		FileOutputStream out = null;
		ImageWriter imgWrier;
		ImageWriteParam imgWriteParams;
		// 指定写图片的方式为 jpg
		imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
		imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);
		// 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
		imgWriteParams.setCompressionMode(imgWriteParams.MODE_EXPLICIT);
		// 这里指定压缩的程度，参数qality是取值0~1范围内，
		imgWriteParams.setCompressionQuality(qality);
		imgWriteParams.setProgressiveMode(imgWriteParams.MODE_DISABLED);
		ColorModel colorModel = ImageIO.read(srcfile).getColorModel();// ColorModel.getRGBdefault();
		// 指定压缩时使用的色彩模式7
		// imgWriteParams.setDestinationType(new
		// javax.imageio.ImageTypeSpecifier(
		// colorModel, colorModel.createCompatibleSampleModel(16, 16)));
		imgWriteParams.setDestinationType(
				new javax.imageio.ImageTypeSpecifier(colorModel, colorModel.createCompatibleSampleModel(16, 16)));

		if (!srcfile.exists()) {
			throw new FileNotFoundException("Not Found Img File,文件不存在");
		} else {
			src = ImageIO.read(srcfile);
			out = new FileOutputStream(descfile);

			imgWrier.reset();
			// 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何
			// OutputStream构造
			imgWrier.setOutput(ImageIO.createImageOutputStream(out));
			// 调用write方法，就可以向输入流写图片
			imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);
			out.flush();
			out.close();
			return descfile;
		}
	}

	/**
	 * 生成缩略图
	 * @param sourcePath
	 * @param targetPath
	 */
	public static void genThumbnail(String sourcePath, String targetPath) {
		// 判断目标在不在，不在的话先创建
		File file = new File(new File(targetPath).getParent());
		if(!file.exists()) {
			file.mkdirs();
		}
		File sourceFile = new File(sourcePath);
		File targetFile = new File(targetPath);

//		// 判断文件是否存在，如果不存在，等一会再处理
//		int count = 0;
//		while (!sourceFile.exists() && count++ < 5){
//			try {
//				Thread.sleep(1000L);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		count = 0;
//		while (!targetFile.exists() && count++ < 5){
//			try {
//				Thread.sleep(1000L);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}

		// 先降低图片质量
		try {
			ImageUtil.compressPictureByQality(sourceFile, targetFile, 0.3F);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 再缩小图片
		ImageUtil.operateByMaxSize(targetPath, targetPath,
				Constant.IMG_THUMBNAIL_SIZE, Constant.IMG_THUMBNAIL_SIZE);
	}
	
	public static void main(String[] args) {
		operateByMaxSize("D://test.jpg", "D://test2.jpg", 500, 500);
	}
	
	/**
	 * 原比例不变缩放图片
	 * @param inSrc 图片路径
	 * @param outSrc 保存图片路径
	 * @param height 最大宽度
	 * @param width 最大高度
	 * @return
	 */
	public static boolean operateByMaxSize(String inSrc, String outSrc, int height, int width){  
        boolean flag = false;  
        if(StringUtils.isBlank(inSrc) || StringUtils.isBlank(outSrc)){  
            return flag;  
        }  
        try {  
            Thumbnails.of(inSrc).size(width, height).toFile(outSrc);  
            flag = true;  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return flag;  
    } 
}
