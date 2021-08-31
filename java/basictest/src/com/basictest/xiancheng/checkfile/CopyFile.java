package com.basictest.xiancheng.checkfile;

import java.io.*;
import java.lang.reflect.Field;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huxingxin
 * @ClassName Demo.java
 * @Description用递归遍历出所有的文件和文件夹 按层级把目录打印出来
 * @createTime 2021年07月21日 12:03:00
 */
public class CopyFile {
    static File srcFile;//源文件或者文件夹
    static File copyToFile;//目标文件夹
    static long beginTime = System.currentTimeMillis();//开始时间
    public static void main(String[] args) throws InterruptedException {


        srcFile  = new File("F:\\代码");
        copyToFile  = new File("E:\\tmp\\copy");

        //开始拷贝
        System.out.println("开始拷贝...");
        copyFile();

    }

    /**
     * 拷贝文件或者文件夹
     */
    public static void copyFile(){
        //若是文件夹 则遍历文件夹 进行拷贝
        if (srcFile.isDirectory()){
            getAllFile(srcFile);
        }else {
            //若是文件 则直接进行拷贝
            String name = srcFile.getName();//文件名称
            try(FileInputStream fis = new FileInputStream(srcFile);
                FileOutputStream fos = new FileOutputStream(new File(copyToFile,name))){
                //开始拷贝
                byte[] buffer = new  byte[1024*1024];
                int index;
                while ((index = fis.read(buffer)) != -1){
                    fos.write(buffer,0,index);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 用递归遍历出所有的文件和文件夹
     * @param lastFile
     * @throws InterruptedException
     */
    public static void getAllFile(File lastFile){
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        for (File file : lastFile.listFiles()) {
            String absolutePath = file.getAbsolutePath();//file原来的路径
            String copyPath = absolutePath.substring(absolutePath.lastIndexOf(srcFile.getName()));//目标路径或文件

            //若是文件夹 则按照原来的目录层级 创建好文件夹
            if (file.isDirectory()) {
                File copyToDir = new File(copyToFile, copyPath);
                //若不存在目标路径 则进行创建
                if(!copyToDir.exists()){
                    copyToDir.mkdirs();
                }
                System.out.println(file.getAbsolutePath() + "开始拷贝");
                //遇到新的文件夹 重新开启线程 递归所有的文件夹 进行文件拷贝
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        getAllFile(file);
                    }
                });
                threadPool.execute(thread);
            }

            //若是文件 则把文件拷贝到对应的文件夹下
            if (file.isFile()) {
                File copyFile = new File(copyToFile, copyPath);
                try (FileInputStream fis = new FileInputStream(file);
                     FileOutputStream fos = new FileOutputStream(copyFile)) {
                    //开始拷贝
                    byte[] buffer = new byte[1024 * 1024];
                    int index;
                    while ((index = fis.read(buffer)) != -1) {
                        fos.write(buffer, 0, index);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(file.getAbsolutePath() + "拷贝完毕");
                    long endTime = System.currentTimeMillis();//结束时间
                    System.out.println("用时：" + (endTime-beginTime)/1000  + "秒" );
                }
            }
        }

    }
}
