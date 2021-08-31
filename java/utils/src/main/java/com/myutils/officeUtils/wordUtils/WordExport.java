package com.myutils.officeUtils.wordUtils;

import com.myutils.string.StringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class WordExport {

    private XWPFDocument document;
    private File file;
    private FileOutputStream out;

    public WordExport(String filePath, String fileName) {

        fileName = fileName.replaceAll("/", "");
        fileName = fileName.replaceAll("\\\\", "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        filePath += format + File.separator;
        File file = new File(filePath + fileName);
        document = new XWPFDocument();    /*document对象可以只创建一次*/
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @param title    pdf的标题
     * @param imgUrl   图片base64码
     * @param filePath 要保存word的路径  例:d:/
     * @param fileName word的文件名   例:1.pdf
     * @param headList 表格头部的list数据
     * @param dataList 表格下方的内容数据   按顺序填入集合中即可
     * @param log
     */
    public void makeWord(List<String> title, List<String> imgUrl, String filePath, String fileName,
                         List<List<String>> headList, List<String> dataList, String note, File file, Logger log) {

        fileName = fileName.replaceAll("/", "");
        fileName = fileName.replaceAll("\\\\", "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        filePath += format + File.separator;
        String imgName = filePath + UUID.randomUUID().toString() + ".png";
        File f = new File(filePath);
        if (!f.exists()) {
            f.mkdirs();
        }
        OutputStream imgOut = null;
        try {
            if (file.exists()) {
                //添加标题
                XWPFParagraph titleParagraph2 = document.createParagraph();
                //设置段落居中
                titleParagraph2.setAlignment(ParagraphAlignment.CENTER);
                XWPFRun titleParagraphRun2 = titleParagraph2.createRun();
                titleParagraphRun2.setText("  ");
                titleParagraphRun2.setFontSize(50);
            }

            /*对于每个new的OutputStream对象，只能被document.write()执行一次保存操作*/
            /*所以每次写入新的段落都要新建OutputStream，否则执行第二次会报错*/
            out = new FileOutputStream(file);

            for (int i = 0; i < title.size(); i++) {
                if (i == 0) {
                    if (StringUtils.isNotBlank(title.get(i))) {
                        //添加标题
                        XWPFParagraph titleParagraph = document.createParagraph();
                        //设置段落居中
                        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
                        XWPFRun titleParagraphRun = titleParagraph.createRun();
                        titleParagraphRun.setText(title.get(i));
                        titleParagraphRun.setColor("000000");
                        titleParagraphRun.setFontSize(20);
                    }
                    if (StringUtils.isNotBlank(note)) {
                        //添加标题
                        XWPFParagraph titleParagraph = document.createParagraph();
                        XWPFRun titleParagraphRun = titleParagraph.createRun();
                        titleParagraphRun.setText(note);
                        titleParagraphRun.setFontSize(10);
                    }
                } else {
                    //二级标题
                    //添加标题
                    XWPFParagraph titleParagraph = document.createParagraph();
                    //设置段落居中
                    XWPFRun titleParagraphRun = titleParagraph.createRun();
                    titleParagraphRun.setText(title.get(i));
                    titleParagraphRun.setColor("000000");
                    titleParagraphRun.setFontSize(15);
                }
            }

            if (imgUrl != null && imgUrl.size() > 0) {
                //基本信息表格
                XWPFTable imgTable = document.createTable((int) Math.ceil(Double.parseDouble(String.valueOf(imgUrl.size())) / 2), imgUrl.size() > 1 ? 2 : 1);
                imgTable.getCTTbl().getTblPr().unsetTblBorders();

                int width = imgUrl.size() > 1 ? 190 : 505;
                int height = imgUrl.size() > 1 ? 75 : 205;
                XWPFParagraph paragraph = document.createParagraph();
                int row = 0;
                int col = 0;

                for (int i = 0; i < imgUrl.size(); i++) {
                    if (StringUtils.isNotBlank(imgUrl.get(i))) {
                        String img = imgUrl.get(i).replaceAll(" ", "+");
                        String[] url = img.split("base64,");
                        String u = url[1];
                        // Base64解码
                        byte[] b = new BASE64Decoder().decodeBuffer(u);
                        // 生成图片
                        File file1 = new File(imgName);
                        imgOut = new FileOutputStream(file1);
                        imgOut.write(b);
                        imgOut.flush();
                        imgOut.close();

                        //插入图片

                        XWPFRun run1 = paragraph.createRun();

                        FileInputStream fileInputStream = new FileInputStream(file1);
                        run1.addPicture(fileInputStream, XWPFDocument.PICTURE_TYPE_PNG, imgName, Units.toEMU(width), Units.toEMU(height));
                        //imgTable.getRow(row).getCell(col).addParagraph(paragraph);

                        fileInputStream.close();

                        col++;
                        if (col % 2 == 0) {
                            row++;
                            col = 0;
                        }
                        file1.delete();
                    }
                }

                if (headList != null) {
                    makeData(headList, dataList);
                }

                FileOutputStream out = new FileOutputStream(new File(filePath + fileName));
                document.write(out);
                out.close();
            }
        } catch (Exception e) {
           /* log.error(ConstantParam.ERROR_SYSTEM, e);*/
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                   /* log.error(ConstantParam.ERROR_SYSTEM, e);*/
                }
            }
            if (imgOut != null) {
                try {
                    imgOut.close();
                } catch (IOException e) {
                  /*  log.error(ConstantParam.ERROR_SYSTEM, e);*/
                }
            }
            if (StringUtils.isNotBlank(imgName)) {
                File file1 = new File(imgName);
                if (file1.exists()) {
                    file1.delete();
                }
            }
        }
    }

    /**
     * 合并单元格方法
     *
     * @param list     表格头部数据 list中相连下标位置内容如果相同自动合并 上下位置内容相同自动合并
     * @param dataList 表格内容数据   按顺序填入集合中即可
     * @return
     */
    private void makeData(List<List<String>> list, List<String> dataList) throws Exception {
        int length = list.get(0).size();
        List<List<Map<String, String>>> aa = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            List<String> strings = list.get(i);
            int colNum = 1;
            List<Map<String, String>> bb = new ArrayList<>();
            for (int j = 0; j < strings.size(); j++) {
                if (j + 1 < strings.size()) {
                    if (strings.get(j).equals(strings.get(j + 1))) {
                        colNum++;
                    } else {
                        Map<String, String> map = new HashMap<>();
                        map.put("value", strings.get(j));
                        map.put("colspan", colNum + "");

                        bb.add(map);

                        for (int a = 1; a < colNum; a++) {
                            bb.add(null);
                        }
                        colNum = 1;
                    }
                } else {
                    Map<String, String> map = new HashMap<>();
                    map.put("value", strings.get(j));
                    map.put("colspan", colNum + "");
                    bb.add(map);
                    for (int a = 1; a < colNum; a++) {
                        bb.add(null);
                    }
                    colNum = 1;
                }
            }
            aa.add(bb);
        }

        for (int i = 0; i < length; i++) {

            int rowSpan = 1;

            for (int j = 0; j < aa.size(); j++) {

                if (aa.get(j).get(i) == null) {
                    continue;
                }

                if (j + 1 < aa.size()) {

                    if (aa.get(j + 1).get(i) != null && aa.get(j).get(i).get("value").equals(aa.get(j + 1).get(i).get("value"))
                            && aa.get(j).get(i).get("colspan").equals(aa.get(j + 1).get(i).get("colspan"))
                    ) {
                        rowSpan++;
                    } else {
                        aa.get(j - rowSpan + 1).get(i).put("rowSpan", rowSpan + "");

                        for (int a = 1; a < rowSpan; a++) {
                            aa.get(j - rowSpan + 1 + a).set(i, null);
                        }
                        rowSpan = 1;
                    }
                } else {
                    aa.get(j - rowSpan + 1).get(i).put("rowSpan", rowSpan + "");

                    for (int a = 1; a < rowSpan; a++) {
                        aa.get(j - rowSpan + 1 + a).set(i, null);
                    }
                    rowSpan = 1;
                }
            }
        }


        List<List<Map<String, Boolean>>> mergeList = new ArrayList<>();
        for (int i = 0; i < aa.size(); i++) {
            List<Map<String, Boolean>> list1 = new ArrayList<>();
            for (int j = 0; j < aa.get(0).size(); j++) {

                Map<String, String> map1 = aa.get(i).get(j);

                if (map1 != null && map1.size() >= 3) {
                    int rowSpan = Integer.parseInt(map1.get("rowSpan"));
                    int colspan = Integer.parseInt(map1.get("colspan"));

                    if (colspan > 1) {

                        aa.get(i).get(j).put("isColStart", "true");

                        for (int a = 1; a < colspan; a++) {
                            Map<String, String> map = new HashMap<>();
                            map.put("isColContinue", "true");
                            aa.get(i).set(j + a, map);
                        }
                    }
                    if (rowSpan > 1) {

                        aa.get(i).get(j).put("isRowStart", "true");

                        if (colspan > 1) {
                            for (int a = 1; a < rowSpan; a++) {
                                Map<String, String> map = new HashMap<>();
                                map.put("isRowContinue", "true");
                                aa.get(i + a).set(j, map);

                                for (int b = 1; b < colspan; b++) {
                                    Map<String, String> map2 = new HashMap<>();
                                    map2.put("isColContinue", "true");
                                    map2.put("isRowContinue", "true");
                                    aa.get(i + a).set(j + b, map2);
                                }
                            }
                        } else {
                            for (int a = 1; a < rowSpan; a++) {
                                Map<String, String> map = new HashMap<>();
                                map.put("isRowContinue", "true");
                                aa.get(i + a).set(j, map);
                            }
                        }
                    }

                }
            }
            mergeList.add(list1);
        }

        //基本信息表格
        XWPFTable infoTable = document.createTable(dataList == null ? list.size() : list.size() + dataList.size() / list.get(0).size(), list.get(0).size());

        for (int i = 0; i < list.size(); i++) {
            //表格第一行
            XWPFTableRow infoTableRowOne = infoTable.getRow(i);
            for (int j = 0; j < list.get(0).size(); j++) {

                Map<String, String> map = aa.get(i).get(j);

                if (map.get("isColStart") != null) {
                    infoTableRowOne.getCell(j).getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);//这是起点
                }
                if (map.get("isRowStart") != null) {
                    infoTableRowOne.getCell(j).getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);//这是起点
                }
                if (map.get("isColContinue") != null) {
                    infoTableRowOne.getCell(j).getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);//这是起点
                }
                if (map.get("isRowContinue") != null) {
                    infoTableRowOne.getCell(j).getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);//这是起点
                }
                if (map.get("value") != null) {
                    infoTableRowOne.getCell(j).setText(map.get("value"));
                }

                infoTableRowOne.getCell(j).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);  //设置水平居中

                infoTableRowOne.getCell(j).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);  //设置垂直居中
            }
        }
        int row = list.size() - 1;
        int col = 0;
        for (int i = 0; i < dataList.size(); i++) {
            if (i % list.get(0).size() == 0) {
                row++;
                col = 0;
            }
            infoTable.getRow(row).getCell(col).setText(dataList.get(i));
            col++;
        }
    }
}