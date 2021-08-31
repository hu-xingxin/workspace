package com.basictest.inet.socket.thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author huxingxin
 * @ClassName Server.java
 * @Description
 * @createTime 2021年07月14日 14:39:00
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器端
        ServerSocket sSocket = new ServerSocket(12345);
        Socket accept = sSocket.accept();
        System.out.println("服务器连接到socket");
        new Thread(new ServerSendThread(accept)).start();
        new Thread(new ServeReceiveThread(accept)).start();
    }
}
