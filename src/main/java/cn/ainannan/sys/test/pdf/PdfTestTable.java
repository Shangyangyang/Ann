package cn.ainannan.sys.test.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PdfTestTable {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static void method1() throws Exception {
        try {
				/*String year = request.getParameter("year");
				String cycle = request.getParameter("cycle");
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");

				Date startD1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
				String startD = new SimpleDateFormat("yyyy年MM月dd日").format(startD1);
				String start = new SimpleDateFormat("yyyy年MM月").format(startD1);

				Date endD1 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
				String endD = new SimpleDateFormat("yyyy年MM月dd日").format(endD1);*/

            // 创建文件
            Document document = new Document();
            document.setPageSize(PageSize.A4);
            // 建立一个书写器
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D://PdfTestTable.pdf"));
            // 打开文件
            document.open();

            // 中文字体,解决中文不能显示问题
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

            // 蓝色字体
            Font blueFont = new Font(bfChinese);
            blueFont.setColor(BaseColor.BLUE);
            blueFont.setSize(5);

            // 小三号
            Font smallThreeFont = new Font(bfChinese, 15);
            smallThreeFont.setColor(BaseColor.BLACK);

            // 五号
            Font fiveFont = new Font(bfChinese);
            fiveFont.setColor(BaseColor.BLACK);
            fiveFont.setSize(10.5f);

            // 五号
            Font smallFiveFont = new Font(bfChinese);
            smallFiveFont.setColor(BaseColor.BLACK);
            smallFiveFont.setSize(9);

            // 五号
            Font smallSixFont = new Font(bfChinese);
            smallSixFont.setColor(BaseColor.BLACK);
            smallSixFont.setSize(6.5f);

            // 小四号 加粗
            Font greenFont = new Font(bfChinese, 12, Font.BOLD);
            greenFont.setColor(BaseColor.BLACK);

            // 小四号
            Font messFont = new Font(bfChinese, 12);
            messFont.setColor(BaseColor.BLACK);


            // 标题加粗 四号
            Font titleFont = new Font(bfChinese, 14, Font.BOLD);
            titleFont.setColor(BaseColor.BLACK);


            // 设计一个4列的表.
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100); // 宽度100%填充
            table.setSpacingBefore(10f); // 前间距
            table.setSpacingAfter(10f); // 后间距


            // 设置列宽
            float[] columnWidths = { 0.8f, 0.8f, 0.5f,0.5f};
            table.setWidths(columnWidths);
            PdfPCell cell;

            //第一行
            cell = new PdfPCell(new Phrase("", smallThreeFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_MIDDLE); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_CENTER); // 设置垂直居中
            cell.setBorder(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("记    账    凭    证", smallThreeFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorderWidthTop(0);
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthRight(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("本位币：CYN", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_BOTTOM); // 设置垂直居中
            cell.setBorder(0);
            cell.setColspan(2);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(2); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(2); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorderWidthTop(0);
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthRight(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(2); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            cell.setColspan(2);
            table.addCell(cell);

            //第二行

            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_LEFT); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("XXX公司职业年金计划", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            table.addCell(cell);


            cell = new PdfPCell(new Phrase("附单据数：0张", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setColspan(2);
            cell.setBorder(0);
            table.addCell(cell);

            //第三行

            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("凭证日期：XXXX年XX月XX日", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("凭证编号：XXXXX号", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            cell.setColspan(2);
            table.addCell(cell);

            // 设计一个4列的表.
            PdfPTable table0 = new PdfPTable(2);
            table0.setWidthPercentage(100); // 宽度100%填充


            // 设置列宽
            float[] columnWidths0 = { 0.8f, 0.8f};
            table0.setWidths(columnWidths0);
            PdfPCell cell0;

            //正文第1行
            cell0 = new PdfPCell(new Phrase("摘要", fiveFont));
            cell0.setMinimumHeight(28); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell0.setRowspan(2);
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("科目", fiveFont));
            cell0.setMinimumHeight(28); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell0.setRowspan(2);
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("{2018-11-24}税金计提", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("其他应付款-支付与转出", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            //2222222222
            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);




            //左上角
            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(150); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
//	            cell.enableBorderSide(1);
            cell.setRowspan(8);
            cell.setColspan(2);
            cell.setBorderWidthRight(0);
            cell.setBorderWidthBottom(0);
            cell.setPaddingRight(-0.2f);
            cell.addElement(table0);
            table.addCell(cell);

            // 借方发生的  设计一个10列的表.
            PdfPTable table1 = new PdfPTable(10);
            table1.setWidthPercentage(102); // 宽度100%填充
//	            table1.setSpacingBefore(10f); // 前间距
//	            table1.setSpacingAfter(10f); // 后间距

            // 设置列宽
            float[] columnWidths1 = { 0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f};
            table1.setWidths(columnWidths1);
            PdfPCell cell1;

            cell1 = new PdfPCell(new Phrase("借方发生", fiveFont));
            cell1.setMinimumHeight(13); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_TOP); // 设置垂直居中
            cell1.setColspan(10);
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("千", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("百", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("十", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("万", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("千", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("百", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("十", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("元", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("角", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("分", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //借方贷方的金额十列  第一行
            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //第二行
            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //第三行
            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //第四行
            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //第五行
            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //第六行
            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //借方7行
            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(150); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_TOP); // 设置垂直居中
            cell.setBorderWidthRight(0);
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthBottom(0);
            cell.setPaddingLeft(2.5f);
            cell.setPaddingBottom(-3);
            cell.setRowspan(8);
            cell.addElement(table1);
            table.addCell(cell);


            //贷方发生
            // 设计一个10列的表.
            PdfPTable table2 = new PdfPTable(10);
            table2.setWidthPercentage(102); // 宽度100%填充

            // 设置列宽
            float[] columnWidths2 = { 0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f};
            table2.setWidths(columnWidths2);
            PdfPCell cell2;

            cell2 = new PdfPCell(new Phrase("贷方发生", fiveFont));
            cell2.setMinimumHeight(13); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_TOP); // 设置垂直居中
            cell2.setColspan(10);
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("千", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("百", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("十", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("万", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("千", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("百", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("十", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("元", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("角", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("分", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //借方贷方的金额十列  第一行
            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //第二行
            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //第三行
            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //第四行
            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //第五行
            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //第六行
            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //贷方7行
            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(150); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_TOP); // 设置垂直居中
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthBottom(0);
            cell.setPaddingRight(3);
            cell.setPaddingBottom(-3);
            cell.setRowspan(8);
            cell.addElement(table2);
            table.addCell(cell);

            // 设计一个10列的表.
            PdfPTable table4 = new PdfPTable(1);
            table4.setWidthPercentage(100); // 宽度100%填充

            // 设置列宽
            float[] columnWidths4 = { 1.6f};
            table4.setWidths(columnWidths4);
            PdfPCell cell4;

            cell4 = new PdfPCell(new Phrase("金额合计：捌佰陆拾壹元陆角玖分", fiveFont));
            cell4.setMinimumHeight(20); // 设置单元格高度
            cell4.setUseAscender(true); // 设置可以居中
            cell4.setHorizontalAlignment(Element.ALIGN_LEFT); // 设置水平居中
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table4.addCell(cell4);

            //最后一行
            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setBorderWidthRight(0);
            cell.setBorderWidthTop(0);
            cell.setPaddingRight(-0.2f);
            cell.setPaddingTop(-0.5f);
            cell.addElement(table4);
            cell.setColspan(2);
            table.addCell(cell);

            // 设计一个10列的表.
            PdfPTable table3 = new PdfPTable(10);
            table3.setWidthPercentage(102); // 宽度100%填充

            // 设置列宽
            float[] columnWidths3 = { 0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f};
            table3.setWidths(columnWidths3);
            PdfPCell cell3;

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            //借方
            cell = new PdfPCell(new Phrase("", smallFiveFont));
            cell.setBorderWidthRight(0);
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthTop(0);
            cell.setPaddingLeft(2.5f);
            cell.setPaddingTop(-0.5f);
            cell.addElement(table3);
            table.addCell(cell);

            //贷方
            cell = new PdfPCell(new Phrase("", smallFiveFont));
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthTop(0);
            cell.setPaddingTop(-0.5f);
            cell.setPaddingRight(3);
            cell.addElement(table3);
            table.addCell(cell);

            document.add(table);

            // 表尾
            Paragraph thrtionTitle = new Paragraph("制单：系统运维人员     审核：               记账：\n\n", fiveFont);
            thrtionTitle.setLeading(10);
            thrtionTitle.setAlignment(Element.ALIGN_LEFT);
            document.add(thrtionTitle);

            // 关闭文档
            document.close();
            // 关闭书写器
            writer.close();



        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    // 生成记账凭证
    /*private static String createCertificationPDF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String planNameP = request.getParameter("planNameP");
        String ceritNameP = request.getParameter("ceritNameP");
        Date date = new Date();
        String startD = new SimpleDateFormat("HH-mm-ss").format(date);
        String oldPath = makePdfFilePath + pString +  planNameP+"_"+ceritNameP+startD+ ".pdf";
        try {
				*//*String year = request.getParameter("year");
				String cycle = request.getParameter("cycle");
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");

				Date startD1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
				String startD = new SimpleDateFormat("yyyy年MM月dd日").format(startD1);
				String start = new SimpleDateFormat("yyyy年MM月").format(startD1);

				Date endD1 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
				String endD = new SimpleDateFormat("yyyy年MM月dd日").format(endD1);*//*

            // 创建文件
            Document document = new Document();
            document.setPageSize(PageSize.A4);
            // 建立一个书写器
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(oldPath));
            // 打开文件
            document.open();

            // 中文字体,解决中文不能显示问题
            String FontChPath = PropertyUitls.getProperties("config.properties").getProperty("fontSourceSong");
            BaseFont bfChinese = BaseFont.createFont(FontChPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            // 蓝色字体
            Font blueFont = new Font(bfChinese);
            blueFont.setColor(BaseColor.BLUE);
            blueFont.setSize(5);

            // 小三号
            Font smallThreeFont = new Font(bfChinese, 15);
            smallThreeFont.setColor(BaseColor.BLACK);

            // 五号
            Font fiveFont = new Font(bfChinese);
            fiveFont.setColor(BaseColor.BLACK);
            fiveFont.setSize(10.5f);

            // 五号
            Font smallFiveFont = new Font(bfChinese);
            smallFiveFont.setColor(BaseColor.BLACK);
            smallFiveFont.setSize(9);

            // 五号
            Font smallSixFont = new Font(bfChinese);
            smallSixFont.setColor(BaseColor.BLACK);
            smallSixFont.setSize(6.5f);

            // 小四号 加粗
            Font greenFont = new Font(bfChinese, 12, Font.BOLD);
            greenFont.setColor(BaseColor.BLACK);

            // 小四号
            Font messFont = new Font(bfChinese, 12);
            messFont.setColor(BaseColor.BLACK);


            // 标题加粗 四号
            Font titleFont = new Font(bfChinese, 14, Font.BOLD);
            titleFont.setColor(BaseColor.BLACK);


            // 设计一个4列的表.
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100); // 宽度100%填充
            table.setSpacingBefore(10f); // 前间距
            table.setSpacingAfter(10f); // 后间距


            // 设置列宽
            float[] columnWidths = { 0.8f, 0.8f, 0.5f,0.5f};
            table.setWidths(columnWidths);
            PdfPCell cell;

            //第一行
            cell = new PdfPCell(new Phrase("", smallThreeFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_MIDDLE); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_CENTER); // 设置垂直居中
            cell.setBorder(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("记    账    凭    证", smallThreeFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorderWidthTop(0);
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthRight(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("本位币：CYN", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT); // 设置水平居中
            cell.setVerticalAlignment(Cell.ALIGN_BOTTOM); // 设置垂直居中
            cell.setBorder(0);
            cell.setColspan(2);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(2); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(2); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorderWidthTop(0);
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthRight(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(2); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            cell.setColspan(2);
            table.addCell(cell);

            //第二行

            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_LEFT); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("XXX公司职业年金计划", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            table.addCell(cell);


            cell = new PdfPCell(new Phrase("附单据数：0张", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setColspan(2);
            cell.setBorder(0);
            table.addCell(cell);

            //第三行

            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("凭证日期：XXXX年XX月XX日", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("凭证编号：XXXXX号", fiveFont));
            cell.setMinimumHeight(20); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell.setBorder(0);
            cell.setColspan(2);
            table.addCell(cell);

            // 设计一个4列的表.
            PdfPTable table0 = new PdfPTable(2);
            table0.setWidthPercentage(100); // 宽度100%填充


            // 设置列宽
            float[] columnWidths0 = { 0.8f, 0.8f};
            table0.setWidths(columnWidths0);
            PdfPCell cell0;

            //正文第1行
            cell0 = new PdfPCell(new Phrase("摘要", fiveFont));
            cell0.setMinimumHeight(28); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell0.setRowspan(2);
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("科目", fiveFont));
            cell0.setMinimumHeight(28); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            cell0.setRowspan(2);
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("{2018-11-24}税金计提", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("其他应付款-支付与转出", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            //2222222222
            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);

            cell0 = new PdfPCell(new Phrase("3", smallFiveFont));
            cell0.setMinimumHeight(20); // 设置单元格高度
            cell0.setUseAscender(true); // 设置可以居中
            cell0.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell0.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table0.addCell(cell0);




            //左上角
            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(150); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
//	            cell.enableBorderSide(1);
            cell.setRowspan(8);
            cell.setColspan(2);
            cell.setBorderWidthRight(0);
            cell.setBorderWidthBottom(0);
            cell.setPaddingRight(-0.2f);
            cell.addElement(table0);
            table.addCell(cell);

            // 借方发生的  设计一个10列的表.
            PdfPTable table1 = new PdfPTable(10);
            table1.setWidthPercentage(102); // 宽度100%填充
//	            table1.setSpacingBefore(10f); // 前间距
//	            table1.setSpacingAfter(10f); // 后间距

            // 设置列宽
            float[] columnWidths1 = { 0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f};
            table1.setWidths(columnWidths1);
            PdfPCell cell1;

            cell1 = new PdfPCell(new Phrase("借方发生", fiveFont));
            cell1.setMinimumHeight(13); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_TOP); // 设置垂直居中
            cell1.setColspan(10);
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("千", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("百", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("十", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("万", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("千", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("百", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("十", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("元", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("角", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("分", smallSixFont));
            cell1.setMinimumHeight(15); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //借方贷方的金额十列  第一行
            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //第二行
            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //第三行
            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //第四行
            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //第五行
            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //第六行
            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            cell1 = new PdfPCell(new Phrase("", smallSixFont));
            cell1.setMinimumHeight(20); // 设置单元格高度
            cell1.setUseAscender(true); // 设置可以居中
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table1.addCell(cell1);

            //借方7行
            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(150); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_TOP); // 设置垂直居中
            cell.setBorderWidthRight(0);
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthBottom(0);
            cell.setPaddingLeft(2.5f);
            cell.setPaddingBottom(-3);
            cell.setRowspan(8);
            cell.addElement(table1);
            table.addCell(cell);


            //贷方发生
            // 设计一个10列的表.
            PdfPTable table2 = new PdfPTable(10);
            table2.setWidthPercentage(102); // 宽度100%填充

            // 设置列宽
            float[] columnWidths2 = { 0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f};
            table2.setWidths(columnWidths2);
            PdfPCell cell2;

            cell2 = new PdfPCell(new Phrase("贷方发生", fiveFont));
            cell2.setMinimumHeight(13); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_TOP); // 设置垂直居中
            cell2.setColspan(10);
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("千", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("百", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("十", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("万", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("千", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("百", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("十", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("元", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("角", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("分", smallSixFont));
            cell2.setMinimumHeight(15); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //借方贷方的金额十列  第一行
            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //第二行
            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //第三行
            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //第四行
            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //第五行
            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //第六行
            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            cell2 = new PdfPCell(new Phrase("", smallSixFont));
            cell2.setMinimumHeight(20); // 设置单元格高度
            cell2.setUseAscender(true); // 设置可以居中
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table2.addCell(cell2);

            //贷方7行
            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setMinimumHeight(150); // 设置单元格高度
            cell.setUseAscender(true); // 设置可以居中
            cell.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell.setVerticalAlignment(Element.ALIGN_TOP); // 设置垂直居中
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthBottom(0);
            cell.setPaddingRight(3);
            cell.setPaddingBottom(-3);
            cell.setRowspan(8);
            cell.addElement(table2);
            table.addCell(cell);

            // 设计一个10列的表.
            PdfPTable table4 = new PdfPTable(1);
            table4.setWidthPercentage(100); // 宽度100%填充

            // 设置列宽
            float[] columnWidths4 = { 1.6f};
            table4.setWidths(columnWidths4);
            PdfPCell cell4;

            cell4 = new PdfPCell(new Phrase("金额合计：捌佰陆拾壹元陆角玖分", fiveFont));
            cell4.setMinimumHeight(20); // 设置单元格高度
            cell4.setUseAscender(true); // 设置可以居中
            cell4.setHorizontalAlignment(Element.ALIGN_LEFT); // 设置水平居中
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table4.addCell(cell4);

            //最后一行
            cell = new PdfPCell(new Phrase("", fiveFont));
            cell.setBorderWidthRight(0);
            cell.setBorderWidthTop(0);
            cell.setPaddingRight(-0.2f);
            cell.setPaddingTop(-0.5f);
            cell.addElement(table4);
            cell.setColspan(2);
            table.addCell(cell);

            // 设计一个10列的表.
            PdfPTable table3 = new PdfPTable(10);
            table3.setWidthPercentage(102); // 宽度100%填充

            // 设置列宽
            float[] columnWidths3 = { 0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f,0.06f};
            table3.setWidths(columnWidths3);
            PdfPCell cell3;

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            cell3 = new PdfPCell(new Phrase("", smallSixFont));
            cell3.setMinimumHeight(20); // 设置单元格高度
            cell3.setUseAscender(true); // 设置可以居中
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 设置水平居中
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 设置垂直居中
            table3.addCell(cell3);

            //借方
            cell = new PdfPCell(new Phrase("", smallFiveFont));
            cell.setBorderWidthRight(0);
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthTop(0);
            cell.setPaddingLeft(2.5f);
            cell.setPaddingTop(-0.5f);
            cell.addElement(table3);
            table.addCell(cell);

            //贷方
            cell = new PdfPCell(new Phrase("", smallFiveFont));
            cell.setBorderWidthLeft(0);
            cell.setBorderWidthTop(0);
            cell.setPaddingTop(-0.5f);
            cell.setPaddingRight(3);
            cell.addElement(table3);
            table.addCell(cell);

            document.add(table);

            // 表尾
            Paragraph thrtionTitle = new Paragraph("制单：系统运维人员     审核：               记账：\n\n", fiveFont);
            thrtionTitle.setLeading(10);
            thrtionTitle.setAlignment(Element.ALIGN_LEFT);
            document.add(thrtionTitle);

            // 关闭文档
            document.close();
            // 关闭书写器
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
        return oldPath;
    }*/
}
