package com.basictest.io.io;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created in 2021/4/8 21:15
 *
 * @author: huxingxin
 */
public class StringNodeTest {
    public static void main(String[] args) {
        String str = "纤云弄巧，飞星传恨，银汉迢迢暗度。金风玉露一相逢，便胜却人间无数。\n" +
                "柔情似水，佳期如梦，忍顾鹊桥归路！两情若是久长时，又岂在朝朝暮暮。";
        StringReader sr = new StringReader(str);
        char[] buffer = new char[32];
        int hasRead = 0;
        try{
            while((hasRead=sr.read(buffer))!=-1){
                System.out.println(new String(buffer,0,hasRead));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (sr!=null){
                sr.close();
            }
        }

        StringWriter sw = new StringWriter();
        sw.write("纤云弄巧，飞星传恨，银汉迢迢暗度。金风玉露一相逢，便胜却人间无数。\n");
        sw.write("柔情似水，佳期如梦，忍顾鹊桥归路！两情若是久长时，又岂在朝朝暮暮。");
        System.out.println(sw.toString());
    }
}
