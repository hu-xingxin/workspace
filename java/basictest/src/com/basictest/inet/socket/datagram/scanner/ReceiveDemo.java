package com.basictest.inet.socket.datagram.scanner;

import com.basictest.utils.LogUtil;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author huxingxin
 * @createTime 2021年07月28日 20:42:09
 * @Description UDP通信 发送数据 在控制台输入
 */
public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //1.创建socket，用来发送和接收数据包
        DatagramSocket datagramSocket = new DatagramSocket(12345);
        Scanner scanner = new Scanner(System.in);
        //2.创建数据包，用来接收客户端发送的数据和ip，端口
        byte[] buffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

        //接收客户端的信息
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    //3.接收socket和数据包来接收客户端的信息
                    try {
                        datagramSocket.receive(receivePacket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //4.输出客户端发来的信息
                    LogUtil.log("收到数据: " + new String(receivePacket.getData(), 0, receivePacket.getData().length));
                }
            }
        }).start();

        //发送消息
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        //5.给客户端发送消息
                        String line = scanner.nextLine();
                        byte[] bytes = line.getBytes();
                        InetAddress ip = InetAddress.getByName("127.0.0.1");
                        DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length, ip, 12346);
                        datagramSocket.send(sendPacket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



    }
}
