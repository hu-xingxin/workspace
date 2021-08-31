
package com.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author huxingxin
 * @ClassName Server.java
 * @Description
 * @createTime 2021年07月16日 09:48:00
 */
public class Server {
    public static final String WEBROOT = System.getProperty("user.dir") + "\\" + "WebContent";
    public static String uri;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket accept = serverSocket.accept();
            parse(accept.getInputStream());
            sendStaticResource(accept.getOutputStream());
        }
    }

    public static void parse(InputStream input) throws IOException {
        StringBuffer content = new StringBuffer(2048);
        int i;

        byte[] buffer = new byte[2048];
        // 读取客户端发送过来的数据,将数据读取到字节数组buffer中.
        //i代表读取数据量的大小 311字节
        i = input.read(buffer);


        for (int j = 0; j < i; j++) {
            content.append((char) buffer[j]);
        }
        // 打印读取到的内容
//        System.out.print(content.toString());
//         截取客户端要请求的资源路径 demo.html
        uri = parseUri(content.toString());

        // 赋值给本类中静态成员
//        url = uri;
        System.out.println("uri..............:"+uri);
    }

    // 截取客户端请求资源的路径+名称     /demo.html
    public static String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1)
                return requestString.substring(index1+2, index2);
        }
        return null;
    }


    public static void sendStaticResource(OutputStream output) throws IOException {
        byte[] bytes = new byte[2048];
        FileInputStream fis = null;
        try {
            //cc.jpeg
            File file = new File(WEBROOT, uri);
            if (file.exists()) {
                output.write("HTTP/1.1 200 OK\n".getBytes());
                output.write("Server: Apache-Coyote/1.1\n".getBytes());
                output.write("Content-Type: text/html;charset=UTF-8\n"
                        .getBytes());
                output.write("\n".getBytes());

                try (BufferedWriter socketBw = new BufferedWriter(new OutputStreamWriter(output));
                     BufferedReader fileBr = new BufferedReader(new FileReader(file));){
                    String line;
                    while ((line=fileBr.readLine()) != null){
                        socketBw.write(line);
                        socketBw.newLine();
                        socketBw.flush();
                    }
                }catch (Exception e){

                }

            } else {
                // file not found
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
                        + "Content-Type: text/html\r\n"
                        + "Content-Length: 23\r\n" + "\r\n"
                        + "<h1>File Not Found</h1>";
                output.write(errorMessage.getBytes());
            }
        } catch (Exception e) {
            // thrown if cannot instantiate a File object
            e.printStackTrace();
            System.out.println(e.toString());
        } finally {
            if (fis != null)
                fis.close();
        }
    }


}
