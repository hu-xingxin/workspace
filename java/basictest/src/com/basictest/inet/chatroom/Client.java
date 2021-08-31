package com.basictest.inet.chatroom;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-12 17:21
 **/
public class Client {
    private static final int SERVER_PORT = 30000;
    private Socket socket;
    private PrintStream ps;
    private BufferedReader brServer;
    private BufferedReader keyIn;

    public void init(){
        try {
            keyIn = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket("127.0.0.1", SERVER_PORT);
            ps = new PrintStream(socket.getOutputStream());
            brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String tip = "";
            while (true){
                String userName = JOptionPane.showInputDialog(tip + "输入用户名");
                ps.println(Protocol.USER_ROUND+userName+Protocol.USER_ROUND);
                String result = brServer.readLine();
                if(result.equals(Protocol.NAME_EMP)){
                    tip = "用户名重复! 请重新";
                    continue;
                }
                if(result.equals(Protocol.LOGIN_SUCCESS)){
                    break;
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("找不到远程服务器, 请确定服务器已经启动!");
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("网络异常! 请重新登录!");
            closeRs();
            System.exit(1);
        }
        new ClientThread(brServer).start();
    }

    private void readAndSend(){
        try {
            String line = null;
            while((line = keyIn.readLine())!=null){
                if(line.indexOf(":")>0 && line.startsWith("//")){
                    line = line.substring(2);
                    ps.println(Protocol.PRIVATE_ROUND +
                            line.split(":")[0] + Protocol.SPLIT_SIGN+
                            line.split(":")[1] + Protocol.PRIVATE_ROUND
                    );
                }else {
                    ps.println(Protocol.MSG_ROUND + line + Protocol.MSG_ROUND);
                }
            }
        } catch (IOException e) {
            System.out.println("网络异常! 请重新登录!");
            e.printStackTrace();
        }
    }

    private void closeRs(){
        try{
            if(keyIn != null){
                keyIn.close();
            }
            if(brServer != null){
                brServer.close();
            }
            if (ps != null){
                ps.close();
            }
            if(socket != null){
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.init();
        client.readAndSend();
    }
}
