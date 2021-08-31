package com.basictest.inet.socket.datagram;

import com.basictest.utils.LogUtil;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author huxingxin
 * @ClassName SendDemo.java
 * @Description UDP通信 发送数据
 * @createTime 2021年07月13日 21:13:00
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        //创建套接字
        DatagramSocket datagramSocket = new DatagramSocket();

        //构建数据，并把数据打包
        String str = "hello,udp,i will coming,啦啦啦";
        byte[] bytes = str.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),12346);
        //用死循环，持续不断的发送数据
        while (true){
            //休眠一秒钟 每隔一秒钟发送一次数据
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //发送数据
            LogUtil.log("正在发送数据...");
            datagramSocket.send(datagramPacket);
            LogUtil.log("发送数据 " + str);
        }
//        datagramSocket.close();
    }
}
