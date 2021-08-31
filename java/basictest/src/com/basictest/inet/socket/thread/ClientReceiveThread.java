package com.basictest.inet.socket.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author huxingxin
 * @ClassName ClientThread.java
 * @Description
 * @createTime 2021年07月14日 17:36:00
 */
public class ClientReceiveThread implements Runnable{
    private Socket socket;

    public ClientReceiveThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //在这里 可以自动关闭socket 如果再手动关闭 会报错
        while (true){
            try ( BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));){
                String str = null;
                while ((str = br.readLine()) != null){
                    System.out.println(str);
                }
//           socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
