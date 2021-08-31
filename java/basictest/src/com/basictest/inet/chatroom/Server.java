package com.basictest.inet.chatroom;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-12 15:27
 **/
public class Server {
    private static final int SERVER_PORT = 30000;
    public static SocketMap<String, PrintStream> clients = new SocketMap<>();

    public void init(){
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(SERVER_PORT);
            while(true){
                Socket socket = ss.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println("服务器启动失败,是否端口"+SERVER_PORT+"已被占用?");
            e.printStackTrace();
        }finally {
            try {
                if (ss!=null){
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.init();
    }
}
