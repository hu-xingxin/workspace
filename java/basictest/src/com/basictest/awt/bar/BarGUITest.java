package com.basictest.awt.bar;

import javax.swing.*;
import java.awt.*;

/**
 * @author huxingxin
 * @ClassName BarGUITest.java
 * @Description 工具栏
 * @createTime 2021年07月20日 09:27:00
 */
public class BarGUITest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(100,100,800,600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new BorderLayout());

        //菜单
        addMenu(jFrame);

        //工具栏
        addToolBar(jFrame);

        jFrame.setVisible(true);

    }

    /**
     * 添加菜单栏 和菜单
     */
    public static void addMenu(JFrame jFrame){
        Font songFont = new Font("宋体", Font.PLAIN, 18);

        JMenuBar jMenuBar = new JMenuBar();

        JMenu mHero = new JMenu("英雄");
        mHero.setFont(songFont);
        JMenu mItem = new JMenu("道具");
        mItem.setFont(songFont);
        JMenu mWord = new JMenu("符文");
        mWord.setFont(songFont);
        JMenu mSummon = new JMenu("召唤师");
        mSummon.setFont(songFont);
        JMenu mTalent = new JMenu("天赋树");
        mTalent.setFont(songFont);

        jMenuBar.add(mHero);
        jMenuBar.add(mItem);
        jMenuBar.add(mWord);
        jMenuBar.add(mSummon);
        jMenuBar.add(mTalent);

        //添加英雄菜单 菜单项
        addMenuHero(mHero,songFont);

        //设置菜单栏
        jFrame.setJMenuBar(jMenuBar);
    }

    /**
     * 添加英雄菜单 菜单项
     * @param mHero
     * @param songFont
     */
    public static void addMenuHero(JMenu mHero,Font songFont){
        JMenuItem jMenuItem0 = new JMenuItem("近战-Warriar");
        jMenuItem0.setFont(songFont);
        JMenuItem jMenuItem1 = new JMenuItem("远程-Range");
        jMenuItem1.setFont(songFont);
        JMenuItem jMenuItem2 = new JMenuItem("物理-physical");
        jMenuItem2.setFont(songFont);
        JMenuItem jMenuItem3 = new JMenuItem("坦克-Tank");
        jMenuItem3.setFont(songFont);
        JMenuItem jMenuItem4 = new JMenuItem("法系-Mage");
        jMenuItem4.setFont(songFont);
        JMenuItem jMenuItem5 = new JMenuItem("辅助-Support");
        jMenuItem5.setFont(songFont);
        JMenuItem jMenuItem6 = new JMenuItem("打野-Jungle");
        jMenuItem6.setFont(songFont);
        JMenuItem jMenuItem7 = new JMenuItem("突进-Charge");
        jMenuItem7.setFont(songFont);
        JMenuItem jMenuItem8 = new JMenuItem("男性-Boy");
        jMenuItem8.setFont(songFont);
        JMenuItem jMenuItem9 = new JMenuItem("女性-Girl");
        jMenuItem9.setFont(songFont);
        JMenuItem jMenuItem10 = new JMenuItem("所有-All");
        jMenuItem10.setFont(songFont);

        mHero.add(jMenuItem0);
        mHero.add(jMenuItem1);
        mHero.add(jMenuItem2);
        mHero.add(jMenuItem3);
        mHero.add(jMenuItem4);
        mHero.add(jMenuItem5);
        mHero.add(jMenuItem6);
        mHero.add(jMenuItem7);
        mHero.add(jMenuItem8);
        mHero.add(jMenuItem9);
        mHero.add(jMenuItem10);
    }

    /**
     * 添加工具栏
     * @param jFrame
     */
    public static void addToolBar(JFrame jFrame){
        JToolBar jToolBar = new JToolBar();
        //禁止工具栏拖动
        jToolBar.setFloatable(false);

        ImageIcon pdfIcon = new ImageIcon("E:\\tmp\\image\\记事本.png");
        //设置图标大小
        pdfIcon.setImage(pdfIcon.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));

        JButton jButton1 = new JButton(pdfIcon);
        JButton jButton2 = new JButton(pdfIcon);
        JButton jButton3 = new JButton(pdfIcon);

        //给按钮设置提示信息
        jButton1.setToolTipText("<html><body><font face='宋体' size=5>记事本1</font></body></html>");
        jButton2.setToolTipText("<html><body><font face='宋体' size=5>记事本2</font></body></html>");
        jButton3.setToolTipText("<html><body><font face='宋体' size=5>记事本3</font></body></html>");

        jToolBar.add(jButton1);
        jToolBar.add(jButton2);
        jToolBar.add(jButton3);

        jFrame.add(jToolBar,BorderLayout.NORTH);
    }
}
