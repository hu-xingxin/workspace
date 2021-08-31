package com.basictest.inet.fileSocket.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author huxingxin
 * @ClassName ReceiveFile.java
 * @Description
 * @createTime 2021年07月14日 10:27:00
 */
public class ReceiveFile {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket accept = serverSocket.accept();

        byte[] bytes = new byte[1024];
        String filePath = "E:\\tmp\\properties\\ReadFile.java";
        InputStream is = accept.getInputStream();
        int hasRead = 0;
        while ((hasRead = is.read(bytes)) != -1){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,true)))
            {
                bw.write(new String(bytes,0,hasRead)+"\r\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        accept.close();
    }
}
