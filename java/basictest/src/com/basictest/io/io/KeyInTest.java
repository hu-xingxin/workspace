package com.basictest.io.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created in 2021/4/9 9:09
 * InputStreamReader BufferedReader 转换流和缓冲流
 * @author: huxingxin
 */
public class KeyInTest {
    public static void main(String[] args) {
        BufferedReader br = null;
        InputStreamReader isReader = new InputStreamReader(System.in);
        BufferedReader brReader = new BufferedReader(isReader);
        String buffer = null;
        try{
            while((buffer=brReader.readLine())!=null){
                if (buffer.equals("exit")){
                    System.exit(1);
                }
                System.out.println(buffer);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
