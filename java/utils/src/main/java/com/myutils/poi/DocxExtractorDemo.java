package com.myutils.poi;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @description 提取doxc文本演示
 * @author: hxx
 * @create: 2021-07-04 18:42
 **/
public class DocxExtractorDemo {

    public static void main(String[] args) {
        String filePath = "E:\\tmp\\word\\docTest\\template.docx";
        try {
            extractorText(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void extractorText(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XWPFDocument docx = new XWPFDocument(fis);
        XWPFWordExtractor extractor = new XWPFWordExtractor(docx);
        System.out.println( extractor.getText());
        fis.close();
    }
}
