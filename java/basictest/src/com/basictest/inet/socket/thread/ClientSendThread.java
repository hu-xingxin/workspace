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
public class ClientSendThread implements Runnable{
    private Socket socket;

    public ClientSendThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //在这里 可以自动关闭socket 如果再手动关闭 会报错
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));){
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                bw.write(line);
                bw.newLine();
                bw.flush();//不刷新 scanner会一直阻塞
            }
//           socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
