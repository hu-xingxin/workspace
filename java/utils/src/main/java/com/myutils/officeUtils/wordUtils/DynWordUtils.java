package com.myutils.officeUtils.wordUtils;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.poi.word.Word07Writer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

/**
 * Create by IntelliJ Idea 2018.2
 *
 * @author: qyp
 * Date: 2019-10-25 14:48
 */
public class DynWordUtils {

    private final Logger logger = LoggerFactory.getLogger(DynWordUtils.class);

    private Word07Writer writer = null;
    /**
     * 被list替换的段落 被替换的都是oldParagraph
     */
    private XWPFParagraph oldParagraph;

    /**
     * 参数
     */
    private Map<String, Object> paramMap;

    /**
     * 当前元素的位置
     */
    int n = 0;

    /**
     * 判断当前是否是遍历的表格
     */
    boolean isTable = false;

    /**
     * 模板对象
     */
    XWPFDocument templateDoc;

    /**
     * 默认字体的大小
     */
    final int DEFAULT_FONT_SIZE = 10;

    /**
     * 入口
     *
     * @param paramMap     模板中使用的参数
     * @param templatePath 模板全路径
     * @param outPath      生成的文件存放的本地全路径
     */
    public void process(Map<String, Object> paramMap, String templatePath, String outPath) {
        DynWordUtils dynWordUtils = new DynWordUtils();
        dynWordUtils.setParamMap(paramMap);
        dynWordUtils.createWord(templatePath, outPath);
    }


    /**
     * 入口 合并单元格
     *
     * @param paramMap     模板中使用的参数
     * @param templatePaht 模板全路径
     * @param outPath      生成的文件存放的本地全路径
     */
    public void process(Map<String, Object> paramMap, String templatePaht, String outPath,Map tableMap) {
        DynWordUtils dynWordUtils = new DynWordUtils();
        dynWordUtils.setParamMap(paramMap);
        dynWordUtils.createWord(templatePaht, outPath,tableMap);
    }

    /**
     * 生成动态的word 不合并单元格
     *
     * @param templatePath
     * @param outPath
     */
    public void createWord(String templatePath, String outPath) {
        File inFile = new File(templatePath);
        writer = new Word07Writer(inFile);
        templateDoc = writer.getDoc();

        try (FileOutputStream outStream = new FileOutputStream(outPath)) {
            parseTemplateWord();
            templateDoc.write(outStream);
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();

            String className = stackTrace[0].getClassName();
            String methodName = stackTrace[0].getMethodName();
            String fileName = stackTrace[0].getFileName();
            int lineNumber = stackTrace[0].getLineNumber();

            logger.error("错误：第:{}行, 类名:{}, 方法名:{}, 字段名:{}", lineNumber, className, methodName, fileName);
            throw new RuntimeException(e.getCause().getMessage());
        }
    }



    /**
     * 生成动态的word 合并单元格
     *
     * @param templatePath
     * @param outPath
     */
    public void createWord(String templatePath, String outPath,Map tableMap) {
        File inFile = new File(templatePath);
        writer = new Word07Writer(inFile);
        templateDoc = writer.getDoc();

        try (FileOutputStream outStream = new FileOutputStream(outPath)) {
            parseTemplateWord();
            if(tableMap!=null){
                mergeCell(templateDoc,tableMap);
            }else {
                mergeCell(templateDoc);
            }

            templateDoc.write(outStream);
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();

            String className = stackTrace[0].getClassName();
            String methodName = stackTrace[0].getMethodName();
            String fileName = stackTrace[0].getFileName();
            int lineNumber = stackTrace[0].getLineNumber();

            logger.error("错误：第:{}行, 类名:{}, 方法名:{}, 字段名:{}", lineNumber, className, methodName, fileName);
            throw new RuntimeException(e.getCause().getMessage());
        }
    }


    /**
     * 合并所有表格的第一列的重复数据
     * @param templateDoc
     */
    public void mergeCell(XWPFDocument templateDoc){
        List<XWPFTable> XWPFtables = templateDoc.getTables();
        for (XWPFTable table : XWPFtables) {

            //用于记录合并单元格时计算行的下标
            int index=0;
            List indexList =  new ArrayList<Integer>();
            for(int row =0 ;row < table.getRows().size()-1; row++) {//每一行
                XWPFTableCell cell0 = table.getRow(row).getCell(0);
                XWPFTableCell cell1 = table.getRow(row + 1).getCell(0);
                if(cell0.getText().equals(cell1.getText())) {
                    index++;
                    indexList.add(index);
                }else {
                    index=0;
                    indexList.add(index);
                }
            }

            for(int row =0 ;row < table.getRows().size()-1; row++) {//每一行
                XWPFTableCell cell0 = table.getRow(row).getCell(0);
                XWPFTableCell cell1 = table.getRow(row + 1).getCell(0);
                if(cell0.getText().equals(cell1.getText())) {
                    mergeCellsVertically(table,0,row-((int)indexList.get(row)-1) ,row+1);
                }
            }


        }
    }


    /**
     * 自定义合并单元格
     * @param templateDoc
     * @param tableMap tableIndex 表格的下标  startCol开始合并的起始行  cellColList 需要合并列的下标
     */
    public void mergeCell(XWPFDocument templateDoc,Map tableMap){
        int[] tableIndex = (int[]) tableMap.get("tableIndex");
        int[] startCol = (int[])tableMap.get("startCol");
        List cellColList = (List) tableMap.get("cellColList");
        List<XWPFTable> XWPFtables = templateDoc.getTables();
        for(int i=0;i<tableIndex.length;i++){
            XWPFTable table = XWPFtables.get(tableIndex[i]-1);
            for(int colIndex:(int[]) cellColList.get(i)){
                //用于记录合并单元格时计算起始行的下标
                int index=0;
                List indexList =  new ArrayList<Integer>();
                for(int row =startCol[i]-1 ;row < table.getRows().size()-1; row++) {//每一行
                    XWPFTableCell cell0 = table.getRow(row).getCell(colIndex-1);
                    XWPFTableCell cell1 = table.getRow(row + 1).getCell(colIndex-1);
                    if(cell0.getText().equals(cell1.getText())) {
                        index++;
                        indexList.add(index);
                    }else {
                        index=0;
                        indexList.add(index);
                    }
                }

                for(int row =startCol[i]-1 ;row < table.getRows().size()-1; row++) {//每一行
                    XWPFTableCell cell0 = table.getRow(row).getCell(colIndex-1);
                    XWPFTableCell cell1 = table.getRow(row + 1).getCell(colIndex-1);
                    if(cell0.getText().equals(cell1.getText())) {
                        mergeCellsVertically(table,colIndex-1,row-((int)indexList.get(row-(startCol[i]-1))-1) ,row+1);
                    }
                }
            }
        }
    }

    /**
     * 合并重复的行
     * @param table
     * @param col
     * @param fromRow
     * @param toRow
     */
    public void mergeCellsVertically(XWPFTable table, int col, int fromRow, int toRow) {
        for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
            XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
            if ( rowIndex == fromRow ) {
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
            } else {
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    /**
     * 解析word模板
     */
    public void parseTemplateWord() throws Exception {

        List<IBodyElement> elements = templateDoc.getBodyElements();

        for (; n < elements.size(); n++) {
            IBodyElement element = elements.get(n);
            // 普通段落
            if (element instanceof XWPFParagraph) {

                XWPFParagraph paragraph = (XWPFParagraph) element;
                oldParagraph = paragraph;
                if (paragraph.getParagraphText().isEmpty()) {
                    continue;
                }

                delParagraph(paragraph);

            } else if (element instanceof XWPFTable) {
                // 表格
                isTable = true;
                XWPFTable table = (XWPFTable) element;

                delTable(table, paramMap);
                isTable = false;
            }
        }

    }

    /**
     * 处理段落
     */
    private void delParagraph(XWPFParagraph paragraph) throws Exception {
        List<XWPFRun> runs = oldParagraph.getRuns();
        StringBuilder sb = new StringBuilder();
        for (XWPFRun run : runs) {
            String text = run.getText(0);
            if (text == null) {
                continue;
            }
            sb.append(text);
            run.setText("", 0);
        }
        Placeholder(paragraph, runs, sb);
    }


    /**
     * 匹配传入信息集合与模板
     *
     * @param placeholder 模板需要替换的区域()
     * @param paramMap    传入信息集合
     * @return 模板需要替换区域信息集合对应值
     */
    public void changeValue(XWPFRun currRun, String placeholder, Map<String, Object> paramMap,XWPFParagraph  paragraph) throws Exception {
        String placeholderValue = placeholder;
        if (paramMap == null || paramMap.isEmpty()) {
            return;
        }

        Set<Map.Entry<String, Object>> textSets = paramMap.entrySet();
        for (Map.Entry<String, Object> textSet : textSets) {
            //匹配模板与替换值 格式${key}
            String mapKey = textSet.getKey();
            String docKey = PoiWordUtils.getDocKey(mapKey);

            if (placeholderValue.indexOf(docKey) != -1) {
                Object obj = textSet.getValue();
                // 需要添加一个list
                if (obj instanceof List) {
                    placeholderValue = delDynList(placeholder, (List) obj);
                } else {
                    placeholderValue = placeholderValue.replaceAll(
                            PoiWordUtils.getPlaceholderReg(mapKey)
                            , String.valueOf(obj));
                }
            }
        }

        //单元格内设置换行
        if ((placeholderValue).indexOf("/br") > 0) {
            String[] text = placeholderValue.split("/br");
            for (int f = 0; f < text.length; f++) {
                currRun.setText(text[f]);
                currRun.addCarriageReturn();
            }
        } else {
            currRun.setText(placeholderValue, 0);
        }
    }

    /**
     * 处理的动态的段落（参数为list）
     *
     * @param placeholder 段落占位符
     * @param obj
     * @return
     */
    private String delDynList(String placeholder, List obj) {
        String placeholderValue = placeholder;
        List dataList = obj;
        Collections.reverse(dataList);
        for (int i = 0, size = dataList.size(); i < size; i++) {
            Object text = dataList.get(i);
            // 占位符的那行, 不用重新创建新的行
            if (i == 0) {
                placeholderValue = String.valueOf(text);
            } else {
                XWPFParagraph paragraph = createParagraph(String.valueOf(text));
                if (paragraph != null) {
                    oldParagraph = paragraph;
                }
                // 增加段落后doc文档会的element的size会随着增加（在当前行的上面添加），回退并解析新增的行（因为可能新增的带有占位符，这里为了支持图片和表格）
                if (!isTable) {
                    n--;
                }
            }
        }
        return placeholderValue;
    }

    /**
     * 创建段落 <p></p>
     *
     * @param texts
     */
    public XWPFParagraph createParagraph(String... texts) {

        // 使用游标创建一个新行
        XmlCursor cursor = oldParagraph.getCTP().newCursor();
        XWPFParagraph newPar = templateDoc.insertNewParagraph(cursor);
        // 设置段落样式
        newPar.getCTP().setPPr(oldParagraph.getCTP().getPPr());

        copyParagraph(oldParagraph, newPar, texts);

        return newPar;
    }

    /**
     * 处理表格（遍历）
     *
     * @param table    表格
     * @param paramMap 需要替换的信息集合
     */
    public void delTable(XWPFTable table, Map<String, Object> paramMap) throws Exception {
        List<XWPFTableRow> rows = table.getRows();
        int index = 0;
        for (XWPFTableRow row : rows) {
            // 如果是动态添加行 直接处理后返回
            if (delAndJudgeRow(table, paramMap, row, index)) {
                return;
            }
            index++;
        }
    }

    /**
     * 判断并且是否是动态行，并且处理表格占位符
     *
     * @param table    表格对象
     * @param paramMap 参数map
     * @param row      当前行
     * @return
     * @throws Exception
     */
    private boolean delAndJudgeRow(XWPFTable table, Map<String, Object> paramMap, XWPFTableRow row, int index) throws Exception {
        // 当前行是动态行标志
        if (PoiWordUtils.isAddRow(row)) {
            List<XWPFTableRow> xwpfTableRows = addAndGetRows(table, row, paramMap, index);

            // 回溯添加的行，这里是试图处理动态添加的图片
            for (XWPFTableRow tableRow : xwpfTableRows) {
                delAndJudgeRow(table, paramMap, tableRow, index);
            }
            return true;
        }
        // 当前行非动态行标签
        List<XWPFTableCell> cells = row.getTableCells();
        for (XWPFTableCell cell : cells) {
            //判断单元格是否需要替换
            if (PoiWordUtils.checkText(cell.getText())) {
                List<XWPFParagraph> paragraphs = cell.getParagraphs();
                for (XWPFParagraph paragraph : paragraphs) {
                    List<XWPFRun> runs = paragraph.getRuns();
                    StringBuilder sb = new StringBuilder();
                    for (XWPFRun run : runs) {
                        sb.append(run.toString());
                        run.setText("", 0);
                    }
                    Placeholder(paragraph, runs, sb);
                }
            }
        }
        return false;
    }

    /**
     * 处理占位符
     *
     * @param runs 当前段的runs
     * @param sb   当前段的内容
     * @throws Exception
     */
    private void Placeholder(XWPFParagraph currentPar, List<XWPFRun> runs, StringBuilder sb) throws Exception {
        if (runs.size() > 0) {
            String text = sb.toString();
            XWPFRun currRun = runs.get(0);
            if (PoiWordUtils.isPicture(text)) {
                Object object = PoiWordUtils.getValueByPlaceholder(paramMap, text);
                if (object instanceof ImageEntity) {
                    // 该段落是图片占位符
                    ImageEntity imageEntity = (ImageEntity) object;
                    int indentationFirstLine = currentPar.getIndentationFirstLine();
                    // 清除段落的格式，否则图片的缩进有问题
                    currentPar.getCTP().setPPr(null);
                    //设置缩进
                    currentPar.setIndentationFirstLine(indentationFirstLine);
                    addPicture(currRun, imageEntity);
                }
                if (object instanceof List) {
                    List<ImageEntity> imageEntityList = (List<ImageEntity>) object;
                    for (ImageEntity entity : imageEntityList) {
                        int indentationFirstLine = currentPar.getIndentationFirstLine();
                        // 清除段落的格式，否则图片的缩进有问题
                        currentPar.getCTP().setPPr(null);
                        //设置缩进
                        currentPar.setIndentationFirstLine(indentationFirstLine);
                        addPicture(currRun, entity);
                    }
                }
            } else {
                changeValue(currRun, text, paramMap,currentPar);
            }
        }
    }

    /**
     * 添加图片
     *
     * @param currRun     当前run
     * @param imageEntity 图片对象
     * @throws InvalidFormatException
     * @throws FileNotFoundException
     */
    private void addPicture(XWPFRun currRun, ImageEntity imageEntity) {
        Integer typeId = imageEntity.getTypeId().getTypeId();
        String picId = "";
        try {
            picId=currRun.getDocument().addPictureData(new FileInputStream(imageEntity.getUrl()), typeId);
            ImageUtils.createPicture(currRun, picId, templateDoc.getNextPicNameNumber(typeId),
                    imageEntity.getWidth(), imageEntity.getHeight());
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加行
     *
     * @param table    表格
     * @param flagRow  flagRow 表有标签的行
     * @param paramMap 参数
     */
    private List<XWPFTableRow> addAndGetRows(XWPFTable table, XWPFTableRow flagRow, Map<String, Object> paramMap, int index) throws Exception {
        List<XWPFTableCell> flagRowCells = flagRow.getTableCells();
        XWPFTableCell flagCell = flagRowCells.get(0);

        String text = flagCell.getText().trim();
        List<List<String>> dataList = (List<List<String>>) PoiWordUtils.getValueByPlaceholder(paramMap, text);

        // 新添加的行
        List<XWPFTableRow> newRows = new ArrayList<>();
        if (dataList == null || dataList.size() <= 0) {
            return newRows;
        }

        XWPFTableRow currentRow = flagRow;
        int cellSize = flagRow.getTableCells().size();
        for (int i = 0, size = dataList.size(); i < size; i++) {
            if (i != 0) {
                /* currentRow = table.createRow();*/
                currentRow = insertRow(table, index, index + i);
                // 复制样式
                if (flagRow.getCtRow() != null) {
                    currentRow.getCtRow().setTrPr(flagRow.getCtRow().getTrPr());
                }
            }
            addRow(flagRow, currentRow, cellSize, dataList.get(i));
            newRows.add(currentRow);
        }
        return newRows;
    }


    /**
     * insertRow 在word表格中指定位置插入一行，并将某一行的样式复制到新增行
     *
     * @param copyrowIndex 需要复制的行位置
     * @param newrowIndex  需要新增一行的位置
     */
    public static XWPFTableRow insertRow(XWPFTable table, int copyrowIndex, int newrowIndex) {
        // 在表格中指定的位置新增一行
        XWPFTableRow targetRow = table.insertNewTableRow(newrowIndex);
        // 获取需要复制行对象
        XWPFTableRow copyRow = table.getRow(copyrowIndex);
        //复制行对象
        targetRow.getCtRow().setTrPr(copyRow.getCtRow().getTrPr());
        //或许需要复制的行的列
        List<XWPFTableCell> copyCells = copyRow.getTableCells();
        //复制列对象
        XWPFTableCell targetCell = null;
        for (int i = 0; i < copyCells.size(); i++) {
            XWPFTableCell copyCell = copyCells.get(i);
            targetCell = targetRow.addNewTableCell();
            targetCell.getCTTc().setTcPr(copyCell.getCTTc().getTcPr());
            if (copyCell.getParagraphs() != null && copyCell.getParagraphs().size() > 0) {
                targetCell.getParagraphs().get(0).getCTP().setPPr(copyCell.getParagraphs().get(0).getCTP().getPPr());
                if (copyCell.getParagraphs().get(0).getRuns() != null
                        && copyCell.getParagraphs().get(0).getRuns().size() > 0) {
                    XWPFRun cellR = targetCell.getParagraphs().get(0).createRun();
                    cellR.setBold(copyCell.getParagraphs().get(0).getRuns().get(0).isBold());
                }
            }
        }
        return targetRow;
    }

    /**
     * 根据模板cell添加新行
     *
     * @param flagRow     模板列(标记占位符的那个cell)
     * @param row         新增的行
     * @param cellSize    每行的列数量（用来补列补足的情况）
     * @param rowDataList 每行的数据
     * @throws Exception
     */
    private void addRow(XWPFTableRow flagRow, XWPFTableRow row, int cellSize, List<String> rowDataList) throws Exception {
        XWPFTableCell cellModelT = flagRow.getCell(0);
        XWPFRun xwpfRun = cellModelT.getParagraphs().get(0).getRuns().get(0);

        for (int i = 0; i < cellSize; i++) {
            XWPFTableCell cellModel = flagRow.getCell(i);
            XWPFTableCell cell = row.getCell(i);
            cell = cell == null ? row.createCell() : row.getCell(i);
            if (i < rowDataList.size()) {
                PoiWordUtils.copyCellAndSetValue(cellModel, cell, rowDataList.get(i),xwpfRun);
            } else {
                // 数据不满整行时，添加空列
                PoiWordUtils.copyCellAndSetValue(cellModel, cell, "",xwpfRun);
            }
        }
    }

    /**
     * 复制段落
     *
     * @param sourcePar 原段落
     * @param targetPar
     * @param texts
     */
    private void copyParagraph(XWPFParagraph sourcePar, XWPFParagraph targetPar, String... texts) {

        targetPar.setAlignment(sourcePar.getAlignment());
        targetPar.setVerticalAlignment(sourcePar.getVerticalAlignment());

        // 设置布局
        targetPar.setAlignment(sourcePar.getAlignment());
        targetPar.setVerticalAlignment(sourcePar.getVerticalAlignment());

        if (ArrayUtil.isNotEmpty(texts)) {
            String[] arr = texts;
            XWPFRun xwpfRun = sourcePar.getRuns().size() > 0 ? sourcePar.getRuns().get(0) : null;

            for (int i = 0, len = texts.length; i < len; i++) {
                String text = arr[i];
                XWPFRun run = targetPar.createRun();

                run.setText(text);

                run.setFontFamily(xwpfRun.getFontFamily());
                int fontSize = xwpfRun.getFontSize();
                run.setFontSize((fontSize == -1) ? DEFAULT_FONT_SIZE : fontSize);
                run.setBold(xwpfRun.isBold());
                run.setItalic(xwpfRun.isItalic());
            }
        }
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

}
