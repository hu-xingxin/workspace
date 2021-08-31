package com.basictest.inet.postandget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author huxingxin
 * @date 2021/4/14 15:12
 * @Description:
 */
public class TestPostGet {
    /**
     * Get 请求
     * @param url
     * @param param
     * @return
     */
    public static String sendGet(String url, String param){
        String result = "";
        BufferedReader in = null;
        String urlName = url + "?" + param;
        try {
            URL realUrl = new URL(urlName);
            //打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0; Windows NT 5.1; SV1)");
            //建立连接
            conn.connect();

            //获取所有响应头字段
            Map<String, List<String>> headerFields = conn.getHeaderFields();
            //遍历
            for (String key : headerFields.keySet()){
                System.out.println(key + "--->" + headerFields.get(key));
            }

            //读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line=in.readLine())!=null){
                result += "\n" + line;
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("发送get请求出现异常!" + e);
            e.printStackTrace();
        }finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static String sendPost(String url, String param){
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        try {
            URL realUrl = new URL(url);
            //打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0; Windows NT 5.1; SV1)");

            conn.setDoInput(true);//需要读取输入流 默认为true
            conn.setDoOutput(true);//需要使用URL进行输出 默认为false

            //传参
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();

            //读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line=in.readLine())!=null){
                result += "\n" + line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (out != null) {
                    in.close();
                }
                if (in != null){
                    out.close();
                }

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
