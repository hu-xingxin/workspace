package com.basictest.inet.fileSocket.datagram;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author huxingxin
 * @ClassName ReceiveFile.java
 * @Description 接收数据，进行解析，写入文件
 * @createTime 2021年07月14日 09:46:00
 */
public class ReceiveFile {
    public static void main(String[] args) throws IOException, InterruptedException {
        String filePath = "E:\\tmp\\properties\\ReadFile.java";

        //构建套接字
        DatagramSocket ds = new DatagramSocket(12346);
        //
        while (true){
            //构建数据包，用于接收数据
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            //接收数据
            ds.receive(dp);

            //解析数据包，写入文件
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true))){
                String s = new String(dp.getData(), 0, dp.getLength());
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
