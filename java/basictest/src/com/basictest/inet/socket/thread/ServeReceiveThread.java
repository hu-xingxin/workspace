package com.basictest.inet.socket.thread;

import java.io.*;
import java.net.Socket;

/**
 * @author huxingxin
 * @ClassName ServerThread.java
 * @Description
 * @createTime 2021年07月14日 17:28:00
 */
public class ServeReceiveThread implements Runnable{

    private Socket accept;

    public ServeReceiveThread(Socket accept){
        this.accept = accept;
    }

    @Override
    public void run() {
        while (true){
            //读取接收到的数据
            try (BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));){
                //将读取到的数据打印到控制台
                String str = null;
                while ((str = br.readLine()) != null){
                    System.out.println(str);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
