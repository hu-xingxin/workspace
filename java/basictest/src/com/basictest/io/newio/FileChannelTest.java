package com.basictest.io.newio;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created in 2021/4/10 15:45
 *
 * @author: huxingxin
 */
public class FileChannelTest {
    public static void main(String[] args) {
        FileChannel inChannel = null;
        FileChannel outChannel = null;


        String filePath = "F:\\workspace\\basictest\\src\\com\\basictest\\io\\io\\FileInputStreamTest.java";
        String copyPath="E:\\tmp\\file\\channel.txt";
        try {
            File file = new File(filePath);
            inChannel = new FileInputStream(file).getChannel();
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
            Charset charset = Charset.forName("GBK");
            outChannel = new FileOutputStream(copyPath).getChannel();
            outChannel.write(buffer);

            buffer.clear();
            CharsetDecoder charsetDecoder = charset.newDecoder();
            CharBuffer charBuffer = charsetDecoder.decode(buffer);
            System.out.println(charBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           try{
               if(inChannel!=null){
                   inChannel.close();
               }
               if(outChannel!=null){
                   outChannel.close();
               }
           }catch (IOException e){
               e.printStackTrace();
           }
        }
    }
}
