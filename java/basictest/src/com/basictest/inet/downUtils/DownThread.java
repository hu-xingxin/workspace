package com.basictest.inet.downUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * @author huxingxin
 * @date 2021/4/14 10:39
 * @Description:
 */
public class DownThread extends Thread{
    private final int BUFF_LEN = 32;//缓存容器
    private long start;//下载的起始点
    private long end;//下载的结束点
    private InputStream is;//下载资源对应的输入流
    private RandomAccessFile raf;//将下载到的字节输出到raf中

    public DownThread(long start, long end, InputStream is, RandomAccessFile raf){
        System.out.println(start + "----->" + end);

        this.start = start;
        this.end = end;
        this.is = is;
        this.raf = raf;
    }

    @Override
    public void run() {
        try {
            is.skip(start);
            raf.seek(start);
            byte[] buffer = new byte[BUFF_LEN];
            long contentLen = end - start;
            long times = contentLen / BUFF_LEN +4;
            int hasRead = 0;

            for (int i=0; i<times; i++){
                hasRead = is.read(buffer);
                if (hasRead<0){
                    break;
                }
                raf.write(buffer,0,hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is!=null) {
                    is.close();
                }
                if (raf!=null) {
                    raf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
