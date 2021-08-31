package com.basictest.inet.fileSocket.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author huxingxin
 * @ClassName ReadFile.java
 * @Description
 * @createTime 2021年07月14日 10:22:00
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",12345);
        String filePath = "F:\\code\\workspace\\java\\basictest\\src\\com\\basictest\\inet\\fileSocket\\datagram\\ReadFile.java";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));){
            String str = null;
            while ((str = br.readLine()) != null){
                bw.write(str+"\r\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
;