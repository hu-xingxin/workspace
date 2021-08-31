package com.basictest.inet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author huxingxin
 * @date 2021/4/14 10:32
 * @Description:
 */
public class URLDeEncoderTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //转码
        String urlStr = URLEncoder.encode("我爱你", "GBK");
        System.out.println(urlStr);

        //解码
        String keyWord = URLDecoder.decode(urlStr, "GBK");
        System.out.println(keyWord);
    }
}
