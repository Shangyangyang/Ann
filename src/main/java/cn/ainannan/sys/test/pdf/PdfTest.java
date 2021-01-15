package cn.ainannan.sys.test.pdf;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {
//得到图片缓冲区
        BufferedImage bi = new BufferedImage

                (450, 270, BufferedImage.TYPE_INT_RGB);//INT精确度达到一定,RGB三原色，高度270,宽度450

//得到它的绘制环境(这张图片的笔)


        Graphics2D g2 = (Graphics2D) bi.getGraphics();

        g2.fillRect(0, 0, 450, 270);//填充一个矩形 左上角坐标(0,0),宽270,高450;填充整张图片
//设置颜色
        g2.setColor(Color.YELLOW);
        g2.fillRect(0, 0, 450, 270);//填充整张图片(其实就是设置背景颜色)

        g2.setColor(Color.RED);
        g2.drawRect(0, 0, 450 - 3, 270 - 3); //画边框

        // g2.setFont(new Font("优设标题黑", Font.BOLD, 35)); //设置字体:字体、字号、大小
        g2.setFont(new Font("优设标题黑", 0, 100)); //设置字体:字体、字号、大小
        g2.setColor(Color.BLACK);//设置背景颜色
        File file = new File("D://app/vue3.jpg");
        BufferedImage bi2 = ImageIO.read(file);

        int tempW = bi2.getWidth();
        int tempH = bi2.getHeight();

        double lv = (double)450 / tempW;
        double th = tempH * lv;

        System.out.println("lv = " + lv);
        System.out.println("th = " + th);

        g2.drawImage(bi2,0, 0, 450, (int)th, null);
        g2.drawString("你好啊", 10, 150); //向图片上写字符串
        ImageIO.write(bi, "JPEG", new FileOutputStream("D:/app/a.jpg"));//保存图片 JPEG表示保存格式

    }


    /*public static void main(String args[]) throws IOException {
        File file = new File("D://app/test.pdf");
        PDDocument doc = PDDocument.load(file);
        //Retrieving the page
        PDPage page = doc.getPage(0);
        //Creating PDImageXObject object
        PDImageXObject pdImage = PDImageXObject.createFromFile("H:/尚羊羊/1126970918_16104215011021n.jpg", doc);
        System.out.println("pdImage.getHeight() = " + pdImage.getHeight());
        System.out.println("pdImage.getWidth() = " + pdImage.getWidth());
        //creating the PDPageContentStream object
        PDPageContentStream contents = new PDPageContentStream(doc, page);
        //Drawing the image in the PDF document
        contents.drawImage(pdImage, 25, 60);

        System.out.println("Image inserted");
        //Closing the PDPageContentStream object
        contents.close();
        //Saving the document
        doc.save("D://app/test2.pdf");
        //Closing the document
        doc.close();
    }*/

//    public static void main(String args[]) throws IOException {
//        //Loading an existing document
//        File file = new File("C:/PdfBox_Examples/my_pdf.pdf");
//        PDDocument doc = PDDocument.load(file);
//
//        //Creating a PDF Document
//        PDPage page = doc.getPage(0);
//        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
//        //Begin the Content stream
//        contentStream.beginText();
//        //Setting the font to the Content stream
//        contentStream.setFont( PDType1Font.TIMES_ROMAN, 16);
//        //Setting the leading
//        contentStream.setLeading(14.5f);
//        //Setting the position for the line
//        contentStream.newLineAtOffset(25, 725);
//        String text1 = "This is an example of adding text to a page in the pdf document. we can add as many lines";
//        String text2 = "as we want like this using the ShowText()  method of the ContentStream class";
//        //Adding text in the form of string
//        contentStream.showText(text1);
//        contentStream.newLine();
//        contentStream.showText(text2);
//        //Ending the content stream
//        contentStream.endText();
//        System.out.println("Content added");
//        //Closing the content stream
//        contentStream.close();
//        //Saving the document
//        doc.save(new File("C:/PdfBox_Examples/new.pdf"));
//        //Closing the document
//        doc.close();
//    }
}
