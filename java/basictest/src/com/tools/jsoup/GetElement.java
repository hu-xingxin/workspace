package com.tools.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author huxingxin
 * @createTime 2021年07月30日 23:16:48
 * @Description 获取元素比较常见的几种方式： 通过id, 标签或者类名称获取
 */
public class GetElement {
    public static void main(String[] args) throws IOException {
        //当前类所在路径
        String path = GetElement.class.getResource("").getPath();
        path = path + "a.html";
        File file = new File(path);
        Document document = Jsoup.parse(file, "UTF-8");

        //通过id获取
        Element element = document.getElementById("hello");
        System.out.println(element);

        Elements elements;

        //通过标签获取
        elements = document.getElementsByTag("a");
        show(elements);

        //通过类名称获取
        elements = document.getElementsByClass("hello");
        show(elements);

        //通过属性获取
        elements = document.getElementsByAttribute("hello");
        show(elements);

    }

    /**
     * 遍历打印元素
     * @param elements
     */
    public static void show(Elements elements){
        for (Element e : elements) {
            System.out.println(e);
        }
    }
}
