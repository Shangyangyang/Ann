package cn.ainannan.sys.test.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class PdfTestTable2 {


    /**
     * 表格各种属性综合使用
     *
     * @throws IOException
     * @throws DocumentException
     */
    public static void createTablePdf() throws IOException, DocumentException {
        Document document = new Document();
        // 创建PdfWriter对象
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/MyPdfTestTable.pdf"));
        // 打开文档
        document.open();

        // 添加表格，4列
        PdfPTable table = new PdfPTable(4);
        // 设置表格宽度比例为%100
        table.setWidthPercentage(100);
        // 设置表格的宽度
        table.setTotalWidth(500);
        // 也可以每列分别设置宽度
        table.setTotalWidth(new float[]{160, 70, 130, 100});
        // 锁住宽度
        table.setLockedWidth(true);
        // 设置表格上面空白宽度
        table.setSpacingBefore(10f);
        // 设置表格下面空白宽度
        table.setSpacingAfter(10f);
        // 设置表格默认为无边框
        table.getDefaultCell().setBorder(0);
        PdfContentByte cb = writer.getDirectContent();

        // 构建每个单元格
        PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
        // 边框颜色
        cell1.setBorderColor(BaseColor.BLUE);
        // 设置背景颜色
        cell1.setBackgroundColor(BaseColor.ORANGE);
        // 设置跨两行
        cell1.setRowspan(2);
        // 设置距左边的距离
        cell1.setPaddingLeft(10);
        // 设置高度
        cell1.setFixedHeight(20);
        // 设置内容水平居中显示
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        // 设置垂直居中
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell1);

        PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
        cell2.setBorderColor(BaseColor.GREEN);
        cell2.setPaddingLeft(10);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell2);

        PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
        cell3.setBorderColor(BaseColor.RED);
        cell3.setPaddingLeft(10);
        // 设置无边框
        cell3.setBorder(Rectangle.NO_BORDER);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell3);

        // 在表格添加图片
        Image cellimg = Image.getInstance(new URL("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1986451467,394304688&fm=26&gp=0.jpg"));
        PdfPCell cell4 = new PdfPCell(cellimg, true);
        cell4.setBorderColor(BaseColor.RED);
        cell4.setPaddingLeft(10);
        cell4.setFixedHeight(30);
        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell4);

        // 增加一个条形码到表格
        Barcode128 code128 = new Barcode128();
        code128.setCode("14785236987541");
        code128.setCodeType(Barcode128.CODE128);
        // 生成条形码图片
        Image code128Image = code128.createImageWithBarcode(cb, null, null);
        // 加入到表格
        PdfPCell cellcode = new PdfPCell(code128Image, true);
        cellcode.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellcode.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellcode.setFixedHeight(30);
        table.addCell(cellcode);

        PdfPCell cell5 = new PdfPCell(new Paragraph("Cell 5"));
        cell5.setPaddingLeft(10);
        // 设置占用列数
        cell5.setColspan(2);
        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell5);
        document.add(table);
        // 关闭文档
        document.close();
    }

    public static void method2() throws IOException, DocumentException {
        Document document = new Document(PageSize.A4);
        //设置表格的形式

        String filePath = "D:/模拟公章.jpg";
        Image jpg = Image.getInstance(filePath);


        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font title1 = new Font(bfChinese, 20, Font.BOLD);
        Font title2 = new Font(bfChinese, 14, Font.BOLD);
        Font title3 = new Font(bfChinese, 11, Font.BOLD);

        float[] widths1 = {0.7f, 0.3f};
        PdfPTable table1 = new PdfPTable(widths1);//设置列数为2的表格
        table1.setWidthPercentage(100);

        PdfPCell cell1 = new PdfPCell(new Paragraph("计算书", title1));
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置字体垂直居中；
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置字体水平居中，只能通过cell来居中；
        table1.addCell(cell1);

/*****************生成subtable1嵌套在table1中******************************/
        PdfPTable subtable1 = new PdfPTable(1);
        PdfPCell cell12 = new PdfPCell(new Paragraph("表1", title3));
        cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置字体垂直居中；
        cell12.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置字体水平居中，只能通过cell来居中；
//        subtable11.addCell(cell12);
//        PdfPCell pdfcell1 = new PdfPCell(subtable1);
//        table1.addCell(pdfcell1);
//
///*****************生成subtable2嵌套在subtable1中******************************/
//        PdfPTable subtable2 = new PdfPTable(2);
//        PdfPCell cell13 = new PdfPCell(new Paragraph("共17页", title3));   //设置表头的名称
//        cell13.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置字体垂直居中；
//        cell13.setHorizontalAlignment(Element.ALIGN_CENTER);//设置字体水平居中，只能通过cell来居中；
//        subtable12.addCell(cell13);
//        PdfPCell cell14 = new PdfPCell(new Paragraph("第1页", title3));   //设置表头的名称
//        cell14.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置字体垂直居中；
//        cell14.setHorizontalAlignment(Element.ALIGN_CENTER);//设置字体水平居中，只能通过cell来居中；
//        subtable12.addCell(cell14);
//        PdfPCell pdfcell2 = new PdfPCell(subtable2);
//        subtable11.addCell(pdfcell2);
//
//        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//        PdfWriter.getInstance(document, buffer);
//        document.open();
//        document.add(table1);
//        document.close();
//        out.clear();
//        out = pageContext.pushBody();
//        DataOutput output = new DataOutputStream(response.getOutputStream());
//        byte[] bytes = buffer.toByteArray();
//        response.setContentLength(bytes.length);
//        for (int i = 0; i < bytes.length; i++) {
//            output.writeByte(bytes[i]);
//
//        }
    }

    public static void method1() throws IOException, DocumentException {

        BaseFont bfChinese = new Watermark().getBaseFont();

        Document document = new Document(PageSize.A4, 80, 79, 20, 45); // A4纸大小 左、右、上、下                /* 使用中文字体 */                BaseFont bfChinese = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); // 中文处理
        Font FontChinese = new Font(bfChinese, 18, Font.BOLD); // 其他所有文字字体
        Font BoldChinese = new Font(bfChinese, 14, Font.BOLD); // 粗体
        Font titleChinese = new Font(bfChinese, 20, Font.BOLD); // 模板抬头的字体
        Font subFontChinese = new Font(bfChinese, 12, Font.BOLD); // 币种和租金金额的小一号字体
        Font moneyFontChinese = new Font(bfChinese, 8, Font.BOLD); // 币种和租金金额的小一号字体
        Font subBoldFontChinese = new Font(bfChinese, 8, Font.BOLD); // 币种和租金金额的小一号字体

        PdfWriter.getInstance(document, new FileOutputStream("D:/MyPdfTest.pdf"));
        document.open(); //打开文档

        //------------开始写数据-------------------
        Paragraph title = new Paragraph("残疾人档案", FontChinese);// 抬头
        title.setAlignment(Element.ALIGN_CENTER); // 居中设置
        title.setLeading(1f);//设置行间距//设置上面空白宽度
        document.add(title);


        title = new Paragraph("致：XXX公司", FontChinese);// 抬头
        title.setSpacingBefore(25f);//设置上面空白宽度
        document.add(title);

        title = new Paragraph("         贵我双方签署的编号为 XXX有关起租条件已满足，现将租赁合同项下相关租赁要素明示如下：", FontChinese);
        title.setLeading(22f);//设置行间距
        document.add(title);

        float[] widths = new float[]{8f, 15f, 19f, 19f, 19f, 20f};


        PdfPTable table = new PdfPTable(widths);// 建立一个pdf表格
        table.setSpacingBefore(20f);// 设置表格上面空白宽度
        table.setTotalWidth(500);// 设置表格的宽度
        table.setWidthPercentage(100);//设置表格宽度为%100
        // table.getDefaultCell().setBorder(0);//设置表格默认为无边框

        String[] tempValue = new String[]{"1", "2011-07-07", "2222", "11.11", "11.11", "3000", "9999"};    //租金期次列表
        int rowCount = 1;  //行计数器
        PdfPCell cell = null;
        //---表头
        cell = new PdfPCell(new Paragraph("期次", subBoldFontChinese));//描述
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("租金日", subBoldFontChinese));//描述
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("各期租金金额", subBoldFontChinese));//描述
        cell.setFixedHeight(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("各期租金后\n剩余租金", subBoldFontChinese));//描述
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
        cell.setFixedHeight(20);
        table.addCell(cell);


        for (int j = 1; j < tempValue.length; j++) {
            //第一列 日期
            cell = new PdfPCell(new Paragraph(rowCount + "", FontChinese));//描述
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
            table.addCell(cell);
            rowCount++;

            cell = new PdfPCell(new Paragraph(tempValue[j], FontChinese));//描述
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);  // 设置垂直居中
            table.addCell(cell);
        }
        document.add(table);

        title = new Paragraph("                租金总额：XXX", moneyFontChinese);
        title.setLeading(22f);//设置行间距
        document.add(title);
        title = new Paragraph("         特此通知！", moneyFontChinese);
        title.setLeading(22f);//设置行间距
        document.add(title);
        //-------此处增加图片和日期，因为图片会遇到跨页的问题，图片跨页，图片下方的日期就会脱离图片下方会放到上一页。
        //所以必须用表格加以固定的技巧来实现
        float[] widthes = {50f};// 设置表格的列宽和列数
        PdfPTable hiddenTable = new PdfPTable(widthes);// 建立一个pdf表格
        hiddenTable.setSpacingBefore(11f); //设置表格上空间
        hiddenTable.setTotalWidth(500);// 设置表格的宽度
        hiddenTable.setWidthPercentage(100);//设置表格宽度为%100
        hiddenTable.getDefaultCell().disableBorderSide(1);
        hiddenTable.getDefaultCell().disableBorderSide(2);
        hiddenTable.getDefaultCell().disableBorderSide(4);
        hiddenTable.getDefaultCell().disableBorderSide(8);

        Image upgif = Image.getInstance("D:/模拟公章.jpg");
        upgif.scalePercent(17.5f);//设置缩放的百分比%7.5
        upgif.setAlignment(Element.ALIGN_RIGHT);

        cell = new PdfPCell(new Paragraph("", FontChinese));//描述
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);// 设置内容水平居中显示
        cell.addElement(upgif);
        cell.setPaddingTop(0f);                //设置内容靠上位置
        cell.setPaddingBottom(0f);
        cell.setPaddingRight(20f);
        cell.setBorder(Rectangle.NO_BORDER);//设置单元格无边框
        hiddenTable.addCell(cell);

        cell = new PdfPCell(new Paragraph("XX 年 XX 月 XX 日                    ", FontChinese));//金额
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);// 设置内容水平居中显示
        cell.setPaddingTop(0f);
        cell.setPaddingRight(20f);
        cell.setBorder(Rectangle.NO_BORDER);
        hiddenTable.addCell(cell);
        document.add(hiddenTable);
        System.out.println("拼装起租通知书结束...");

        // -----------------关闭文档-----------------------
        document.close();
    }
}
