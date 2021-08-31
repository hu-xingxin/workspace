package com.basictest.io.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created in 2021/4/9 11:11
 *
 * @author: huxingxin
 */
public class ReadFromProcess {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            Process process = Runtime.getRuntime().exec("javac");
            br = new BufferedReader(new InputStreamReader(process.getErrorStream(),"GBK"));
            String buffer = null;
            while ((buffer=br.readLine())!=null){
                System.out.println(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
