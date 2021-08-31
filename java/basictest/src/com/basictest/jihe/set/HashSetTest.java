package com.basictest.jihe.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created in 2021/2/22 17:02
 *
 * @description:
 * @Author: huxingxin
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set hashSet = new HashSet();
        hashSet.add(new A());
        hashSet.add(new A());
        hashSet.add(new B());
        hashSet.add(new B());
        hashSet.add(new C());
        hashSet.add(new C() );
        System.out.println(hashSet);
    }
}
