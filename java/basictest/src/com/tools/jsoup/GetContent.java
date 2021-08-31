package com.tools.jsoup;

import com.sun.deploy.security.CertType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 * @author huxingxin
 * @createTime 2021年07月30日 23:31:58
 * @Description 获取内容和文本
 */
public class GetContent {
    public static void main(String[] args) throws IOException {
        String path = GetContent.class.getResource("").getPath();

        File file = new File(path + "b.html");

        Document document = Jsoup.parse(file, "UTF-8");
        Element element = document.getElementById("d1");

        //获取属性 d1
        System.out.println(element.attr("id"));

        //获取所有属性 id="d1" class="c1 c2"
        System.out.println(element.attributes());

        //获取id d1
        System.out.println(element.id());

        //获取类名 c1 c2
        System.out.println(element.className());

        //获取所有类名 [c1, c2]
        System.out.println(element.classNames());

        //获取文本 let us study java
        System.out.println(element.text());

        //获取html <a href="how2j.cn">study java</a>
        System.out.println(element.html());

        //获取外html
        /**
         * <div id="d1" class="c1 c2">
         *  let us
         *  <a href="how2j.cn">study java</a>
         * </div>
         */
        System.out.println(element.outerHtml());

        //获取标签信息 div
        System.out.println(element.tagName());
    }
}
