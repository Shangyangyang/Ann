package cn.ainannan.sys.test.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileOutputStream;
import java.io.IOException;

public class MyPdfTest {


    public static void main(String[] args) throws IOException, DocumentException {
        formalTable(false);
    }


    public static void formalTable(boolean isBorder) throws IOException, DocumentException {
        // 创建文档
        Document document = new Document(PageSize.A4);

        // 存储路径
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/formalTable.pdf"));

        // 水印
        writer.setPageEvent(new Watermark("济南市残联信息化平台（智慧残联）"));
        // 页眉/页脚
        writer.setPageEvent(new MyHeaderFooter());

        // 打开文档
        document.open();

        // 总表1-标头
        PdfPTable totalTable = new PdfPTable(3);
        totalTable.setSpacingBefore(10f);// 设置表格上面空白宽度
        totalTable.setWidthPercentage(100);//设置表格宽度为%100

        if (!isBorder) totalTable.getDefaultCell().setBorder(0);//设置表格默认为无边框

        float[] columnWidths = {0.3f, 0.9f, 0.3f};
        totalTable.setWidths(columnWidths);

        PdfPCell cell = null;

        // 加红色
        FontSelector selector = new FontSelector();
        //非汉字字体颜色
        // bianhao.setColor(BaseColor.RED);
        selector.addFont(bianhao);

        Phrase ph = selector.process("202101250002");
        Paragraph p = new Paragraph(ph);

        p.setAlignment(1);

        // 编号外框
        PdfPTable bianhaoTable = new PdfPTable(1);
        if (!isBorder) bianhaoTable.getDefaultCell().setBorder(0);
        cell = new PdfPCell(p);
        if (!isBorder) cell.setBorder(Rectangle.NO_BORDER);
        bianhaoTable.addCell(cell);


        // 总标题外框
        PdfPTable totalTitleTable = new PdfPTable(1);
        if (!isBorder) totalTitleTable.getDefaultCell().setBorder(0);

        Paragraph totalTitle = new Paragraph("残疾人档案信息", totalTitleFont);
        cell = new PdfPCell(totalTitle);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        if (!isBorder) cell.setBorder(Rectangle.NO_BORDER);
        totalTitleTable.addCell(cell);

        // 右上角二维码
        PdfPTable erweimaTatle = new PdfPTable(1);
        if (!isBorder) erweimaTatle.getDefaultCell().setBorder(0);

        Image img = Image.getInstance("D://二维码图片_1月25日10时16分04秒.png");

        img.setAlignment(Image.MIDDLE);
        img.scalePercent(60f);

        cell = new PdfPCell(img, false);
        if (!isBorder) cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        erweimaTatle.addCell(cell);
        cell = new PdfPCell(new Paragraph("查询二维码", bianhao));
        if (!isBorder) cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        erweimaTatle.addCell(cell);

        // 总表添加子表
        totalTable.addCell(bianhaoTable);
        totalTable.addCell(totalTitleTable);
        totalTable.addCell(erweimaTatle);

        // 总表2-残疾人信息
        PdfPTable totalTable2 = new PdfPTable(2);
        totalTable2.setSpacingBefore(10f);// 设置表格上面空白宽度
        totalTable2.setWidthPercentage(100);//设置表格宽度为%100
        if (!isBorder) totalTable2.getDefaultCell().setBorder(0);//设置表格默认为无边框

        cell = new PdfPCell(new Paragraph("基本信息", subTitleFont));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        if (!isBorder) cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(2);

        totalTable2.addCell(cell);

        String[] strs = new String[]{"姓名： 张三", "身份证号： 370102199911223344", "残疾类别： 肢体", "残疾等级： 四级"};

        for (String str : strs){
            cell = new PdfPCell(new Paragraph(str, textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setPaddingTop(10f);
            totalTable2.addCell(cell);
        }


        String[] bbnss = new String[]{
                "创业项目", "川道村卫生室", "固定资产", "30万元",
                "安置带动人数", "2人", "年收入", "5万元",
                "简要事迹： 1999年10月份参加乡村医生工作至今20年，热情接待，诚实治疗，服务于周边的老百姓，给他们解决了痛苦。为残疾朋友实行“减、缓、免”的治疗办法，减轻了他们的经济负担。 2018年1月份，被川道村民选为村主任。自任职以来，捐款3000元组织辛宅自然村的老百姓拓宽了进村的道路，为川道村四个自然村协调资金按装了路灯，方便了老百姓的出行问题。 2019年范连恩夫妇因外伤住院，花费巨大，对家庭造成巨大的经济负担，家庭被拖进贫困的边缘，组织柳埠的积极分子为川道北峪村的范连恩夫妇捐款2000余元，组织川道村的村民进行捐款活动筹集资金8000余元。 2019年积极协调历城区国税局的资金进行范家庄和辛宅村道路的措宽工程和范家庄与唐家沟村的道路拓宽工程，实现了村村通户户通，极大的方便了老百姓的出行。 2020年又为川道村的辛宅、北峪、川道三个自然村修了三座生产桥共计花费35万余元，极大的方便了老百姓的秋收问题。",
                "县级残联意见", "同意",
                "市级残联意见", "同意", "申请日期", "2021-01-25"
        };


        // 总表3-标兵能手
        Paragraph bbnsTitle = new Paragraph("标兵能手", subTitleFont);



        PdfPTable bbtnTable = new PdfPTable(4);
        bbtnTable.setSpacingBefore(10f);// 设置表格上面空白宽度
        bbtnTable.setWidthPercentage(100);//设置表格宽度为%100
        if (!isBorder) bbtnTable.getDefaultCell().setBorder(0);//设置表格默认为无边框

        cell = new PdfPCell(new Paragraph("2020年度致富能手申报", subTitleFont2));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        if (!isBorder) cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(4);

        bbtnTable.addCell(cell);

        for (String str : bbnss){
            cell = new PdfPCell(new Paragraph(str, textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            // if (!isBorder) cell.setBorder(Rectangle.NO_BORDER);
            cell.setPaddingTop(10f);
            if(str.indexOf("简要事迹：") > -1) cell.setColspan(4);
            if(str.indexOf("2021-01-25：") > -1) cell.setColspan(3);
            bbtnTable.addCell(cell);
        }

        PdfPTable bbtnTable2 = new PdfPTable(4);
        bbtnTable2.setSpacingBefore(10f);// 设置表格上面空白宽度
        bbtnTable2.setWidthPercentage(100);//设置表格宽度为%100
        if (!isBorder) bbtnTable2.getDefaultCell().setBorder(0);//设置表格默认为无边框


        cell = new PdfPCell(new Paragraph("2021年度致富能手申报", subTitleFont2));
        cell.setBackgroundColor(new BaseColor(200, 200, 200));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        if (!isBorder) cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(4);

        bbtnTable2.addCell(cell);

        for (String str : bbnss){
            cell = new PdfPCell(new Paragraph(str, textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            // if (!isBorder) cell.setBorder(Rectangle.NO_BORDER);
            cell.setPaddingTop(10f);
            if(str.indexOf("简要事迹：") > -1) cell.setColspan(4);
            if(str.indexOf("2021-01-25：") > -1) cell.setColspan(3);
            bbtnTable2.addCell(cell);
        }


        // 底部直线
        Paragraph p1 = new Paragraph();
        p1.add(new Chunk(new LineSeparator()));

        // 说明
        Paragraph shuomingText = new Paragraph("说明： 本档案数据来自济南市残联信息化平台（智慧残联），请妥善保管。", subTextFont);



        // 文档添加总表
        document.add(totalTable);
        document.add(totalTable2);
        document.add(bbnsTitle);
        document.add(bbtnTable);
        document.add(bbtnTable2);
        document.add(p1);
        document.add(shuomingText);
        // 关闭文档，生成。
        document.close();
    }

    public static BaseFont BASE_SONGTI = null;
    public static BaseFont BASE_FANGZHENG_SONGTI = new Watermark().getBaseFont("方正大标宋简体");
    public static BaseFont BASE_FANGZHENG_ZHUNHEI = new Watermark().getBaseFont("方正兰亭准黑_GBK");
    // 编号
    public static Font bianhao = new Font(BASE_FANGZHENG_ZHUNHEI, 12);
    // 总标题
    public static Font totalTitleFont = new Font(BASE_FANGZHENG_SONGTI, 26);
    public static Font subTitleFont = new Font(BASE_FANGZHENG_SONGTI, 18);
    public static Font subTitleFont2 = new Font(BASE_FANGZHENG_SONGTI, 14);
    public static Font textFont = new Font(BASE_FANGZHENG_SONGTI, 11);
    public static Font subTextFont = null;

    static {
        try {
            BASE_SONGTI = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            subTextFont = new Font(BASE_SONGTI, 11);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
