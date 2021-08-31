package com.basictest.expection.demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created in 2021/2/23 10:36
 *
 * @description:
 * @Author: huxingxin
 */
public class TryCatchTest {
    public static void main(String[] args) throws FileNotFoundException {
        try{
            FileInputStream fis = new FileInputStream("C:\\Users\\huxingxin\\Desktop\\123.txt");
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("捕获异常之后 程序可以正常执行");
        }
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }
}
