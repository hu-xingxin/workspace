package com.basictest.jihe.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created in 2021/3/9 19:56
 *
 * @author: huxingxin
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection list = new ArrayList();
        list.add("hello");
        list.add("java");
        Collection set = new HashSet();
        set.add("hello");
        set.add("word");
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
//        set.remove("1");
//        set.removeAll(set);
//        set.retainAll(list);

//        System.out.println(list);
//        System.out.println(set);

//        String[] strings = new String[10];
//        set.toArray(strings);
//        System.out.println(strings[1]);

//        Collection list1 = new ArrayList();
//        System.out.println(list1.isEmpty());

        System.out.println(list.contains("hello"));
        System.out.println(list.containsAll(set));

    }
}
