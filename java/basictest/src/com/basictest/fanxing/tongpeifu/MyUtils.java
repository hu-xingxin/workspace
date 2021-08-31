package com.basictest.fanxing.tongpeifu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created in 2021/3/11 21:48
 *
 * @author: huxingxin
 */
public class MyUtils {
    public static <T> T copy(Collection<? super T> dest,Collection<T> src){
        T lastEle = null;
        for (T ele:src) {
            lastEle = ele;
            dest.add(ele);
        }
        return lastEle;
    }

    public static void main(String[] args) {
         List<Number> numberList = new ArrayList<>();

         List<Integer> integerList = new ArrayList<>();
         integerList.add(1);
         integerList.add(2);
         integerList.add(3);

        MyUtils.copy(numberList,integerList);

        System.out.println(integerList);
    }
}


