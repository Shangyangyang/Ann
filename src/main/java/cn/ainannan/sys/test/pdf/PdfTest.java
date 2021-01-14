package cn.ainannan.sys.test.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;

public class PdfTest {
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        document.save("D:\\data\\");
        document.close();
    }
}
