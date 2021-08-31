package com.basictest.awt.table;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author huxingxin
 * @ClassName TableGUITest.java
 * @Description
 * @createTime 2021年07月20日 11:27:00
 */
public class TableGUITest {


    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(100,100,550,500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        TableModelList tableModel = new TableModelList();
        JTable jTable = new JTable(tableModel);
        //编辑
        addEdit(jFrame,jTable,tableModel);
        //表格
        addTable(jFrame,jTable,tableModel);


        jFrame.setVisible(true);

    }

    /**
     * 编辑模块
     * @param jFrame
     */
    public static void addEdit(JFrame jFrame, JTable jTable, TableModelList tableModel){
        JPanel panel = new JPanel();
        panel.setBounds(0,60,550,50);

        JLabel jLabelName = new JLabel("名称：");
        JLabel jLabelHp = new JLabel("血量：");

        JTextField jTextFieldName = new JTextField();
        jTextFieldName.setPreferredSize(new Dimension(100,30));
        JTextField jTextFieldHp = new JTextField();
        jTextFieldHp.setPreferredSize(new Dimension(100,30));

        JButton jButton = new JButton("添加");
        jButton.setPreferredSize(new Dimension(80,30));
        panel.add(jLabelName);
        panel.add(jTextFieldName);
        panel.add(jLabelHp);
        panel.add(jTextFieldHp);
        panel.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = jTextFieldName.getText();
                String hp = jTextFieldHp.getText();
                List<Hero> heroList = tableModel.heroList;
                heroList.add(new Hero(String.valueOf(heroList.size()+1),name,hp,"0"));
                jTable.updateUI();
            }
        });

        jFrame.add(panel);
    }

    /**
     * 表格模块
     * @param jFrame
     */
    public static void addTable(JFrame jFrame, JTable jTable, TableModelList tableModel){
        //用于显示 选中表格该项的name
        JLabel jLabel = new JLabel();
        jLabel.setBounds(0,0,550,50);
        Font songFontLabel = new Font("宋体", Font.PLAIN, 23);
        jLabel.setFont(songFontLabel);
        jLabel.setForeground(Color.RED);

        jFrame.add(jLabel);

        //表格
//        TableModelList tableModel = new TableModelList();
//        JTable jTable = new JTable(tableModel);

        // 使用selection监听器来监听table的哪个条目被选中
        jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            // 当选择了某一行的时候触发该事件
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // 获取哪一行被选中了
                int selectedRow = jTable.getSelectedRow();
                Hero hero = tableModel.heroList.get(selectedRow);
                jLabel.setText(hero.getName());
            }
        });


        // 设置表格字体
        Font songFontTable = new Font("宋体", Font.PLAIN, 20);
        jTable.setFont(songFontTable);

        // 设置列宽度
        jTable.getColumnModel().getColumn(0).setPreferredWidth(100);

        // 设置选择模式为 只能选中一行
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // 选中第一行 （基本0）
        jTable.getSelectionModel().setSelectionInterval(0,0);

        //默认情况下，表格的标题是不会显示出来了，除非使用了JScrollPane
        //把table放进去就可以看到table的title
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(2,120,530,400);

        jFrame.add(jScrollPane);
    }
}