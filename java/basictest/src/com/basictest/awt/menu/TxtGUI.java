package com.basictest.awt.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author huxingxin
 * @ClassName TxTGUI.java
 * @Description
 * @createTime 2021年07月19日 21:26:00
 */
public class TxtGUI {
    public static void main(String[] args) {
        setLookAndFeel();

        JFrame jFrame = new JFrame("记事本");
        jFrame.setBounds(100,100,1205,615);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //图标设置
        ImageIcon imageIcon = new ImageIcon("E:\\tmp\\image\\记事本.png");
        jFrame.setIconImage(imageIcon.getImage());

        //菜单栏
        JMenuBar jMenuBar = new JMenuBar();

        Font songFontMenu = new Font("宋体", Font.PLAIN, 18);
        Font songFontItem = new Font("宋体", Font.PLAIN, 18);

        //往菜单栏添加菜单
        addMenu(jMenuBar,songFontMenu,songFontItem);

        //文本域
        JTextArea jTextArea = new JTextArea();
        jTextArea.setSize(1205,615);
        jTextArea.setFont(songFontMenu);
        jFrame.add(jTextArea);

        jFrame.setJMenuBar(jMenuBar);

        jFrame.setVisible(true);
    }

    /**
     * 设置主题样式
     */
    private static void setLookAndFeel() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//          javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
            // handle exception
        }
    }

    /**
     * 添加菜单
     * @param jMenuBar
     * @param songFontMenu
     * @param songFontItem
     */
    public static void addMenu(JMenuBar jMenuBar,Font songFontMenu,Font songFontItem){
        //菜单栏
        JMenu fileMenu = new JMenu("文件(F)");
        fileMenu.setFont(songFontMenu);
        fileMenu.setSize(new Dimension(800,400));
        JMenu editMenu = new JMenu("编辑(E)");
        editMenu.setFont(songFontMenu);
        JMenu formatMenu = new JMenu("格式(O)");
        formatMenu.setFont(songFontMenu);
        JMenu lookMenu = new JMenu("查看(V)");
        lookMenu.setFont(songFontMenu);
        JMenu helpMenu = new JMenu("帮助(H)");
        helpMenu.setFont(songFontMenu);

        //往菜单栏添加菜单
        jMenuBar.add(fileMenu);
        jMenuBar.add(editMenu);
        jMenuBar.add(formatMenu);
        jMenuBar.add(lookMenu);
        jMenuBar.add(helpMenu);

        //添加文件 菜单项目
        addMenuItemFile(fileMenu,songFontItem);
        //添加编辑 菜单项目
        addMenuItemEdit(editMenu,songFontItem);
        //添加格式 菜单项目
        addMenuItemFormat(formatMenu,songFontItem);
        //添加查看 菜单项目
        addMenuItemLook(lookMenu,songFontItem);
        //添加帮助 菜单项目
        addMenuItemHelp(helpMenu,songFontItem);
    }

    /**
     * 添加文件 菜单项目
     * @param fileMenu
     * @param songFontItem
     */
    public static void addMenuItemFile(JMenu fileMenu,Font songFontItem){
        JMenuItem jMenuItem1 = new JMenuItem("新建(N)                Ctrl+N");
        jMenuItem1.setFont(songFontItem);
        JMenuItem jMenuItem2 = new JMenuItem("新窗口(w)        Ctrl+Shift+N");
        jMenuItem2.setFont(songFontItem);
        JMenuItem jMenuItem3 = new JMenuItem("打开(0)...             Ctrl+O");
        jMenuItem3.setFont(songFontItem);
        JMenuItem jMenuItem4 = new JMenuItem("保存(S)                Ctrl+S");
        jMenuItem4.setFont(songFontItem);
        JMenuItem jMenuItem5 = new JMenuItem("另存为(A)        Ctrl+Shift+S");
        jMenuItem5.setFont(songFontItem);
        JMenuItem jMenuItem6 = new JMenuItem("页面设置(U)...");
        jMenuItem6.setFont(songFontItem);
        JMenuItem jMenuItem7 = new JMenuItem("打印(P)...             Ctrl+P");
        jMenuItem7.setFont(songFontItem);
        JMenuItem jMenuItem8 = new JMenuItem("退出(X)");
        //绑定退出事件
        jMenuItem8.addActionListener(e->System.exit(0));
        jMenuItem8.setFont(songFontItem);

        //往文件菜单 添加菜单项
        fileMenu.add(jMenuItem1);
        fileMenu.add(jMenuItem2);
        fileMenu.add(jMenuItem3);
        fileMenu.add(jMenuItem4);
        fileMenu.add(jMenuItem5);
        fileMenu.addSeparator();

        fileMenu.add(jMenuItem6);
        fileMenu.add(jMenuItem7);
        fileMenu.addSeparator();

        fileMenu.add(jMenuItem8);
    }

    /**
     * 添加编辑 菜单项目
     * @param editMenu
     * @param songFontItem
     */
    public static void addMenuItemEdit(JMenu editMenu,Font songFontItem){
        JMenuItem jMenuItem1 = new JMenuItem("撤销(U)                Ctrl+Z");
        jMenuItem1.setFont(songFontItem);
        JMenuItem jMenuItem2 = new JMenuItem("剪切(T)                Ctrl+X");
        jMenuItem2.setFont(songFontItem);
        JMenuItem jMenuItem3 = new JMenuItem("复制(C)                Ctrl+C");
        jMenuItem3.setFont(songFontItem);
        JMenuItem jMenuItem4 = new JMenuItem("粘贴(V)                Ctrl+V");
        jMenuItem4.setFont(songFontItem);
        JMenuItem jMenuItem5 = new JMenuItem("删除(L)                   Del");
        jMenuItem5.setFont(songFontItem);
        JMenuItem jMenuItem6 = new JMenuItem("使用Bing搜索...        Ctrl+E");
        jMenuItem6.setFont(songFontItem);
        JMenuItem jMenuItem7 = new JMenuItem("查找(F)...             Ctrl+F");
        jMenuItem7.setFont(songFontItem);
        JMenuItem jMenuItem8 = new JMenuItem("查找下一个(N)              F3");
        jMenuItem8.setFont(songFontItem);
        JMenuItem jMenuItem9 = new JMenuItem("查找上一个(V)        Shift+F3");
        jMenuItem9.setFont(songFontItem);
        JMenuItem jMenuItem10 = new JMenuItem("替换(R)...           Ctrl+H");
        jMenuItem10.setFont(songFontItem);
        JMenuItem jMenuItem11 = new JMenuItem("转到(N)...          Ctrl+G ");
        jMenuItem11.setFont(songFontItem);
        JMenuItem jMenuItem12 = new JMenuItem("全选(N)              Ctrl+A");
        jMenuItem12.setFont(songFontItem);
        JMenuItem jMenuItem13 = new JMenuItem("时间/日期(N)             F5");
        jMenuItem13.setFont(songFontItem);

        //往编辑菜单 添加菜单项
        editMenu.add(jMenuItem1);
        editMenu.addSeparator();

        editMenu.add(jMenuItem2);
        editMenu.add(jMenuItem3);
        editMenu.add(jMenuItem4);
        editMenu.add(jMenuItem5);
        editMenu.addSeparator();

        editMenu.add(jMenuItem6);
        editMenu.add(jMenuItem7);
        editMenu.addSeparator();
        editMenu.add(jMenuItem8);
        editMenu.add(jMenuItem9);
        editMenu.add(jMenuItem10);
        editMenu.add(jMenuItem11);
        editMenu.addSeparator();

        editMenu.add(jMenuItem12);
        editMenu.add(jMenuItem13);
    }

    /**
     * 添加格式 菜单项目
     * @param formatMenu
     * @param songFontItem
     */
    public static void addMenuItemFormat(JMenu formatMenu,Font songFontItem){
        JMenuItem jMenuItem1 = new JMenuItem("自动换行(W)       ");
        jMenuItem1.setFont(songFontItem);
        JMenuItem jMenuItem2 = new JMenuItem("字体(F)...        ");
        jMenuItem2.setFont(songFontItem);


        //往格式菜单 添加菜单项
        formatMenu.add(jMenuItem1);
        formatMenu.add(jMenuItem2);
    }

    /**
     * 添加查看 菜单项目
     * @param lookMenu
     * @param songFontItem
     */
    public static void addMenuItemLook(JMenu lookMenu,Font songFontItem){
        JMenuItem jMenuItem1 = new JMenuItem("缩放(Z)       ");
        jMenuItem1.setFont(songFontItem);
        JMenuItem jMenuItem2 = new JMenuItem("状态栏(S)      ");
        jMenuItem2.setFont(songFontItem);


        //往查看菜单 添加菜单项
        lookMenu.add(jMenuItem1);
        lookMenu.add(jMenuItem2);
    }

    /**
     * 添加帮助 菜单项目
     * @param helpMenu
     * @param songFontItem
     */
    public static void addMenuItemHelp(JMenu helpMenu,Font songFontItem){
        JMenuItem jMenuItem1 = new JMenuItem("查看帮助(H)       ");
        jMenuItem1.setFont(songFontItem);
        JMenuItem jMenuItem2 = new JMenuItem("发送反馈(F)       ");
        jMenuItem2.setFont(songFontItem);
        JMenuItem jMenuItem3 = new JMenuItem("关于记事本(A)      ");
        jMenuItem3.setFont(songFontItem);



        //往帮助菜单 添加菜单项
        helpMenu.add(jMenuItem1);
        helpMenu.add(jMenuItem2);
        helpMenu.addSeparator();

        helpMenu.add(jMenuItem3);
    }
}
