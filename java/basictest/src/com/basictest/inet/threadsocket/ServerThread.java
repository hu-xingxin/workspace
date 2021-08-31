package com.basictest.inet.threadsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author huxingxin
 * @date 2021/4/14 16:26
 * @Description:
 */
public class ServerThread implements Runnable {

    Socket s = null;
    BufferedReader br = null;

    public ServerThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        String content = null;
        while ((content=readFromClient())!=null){
            for (Socket socket : MyServer.socketList){
                try {
                    PrintStream printStream = new PrintStream(socket.getOutputStream());
                    printStream.println(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String readFromClient(){
        try {
            return br.readLine();
        } catch (IOException e) {
            MyServer.socketList.remove(s);
            System.out.println(e.getMessage());
        }
        return null;
    }
}
