package cn.ainannan.sys.utils;

import cn.ainannan.commons.Constant;
import cn.ainannan.tool.fileSort.bean.FilePdfThum;
import com.itextpdf.text.pdf.PdfReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfToImage {
    private static int dpi = 96;
    public static void main2(String[] args) {
        /*String outPutPath = "D:/PDF/Data.pdf";
        String dstImgFolder = "D:\\Developer\\eclipse2017\\"
                + "pdf-logoImage-testing\\src\\test\\resources\\images";*/
        String outPutPath = "E:\\adobe\\test.pdf";
        String dstImgFolder = "E:\\adobe\\images";
        long start = System.currentTimeMillis();
        // pdf2Image(outPutPath, dstImgFolder);
        long end = System.currentTimeMillis();
        System.out.println("总共耗时：" + (end - start));
    }

    /***
     * PDF文件转PNG/JPEG图片
     * @param PdfFilePath PdfFilePathpdf完整路径
     * @param dstImgFolder imgFilePath图片存放的文件夹
     * dpi越大转换后越清晰，相对转换速度越慢,一般电脑默认96dpi
     */
    public static void pdf2Image(String PdfFilePath, String dstImgFolder, List<FilePdfThum> thumList) {

        File file = new File(PdfFilePath);
        PDDocument pdDocument;

        try {
            String imgPDFPath = file.getParent();
            int dot = file.getName().lastIndexOf('.');
            // 获取图片文件名
            String imagePDFName = file.getName().substring(0, dot);
            String imgFolderPath = null;

            if (dstImgFolder.equals("")) {
                // 获取图片存放的文件夹路径
                imgFolderPath = imgPDFPath + File.separator + imagePDFName;
            } else {
                imgFolderPath = dstImgFolder + File.separator + imagePDFName;
            }

            if (createDirectory(imgFolderPath)) {

                pdDocument = PDDocument.load(file);
                PDFRenderer renderer = new PDFRenderer(pdDocument);
                int pageNum = getPdfPageNumByPath(PdfFilePath);

                // 计算需要获取的页数
                int [] pages = getGenPages(pageNum);
                
                StringBuffer imgFilePath = null;


                for (int i = 0; i < pageNum; i++) {
                    for (int p : pages){
                        if(i == p){

                            String imgFilePathPrefix = imgFolderPath + File.separator + imagePDFName;

                            imgFilePath = new StringBuffer();
                            imgFilePath.append(imgFilePathPrefix);
                            imgFilePath.append("_");
                            imgFilePath.append(String.valueOf(i + 1));
                            imgFilePath.append(".png");// PNG
                            File dstFile = new File(imgFilePath.toString());

                            BufferedImage image = renderer.renderImageWithDPI(i, dpi);
                            ImageIO.write(image, "png", dstFile);// PNG

                            FilePdfThum thum = new FilePdfThum();
                            thum.preInsert();
                            thum.setPagenum(i + 1);
                            thum.setPath(imgFilePath.toString());
                            thum.setIsthum(Constant.NO);

                            thumList.add(thum);
                        }
                    }
                }
                System.out.println("PDF文档转PNG图片成功！");
            } else {
                System.out.println("PDF文档转PNG图片失败："
                        + "创建" + imgFolderPath + "失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取pdf文件的页数
     * @param path
     * @return
     * @throws IOException
     */
    public static int getPdfPageNumByPath(String path) throws IOException {
        PdfReader reader = new PdfReader(path);

        int pageNum = reader.getNumberOfPages();// 获取PDF页数

        return pageNum;
    }

    /**
     * 获取指定位置的页码
     * @param pageNum
     * @return
     */
    private static int[] getGenPages(int pageNum) {
        // 前三页以及中间两页及最后一页
        int[] pages = new int[6];
        if(pageNum < 7) {
            int [] ps = new int[pageNum];
            for (int i = 0; i < pageNum; i++) {
                ps[i] = i;
            }
            return ps;
        } else {
            pages[0] = 0;
            pages[1] = 1;
            pages[2] = 2;
            pages[3] = pageNum / 2;
            pages[4] = pageNum / 2 + 1;
            pages[5] = pageNum - 1;
            return pages;
        }
    }

//    public static void main(String[] args) {
//        int p = 68;
//        int[] ps = getGenPages(p);
//
//        System.out.println(ps.length);
//        for (int i : ps) {
//            System.out.println("i = " + i);
//        }
//    }

    private static boolean createDirectory(String folder) {
        File dir = new File(folder);
        if (dir.exists()) {
            return true;
        } else {
            return dir.mkdirs();
        }
    }

}
