package com.basictest.inet.socket.thread;

import java.io.*;
import java.net.Socket;

/**
 * @author huxingxin
 * @ClassName Client.java
 * @Description
 * @createTime 2021年07月14日 14:39:00
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端
        Socket socket = new Socket("127.0.0.1",12345);
        new Thread(new ClientSendThread(socket)).start();
        new Thread(new ClientReceiveThread(socket)).start();
    }
}
