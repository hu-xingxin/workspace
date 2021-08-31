package com.basictest.inet.threadsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author huxingxin
 * @date 2021/4/14 16:32
 * @Description:
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 30000);
        new Thread(new ClientThread(socket)).start();
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        String line = null;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while ((line = bufferedReader.readLine())!=null){
            printStream.println(line);
        }

    }
}
