package com.myutils.poi;

import com.sun.istack.internal.logging.Logger;
import org.apache.poi.xwpf.usermodel.*;

import java.awt.*;
import java.io.*;

/**
 * @description 创建docx文件演示
 * @author: hxx
 * @create: 2021-06-14 18:45
 **/
public class CreateDocxDemo {
    private static Logger log= Logger.getLogger(CreateDocxDemo.class);

    public static void main(String[] args){
        String path = "E:\\tmp\\word\\docTest\\template.docx";
        try {
            createNewParagraph(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建空白word文档
     * @param outPath
     * @throws IOException
     */
    public static void createNewWord(String outPath) throws IOException {
        //空白的docx文档
        XWPFDocument xwpfDocument = new XWPFDocument();
        FileOutputStream fos =  new FileOutputStream(outPath);
        xwpfDocument.write(fos);
        fos.close();
        System.out.println("word生成成功...");

//        Desktop.getDesktop().open(new File(outPath));
        Runtime.getRuntime().exec("cmd /c " + outPath + " /f");
    }

    /**
     * 创建带有段落的word文档
     * @param outPath
     * @throws IOException
     */
    public static void createNewParagraph(String outPath) throws IOException {
        //空白的docx文档
        XWPFDocument xwpfDocument = new XWPFDocument();
        //段落
        XWPFParagraph paragraph = xwpfDocument.createParagraph();
        //边框
//        paragraph.setBorderBottom(Borders.BASIC_BLACK_DASHES);
        //文本
        XWPFRun run = paragraph.createRun();
        run.setText("云开远见汉阳城，犹是孤帆一日程。");
        run.setText("估客昼眠知浪静，舟人夜语觉潮生。");
        run.setText("三湘愁鬓逢秋色，万里归心对月明。");
        run.setText("旧业已随征战尽，更堪江上鼓鼙声。");

        FileOutputStream fos =  new FileOutputStream(outPath);
        xwpfDocument.write(fos);
        fos.close();
        System.out.println("word生成成功...");

        Desktop.getDesktop().open(new File(outPath));
    }

    /**
     * 创建带有表格的docx文件
     * @param outPath
     * @throws IOException
     */
    public static void createNewTable(String outPath) throws IOException {
        XWPFDocument xwpfDocument = new XWPFDocument();
        //表格
        XWPFTable table = xwpfDocument.createTable();

        //第一行
        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText("第一行第一列");
        tableRowOne.addNewTableCell().setText("第一行第二列");
        tableRowOne.addNewTableCell().setText("第一行第三列");

        //第二行
        XWPFTableRow tableRowTwo = table.createRow();
        tableRowTwo.getCell(0).setText("第二行第一列");
        tableRowTwo.getCell(1).setText("第二行第二列");
        tableRowTwo.getCell(2).setText("第二行第三列");

        //第三行
        XWPFTableRow tableRowThree = table.createRow();
        tableRowThree.getCell(0).setText("第三行第一列");
        tableRowThree.getCell(1).setText("第三行第二列");
        tableRowThree.getCell(2).setText("第三行第三列");

        FileOutputStream fos = new FileOutputStream(outPath);
        xwpfDocument.write(fos);
        fos.close();
        System.out.println("word生成成功...");

        Desktop.getDesktop().open(new File(outPath));
    }

    /**
     * 设置段落样式
     * @param outPath
     * @throws IOException
     */
    public static void fontStyle(String outPath) throws IOException {
        XWPFDocument xwpfDocument = new XWPFDocument();
        XWPFParagraph paragraph = xwpfDocument.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.LEFT);//段落左对齐

        XWPFRun paragraphRunOne = paragraph.createRun();
        paragraphRunOne.setBold(true);//加粗
        paragraphRunOne.setItalic(true);//斜体
        paragraphRunOne.setText("Font Style One");
        paragraphRunOne.addBreak();//软回车

        XWPFRun paragraphRunTwo = paragraph.createRun();
        paragraphRunTwo.setText("Font Style Two");
        paragraphRunTwo.setTextPosition(100);

        XWPFRun paragraphRunThree = paragraph.createRun();
        paragraphRunThree.setStrike(true);//删除线
        paragraphRunThree.setFontSize(20);
        paragraphRunThree.setSubscript(VerticalAlign.SUBSCRIPT);
        paragraphRunThree.setText("Font Style Three ");

        FileOutputStream fos = new FileOutputStream(outPath);
        xwpfDocument.write(fos);
        fos.close();
        System.out.println("word生成成功...");

        Desktop.getDesktop().open(new File(outPath));
    }
}
