package com.basictest.inet.socket.datagram.scanner;

import com.basictest.utils.LogUtil;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author huxingxin
 * @createTime 2021年07月28日 20:42:09
 * @Description UDP通信 发送数据 在控制台输入
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        //1.创建Socket用于发送和接收数据
        DatagramSocket datagramSocket = new DatagramSocket(12346);

        //发送数据
        Scanner scanner = new Scanner(System.in);

        //发送数据报
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        String line = scanner.nextLine();
                        byte[] bytes = line.getBytes();
                        InetAddress ip = null;
                        ip = InetAddress.getByName("127.0.0.1");
                        //2.创建数据包，用来存储
                        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, ip,12345);
                        //3.发送数据报
                        datagramSocket.send(datagramPacket);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        //接收客户端的信息
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        //4.接收服务端数据
                        byte[] buffer = new byte[1024];
                        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                        datagramSocket.receive(receivePacket);
                        LogUtil.log("收到数据: " + new String(receivePacket.getData(), 0, receivePacket.getData().length));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
