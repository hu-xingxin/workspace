package com.basictest.io.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created in 2021/4/9 11:22
 *
 * @author: huxingxin
 */
public class WriteToProcess {
    public static void main(String[] args) {
        PrintStream ps = null;
        try {
            Process process = Runtime.getRuntime().exec("java ReadStandard");
            ps = new PrintStream(process.getOutputStream());
            ps.println(new WriteToProcess());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (ps!=null){
                ps.close();
            }
        }
    }


}

class ReadStandard{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("E:\\tmp\\process.txt"));
            while (scanner.hasNext()){
                if (scanner.next().equals("exit")){
                    System.exit(1);
                }
                ps.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (ps!=null){
                ps.close();
            }
        }
    }
}
