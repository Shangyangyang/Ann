package cn.ainannan.sys.test.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.IOException;

public class Watermark extends PdfPageEventHelper {
    Font FONT = new Font(Font.FontFamily.HELVETICA, 30, Font.BOLD, new GrayColor(0.95f));
    private String waterCont;//水印内容

    public Watermark() {

    }

    public Watermark(String waterCont) {
        this.waterCont = waterCont;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ColumnText.showTextAligned(writer.getDirectContentUnder(),
                        Element.ALIGN_CENTER,
                        new Phrase(this.waterCont == null ? "HELLO WORLD" : this.waterCont, getFont()),
                        (50.5f + i * 350),
                        (40.0f + j * 150),
                        writer.getPageNumber() % 2 == 1 ? 45 : -45);
            }
        }
    }

    public BaseFont getBaseFont() {
        return getBaseFont("方正启体简体");
    }

    public BaseFont getBaseFont(String fontName) {
        String path = "C:/WINDOWS/Fonts/"+ fontName +".ttf";//windows里的字体资源路径
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont(path, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bf;
    }

    public Font getFont() {
        BaseFont bf = getBaseFont();

        Font font = new Font(bf, 20f,  Font.BOLD, new GrayColor(0.95f));

        return font;
    }
}
