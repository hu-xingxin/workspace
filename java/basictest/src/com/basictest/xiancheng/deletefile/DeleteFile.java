package com.basictest.xiancheng.deletefile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author huxingxin
 * @ClassName Demo.java
 * @Description 删除文件
 * @createTime 2021年07月21日 12:03:00
 */
public class DeleteFile {
    static File srcFile;//源文件或者文件夹
    static long beginTime = System.currentTimeMillis();//开始时间
    public static void main(String[] args) throws InterruptedException {


        srcFile  = new File("E:\\tmp\\copy");
        //开始删除
        System.out.println("开始删除...");
        deleteFile();

    }

    /**
     * 删除文件或者文件夹
     */
    public static void deleteFile(){
        //若是文件夹 则遍历文件夹 进行拷贝
        if (srcFile.isDirectory()){
            deleteAllFile(srcFile);
        }else {
            srcFile.delete();
            deleteTime(srcFile);
        }
    }

    /**
     * 用递归遍历出所有的文件和文件夹
     * @param lastFile
     * @throws InterruptedException
     */
    public static void deleteAllFile(File lastFile){
        for (File file : lastFile.listFiles()) {
            //若是文件夹 则按照原来的目录层级 创建好文件夹
            if (file.isDirectory()) {
                deleteAllFile(file);
                file.delete();
                deleteTime(file);
            }

            //若是文件 则把文件拷贝到对应的文件夹下
            if (file.isFile()) {
                file.delete();
                deleteTime(file);
            }
        }
    }

    public static void deleteTime(File file){
        System.out.println(file.getAbsolutePath() + "删除中...");
        long endTime = System.currentTimeMillis();//结束时间
        System.out.println("用时：" + (endTime-beginTime)/1000 );
    }
}
