package com.tomcat;

import jdk.jfr.events.ExceptionThrownEvent;

import java.io.*;
import java.net.Socket;

/**
 * @author huxingxin
 * @ClassName Client.java
 * @Description
 * @createTime 2021年07月16日 09:21:00
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("www.itcast.cn",80);
        try(BufferedReader br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream os = socket.getOutputStream();
            BufferedWriter fileBw = new BufferedWriter(new FileWriter("E:\\tmp\\properties\\tomcat.html"))){

            os.write("GET /subject/about/index.html HTTP/1.1\n".getBytes());
            os.write("HOST:www.itcast.cn\n".getBytes());
            os.write("\n".getBytes());

            String line = null;
            while((line = br.readLine()) != null){
                fileBw.write(line);
                fileBw.newLine();
                System.out.println(line);
            }
        }catch (Exception e){

        }

        System.out.println("--------------");
    }
}
