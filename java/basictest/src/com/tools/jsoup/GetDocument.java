package com.tools.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author huxingxin
 * @createTime 2021年07月30日 22:59:08
 * @Description
 */
public class GetDocument {
    public static void main(String[] args) throws IOException {
        urlDoc();
    }

    /**
     * 基于字符串方式得到的Document对象
     */
    public static void strDoc(){
        String docStr = "<html><body><p>Hello HTML</p></body></html>";
        Document document = Jsoup.parse(docStr);
        System.out.println("基于字符串方式得到的 Document:\r\n" + document);
    }

    /**
     * 基于文件方式得到的Document对象
     * @throws IOException
     */
    public static void fileDoc() throws IOException {
        //当前项目所在路径
        String path = GetDocument.class.getResource("/").getPath();
        path = path + "com/tools/jsoup/a.html";
        File file = new File(path);
        Document document = Jsoup.parse(file,"utf-8");
        System.out.println("基于文件方式得到的 Document:\r\n" + document);
    }

    /**
     * 基于URL方式得到的Document对象
     * @throws IOException
     */
    public static void urlDoc() throws IOException {
        String url = "https://www.baidu.com";
        Document document = Jsoup.parse(new URL(url), 5000);
        System.out.println("基于URL方式得到的 Document:\r\n" + document);
    }
}
