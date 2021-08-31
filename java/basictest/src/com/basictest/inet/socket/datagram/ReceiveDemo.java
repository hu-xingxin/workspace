package com.basictest.inet.socket.datagram;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author huxingxin
 * @ClassName Receive.java
 * @Description UDP通信 接收数据
 * @createTime 2021年07月13日 21:19:00
 */
public class ReceiveDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        //创建套接字
        DatagramSocket datagramSocket = new DatagramSocket(12346);

        //用死循环让通信处于一直阻塞状态 直到接收到数据
        while (true){
            //创建一个数据包 用于接收数据
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            System.out.println("等待接收数据...");
            //调用receive方法接收数据
            datagramSocket.receive(datagramPacket);//该方法一直阻塞 直到接收到数据
            System.out.println("收到数据...");
            //解析数据包，并把数据在控制台打印
            System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        }
    }
}
