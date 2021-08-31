package com.basictest.jiaohu.键盘输入;

import java.io.*;
import java.util.Scanner;

/**
 * Created in 2021/3/11 23:39
 *
 * @author: huxingxin
 */
public class ScannerTest {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//            Scanner scanner = new Scanner(new File("C:\\Users\\huxingxin\\Desktop\\备忘录\\备忘录.txt"));
//            scanner.useDelimiter("\n");
//           while (scanner.hasNext()){
//               System.out.println(scanner.next());
//           }
//        String next = scanner.next();
//        System.out.println(next);

         InputStreamReader inputStream = new InputStreamReader(System.in);
         BufferedReader bufferedReader = new BufferedReader(inputStream);
         String str = null;
         while ((str = bufferedReader.readLine())!=null){
             System.out.println(str);
         }
    }
}
