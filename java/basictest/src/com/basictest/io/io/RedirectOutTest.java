package com.basictest.io.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created in 2021/4/9 10:45
 *
 * @author: huxingxin
 */
public class RedirectOutTest {
    public static void main(String[] args) {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("E:\\tmp\\redirect.txt"));
            System.setOut(ps);
            System.out.println("redirect");
            System.out.println(new RedirectOutTest());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (ps!=null){
                ps.close();
            }
        }
    }
}
