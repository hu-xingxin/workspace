package com.basictest.io.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * Created in 2021/4/9 9:20
 *
 * @author: huxingxin
 */
public class PushBackTest {
    public static void main(String[] args) {
        PushbackReader pr = null;
        String inFilePath = "F:\\workspace\\basictest\\src\\com\\basictest\\io\\io\\FileInputStreamTest.java";
        try {
            pr = new PushbackReader(new FileReader(inFilePath),64);
            char[] buffer = new char[32];
            String lastContent = "";
            int hasRead = 0;
            while((hasRead=pr.read(buffer))>0){
                String content = new String(buffer,0,hasRead);

                int targetIndex = 0;
                if((targetIndex=(lastContent+content).indexOf("new FileInputStream"))>0){
                    pr.unread((lastContent+content).toCharArray());
                    pr.read(buffer,0,targetIndex);
                    System.out.println(new String(buffer,0,targetIndex));
                    System.exit(0);
                }else {
                    System.err.println(lastContent);
                    lastContent = content;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(pr!=null){
                try {
                    pr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
