package com.basictest.inet.threadsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author huxingxin
 * @date 2021/4/14 16:34
 * @Description:
 */
public class ClientThread implements Runnable {
    private Socket s;
    BufferedReader br = null;

    public ClientThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        String content = null;
        try {
            while ((content = br.readLine()) != null){
                System.out.println(content);
            }
        }catch (Exception e){
            e.getMessage();
        }
    }
}
