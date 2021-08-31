package com.basictest.inet.downUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

/**
 * @author huxingxin
 * @date 2021/4/14 10:38
 * @Description:
 */
public class DownUtils {
    public static void main(String[] args) {
        final int DOWN_THREAD_NUM = 4;
        final String OUT_FILE_NAME = "E:\\tmp\\image\\ideaIU-2020.3.3.exe";
        InputStream[] isArr = new InputStream[DOWN_THREAD_NUM];
        RandomAccessFile[] outArr = new RandomAccessFile[DOWN_THREAD_NUM];
        try {
            URL url = new URL("https://download.jetbrains.com/idea/ideaIU-2020.3.3.exe?_ga=2.53031016.193395647.1618383342-1626605945.1618189877");
            isArr[0] = url.openStream();
            long fileLength = getFileLength(url);
            System.out.println("文件大小:" + fileLength);
            outArr[0] = new RandomAccessFile(OUT_FILE_NAME, "rw");
            for (int i=0;i<fileLength;i++){
                outArr[0].write(0);
            }

            long numPerThread = fileLength/DOWN_THREAD_NUM;
            long left  = fileLength % DOWN_THREAD_NUM;
            for (int i=0; i<DOWN_THREAD_NUM; i++){
                if(i!=0){
                    isArr[i] = url.openStream();
                    outArr[i] = new RandomAccessFile(OUT_FILE_NAME,"rw");

                }

                if (i==DOWN_THREAD_NUM-1){
                    new DownThread(i*numPerThread,(i+1)*numPerThread+left , isArr[i],outArr[i]).start();
                }else {
                    new DownThread(i*numPerThread,(i+1)*numPerThread ,isArr[i] ,outArr[i] ).start();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static long getFileLength(URL url) throws IOException {
        URLConnection conn = url.openConnection();
        return conn.getContentLength();
    }
}
