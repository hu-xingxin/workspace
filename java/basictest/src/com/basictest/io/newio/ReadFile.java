package com.basictest.io.newio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author huxingxin
 * @date 2021/4/12 14:11
 * @Description:
 */
public class ReadFile {
    public static void main(String[] args) {
        FileChannel fileChannel = null;
        try {
            String copyPath="E:\\tmp\\file\\channel.txt";
            FileInputStream fis = new FileInputStream(copyPath);
            fileChannel = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(buffer) != -1){
                buffer.flip();
                Charset charset = Charset.forName("gb2312");
                CharsetDecoder charsetDecoder = charset.newDecoder();
                CharBuffer charBuffer = charsetDecoder.decode(buffer);
                System.out.println(charBuffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileChannel!=null){
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
