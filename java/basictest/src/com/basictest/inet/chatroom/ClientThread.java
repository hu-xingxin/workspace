package com.basictest.inet.chatroom;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-13 09:06
 **/
public class ClientThread extends Thread{
    BufferedReader br = null;

    public ClientThread(BufferedReader br){
        this.br = br;
    }

    public void run(){
        String line = null;
        try{
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
                try {
                    if(br != null){
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
