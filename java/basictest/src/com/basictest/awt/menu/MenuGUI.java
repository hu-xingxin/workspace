package com.basictest.awt.menu;

import javax.swing.*;
import java.awt.*;

/**
 * @author huxingxin
 * @ClassName MenuGUI.java
 * @Description
 * @createTime 2021年07月19日 19:50:00
 */
public class MenuGUI {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("记事本");
        jFrame.setBounds(100,100,400,400);
        jFrame.setLayout(new FlowLayout());
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置JFrame图标
        ImageIcon imageIcon = new ImageIcon("E:\\tmp\\image\\记事本.png");
        jFrame.setIconImage(imageIcon.getImage());

        //菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        //菜单
        Font songFont = new Font("宋体", Font.BOLD, 18);
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

        mHero.add(new JMenuItem("近战-Warriar"));
        mHero.add(new JMenuItem("远程-Range"));
        mHero.add(new JMenuItem("物理-physical"));
        mHero.add(new JMenuItem("坦克-Tank"));
        mHero.add(new JMenuItem("法系-Mage"));
        mHero.add(new JMenuItem("辅助-Support"));
        mHero.add(new JMenuItem("打野-Jungle"));
        mHero.add(new JMenuItem("突进-Charge"));
        mHero.add(new JMenuItem("男性-Boy"));
        mHero.add(new JMenuItem("女性-Girl"));
        // 分隔符
        mHero.addSeparator();
        mHero.add(new JMenuItem("所有-All"));
        // 把菜单加入到菜单栏
        jMenuBar.add(mHero);
        jMenuBar.add(mItem);
        jMenuBar.add(mWord);
        jMenuBar.add(mSummon);
        jMenuBar.add(mTalent);

        // 把菜单栏加入到frame，这里用的是set而非add
        jFrame.setJMenuBar(jMenuBar);

        jFrame.setVisible(true);
    }
}
