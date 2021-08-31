package com.basictest.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created in 2021/3/10 20:15
 *
 * @author: huxingxin
 */


class Animal<T>{
    private T param;

    public Animal(){

    }

    public Animal(T param){
        this.param = param;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public void getList(List<?> list){
        for (Object a:list) {
            System.out.println(a);
        }
    }

    public <T> void add(T[] a, List<T> b){
        for (T c:a) {
            b.add(c);
        }
    }
}

public class Demo{
    public static void main(String[] args) {
         Animal hello = new Animal("hello");
         List<String> list = new ArrayList<>();
         String[] arr ={"1","2","3","4"};
         hello.add(arr,list);
        System.out.println(list);
//         list.add("1");
//         list.add("1");
//         list.add("1");
//         hello.getList(list);

    }


}
