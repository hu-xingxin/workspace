package com.basictest.inet.socket.thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author huxingxin
 * @ClassName ServerThread.java
 * @Description
 * @createTime 2021年07月14日 17:28:00
 */
public class ServerSendThread implements Runnable{

    private Socket accept;

    public ServerSendThread(Socket accept){
        this.accept = accept;
    }

    @Override
    public void run() {
        while (true){
            //读取接收到的数据
            try ( BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));){
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    bw.write(line);
                    bw.newLine();
//                    bw.flush();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
