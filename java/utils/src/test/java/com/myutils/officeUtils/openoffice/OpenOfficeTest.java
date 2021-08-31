package com.myutils.officeUtils.openoffice;

import org.jodconverter.DocumentConverter;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.jodconverter.office.OfficeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-16 11:08
 **/

@SpringBootTest
public class OpenOfficeTest {
    @Autowired
    private DocumentConverter converter;

    @Test
    public void wordToPdf1(){
        try {
            converter.convert(new File("E:\\tmp\\word\\企业门户操作手册.docx")).
                    to(new File("E:\\tmp\\word\\企业门户操作手册.pdf")).execute();
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void wordToPdf2() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("E:\\tmp\\word\\企业门户操作手册.docx");
        FileOutputStream fos = new FileOutputStream("E:\\tmp\\word\\企业门户操作手册.pdf");
        try {
            converter.convert(fis).as(DefaultDocumentFormatRegistry.DOCX).to(fos).as(DefaultDocumentFormatRegistry.PDF).execute();
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }
}
