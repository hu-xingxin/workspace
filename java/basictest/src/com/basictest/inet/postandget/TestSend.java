package com.basictest.inet.postandget;

/**
 * @author huxingxin
 * @date 2021/4/14 15:33
 * @Description:
 */
public class TestSend {
    public static void main(String[] args) {
        TestPostGet.sendGet("https://image.baidu.com/search/albumslist",
                "tn=albumslist&word=设计素材&album_tab=设计素材&rn=15&fr=searchindex");
    }
}
