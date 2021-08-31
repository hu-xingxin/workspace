package com.basictest.awt.table;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 * @author huxingxin
 * @ClassName TableModel.java
 * @Description
 * @createTime 2021年07月20日 11:50:00
 */
public class TableModelArr extends AbstractTableModel {
    // 表格上的title
    String[] columnName = {"id", "name", "hp", "damage"};

    // 表格中的内容，是一个二维数组
    String[] hero1 = { "1", "盖伦", "616", "100" };
    String[] hero2 = { "2", "提莫", "512", "102" };
    String[] hero3 = { "3", "奎因", "832", "200" };
    String[][] heros = {hero1, hero2, hero3};

    /**
     *  返回一共有多少行
     * @return
     */
    @Override
    public int getRowCount() {
        return heros.length;
    }

    /**
     * 返回一共有多少列
     * @return
     */
    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    /**
     * 获取每一列的名称
     * @param columnIndex
     * @return
     */
    public String getColumnName(int columnIndex) {
        return columnName[columnIndex];
    }

    /**
     *  每一个单元格里的值
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return heros[rowIndex][columnIndex];
    }
}
