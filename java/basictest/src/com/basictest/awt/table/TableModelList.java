package com.basictest.awt.table;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huxingxin
 * @ClassName TableModel.java
 * @Description
 * @createTime 2021年07月20日 11:50:00
 */
public class TableModelList extends AbstractTableModel {
    // 表格上的title
    String[] columnName = {"id", "name", "hp", "damage"};

    // 表格中的内容，是一个list集合
    List<Hero> heroList = new ArrayList<>();

    {
        heroList.add(new Hero("1", "盖伦", "616", "100"));
        heroList.add(new Hero("2", "提莫", "512", "102" ));
        heroList.add(new Hero("3", "奎因", "832", "200"));
    }


    /**
     * 返回一共有多少行
     * @return
     */
    @Override
    public int getRowCount() {
        return heroList.size();
    }

    /**
     * 返回一共有多少列
     *     public int getColumnCount() {
     *         // TODO Auto-generated method stub
     *         return columnNames.leng
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
     * 每一个单元格里的值
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Hero hero = heroList.get(rowIndex);
        if(columnIndex==0){
            return hero.getId();
        }else if (columnIndex==1){
            return hero.getName();
        }else if (columnIndex==2){
            return hero.getHp();
        }else if (columnIndex==3){
            return hero.getDamage();
        }else {
            return null;
        }
    }
}
