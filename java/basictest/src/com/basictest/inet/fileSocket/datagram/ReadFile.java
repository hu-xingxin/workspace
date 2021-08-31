package com.basictest.inet.fileSocket.datagram;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author huxingxin
 * @ClassName ReadFile.java
 * @Description 从文件中读取数据，发送
 * @createTime 2021年07月14日 09:18:00
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        //创建套接字
        DatagramSocket ds = new DatagramSocket();

        String filePath = "F:\\code\\workspace\\java\\basictest\\src\\com\\basictest\\inet\\fileSocket\\datagram\\ReadFile.java";
        //读取文件
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                //将读取到的数据构造成一个数据包
                byte[] bytes = str.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 12346);
                //发送数据
                ds.send(dp);
            }
            //发送完数据后，关闭发送端
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
