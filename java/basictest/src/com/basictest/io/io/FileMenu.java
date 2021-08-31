package com.basictest.io.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author huxingxin
 * @ClassName Demo.java
 * @Description用递归遍历出所有的文件和文件夹 按层级把目录打印出来
 * @createTime 2021年07月21日 12:03:00
 */
public class FileMenu {

    public static void main(String[] args) throws InterruptedException {
        File file = new File("F:\\代码\\workspace");

        int index = 0;

        if (file.isDirectory()){
            getAllFile(file,index);
        }else {
            try(BufferedWriter br = new BufferedWriter(new FileWriter("E:\\tmp\\txt\\file.txt",true));){
//                System.out.println(file.getName());
                br.write(file.getName()+"--层级：" + index);
                br.newLine();
            }catch (Exception e){
                e.printStackTrace();
            }

        }


        System.out.println("--------ok---------");
    }

    /**
     * 用递归遍历出所有的文件和文件夹
     * @param lastFile
     * @throws InterruptedException
     */
    public static void getAllFile(File lastFile,int index) throws InterruptedException{
        String suffix ="|--";
        for(int i = 0; i < index; i++){
            suffix += "--";
        }
        index ++;
        try(BufferedWriter br = new BufferedWriter(new FileWriter("E:\\tmp\\txt\\file.txt",true));){
            for (File file : lastFile.listFiles()){
                if(file.isDirectory()){
                    br.write(suffix + file.getName()+"--层级：" + index);
                    br.newLine();
                    br.flush();
//                    System.out.println(file.getName());
                    getAllFile(file,index);
                }
            }
            for (File file : lastFile.listFiles()){
                if(!file.isDirectory()){
                    br.write(suffix + file.getName()+"--层级：" + index);
                    br.newLine();
                    br.flush();
//                    System.out.println(file.getName());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
