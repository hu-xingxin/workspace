package com.basictest.io.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created in 2021/4/9 10:50
 *
 * @author: huxingxin
 */
public class RedirectInTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        String inFilePath = "F:\\workspace\\basictest\\src\\com\\basictest\\io\\io\\FileInputStreamTest.java";
        try {
            fis = new FileInputStream(inFilePath);
            System.setIn(fis);
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            while(scanner.hasNext()){
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
