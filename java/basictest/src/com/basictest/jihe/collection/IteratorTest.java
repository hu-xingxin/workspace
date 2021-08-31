package com.basictest.jihe.collection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created in 2021/3/9 20:35
 *
 * @author: huxingxin
 */
public class IteratorTest {
    public static void main(String[] args) throws IOException {
        Collection list = new ArrayList();
        list.add("hello");
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);

//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            Object next = iterator.next();
//            iterator.remove();
//            System.out.println(next);
//        }
//        System.out.println(list);

//        for (Object object:list) {
//            System.out.println(object);
//            list.remove(object);
//        }
        list.remove("hello");
        System.out.println(list);
    }
}
