package com.basictest.inet.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author huxingxin
 * @date 2021/4/14 15:49
 * @Description:
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(30000);
        while (true){
            System.out.println("服务端启动,等待客户端连接......");
            Socket accept = serverSocket.accept();
            PrintStream printStream = new PrintStream(accept.getOutputStream());
            printStream.println("服务器收到了客户端的请求!");
            printStream.close();
            accept.close();
        }
    }
}
