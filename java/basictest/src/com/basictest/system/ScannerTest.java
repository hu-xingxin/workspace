package com.basictest.system;

import java.util.Scanner;

/**
 * Created in 2021/2/23 10:08
 *
 * @description:
 * @Author: huxingxin
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");//设置回车作为分隔符
//        while(scanner.hasNext()){//判断是否还有下一个输入项
//            String next = scanner.next();
//            System.out.println(next);//输出输入项
//        }
//        String next = scanner.next();
//        System.out.println(next);//输出输入项

//        scanner.hasNextLine();
        String s = scanner.nextLine();
        System.out.println(s);
    }
}
