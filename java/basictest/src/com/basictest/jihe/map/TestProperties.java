package com.basictest.jihe.map;

import java.io.*;
import java.util.Properties;

/**
 * Created in 2021/4/5 12:36
 *
 * @author: huxingxin
 */
public class TestProperties {
    public static void main(String[] args) throws IOException {
//        store();
        load();
    }

    public static void load(){
        Properties properties = new Properties();
        try(FileReader fileReader = new FileReader("E:\\tmp\\properties\\properties.txt")){
            properties.load(fileReader);
            String a = properties.getProperty("a");
            String b = properties.getProperty("b");
            String c = properties.getProperty("c");
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void store(){
        Properties properties = new Properties();
        properties.put("a","java");
        properties.put("b","html");
        properties.put("c","javaScript");

        /**
         * b=html
         * a=java
         * c=javaScript
         */

        try (FileWriter fileWriter =  new FileWriter("E:\\tmp\\properties\\properties.txt")){
          properties.store(fileWriter,null);
      }catch (Exception e){
          e.printStackTrace();
      }
    }
}
