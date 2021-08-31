package com.basictest.jiaohu.键盘输入;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created in 2021/3/11 23:39
 *
 * @author: huxingxin
 */
public class ScannerTest1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
           while (true){
               System.out.println(scanner.next());
           }
    }
}
