package com.basictest.innerclass.lamdba.hanshushi;

import java.util.function.Consumer;

/**
 * @author huxingxin
 * @ClassName ConsumerDemo.java
 * @Description 函数式接口  Consumer<T> 消费型接口
 * @createTime 2021年07月14日 23:07:00
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        String[] strArray = {"林青霞,30", "张曼玉,35", "王祖贤,33"};

        //将字符串数组里面的元素 拆分成姓名和年龄 分组打印
        printInfo(strArray,
                str -> System.out.print("姓名：" + str.split(",")[0]),
                str -> System.out.println("年龄：" + str.split(",")[1]));

    }

    public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2) {
        for (String str : arr) {
//            con1.accept(str);
//            con2.accept(str);
            con1.andThen(con2).accept(str);
        }
    }
}
