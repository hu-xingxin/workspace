package com.basictest.io.newio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author huxingxin
 * @date 2021/4/12 14:03
 * @Description:
 */
public class RandomFileChannelTest {
    public static void main(String[] args) {
        FileChannel randomChannel = null;
        String copyPath="E:\\tmp\\file\\channel.txt";
        File file = new File(copyPath);
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            randomChannel = raf.getChannel();
            MappedByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            randomChannel.position(file.length());
            randomChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (randomChannel!=null){
                try {
                    randomChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
