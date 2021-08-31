package com.tools.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author huxingxin
 * @createTime 2021年07月30日 20:28:10
 * @Description jsoup测试
 */
public class Test {
    public static void main(String[] args) {
        String xmlStr = "<html><body><p>Hello HTML</p></body></html>";
        //获取Document
        Document document = Jsoup.parse(xmlStr);
        //获取Elements
        Elements elements = document.getElementsByTag("p");
        for (Element element : elements){
            System.out.println(element.text());
        }
    }
}
