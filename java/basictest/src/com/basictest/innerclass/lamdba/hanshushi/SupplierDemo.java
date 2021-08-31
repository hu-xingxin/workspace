package com.basictest.innerclass.lamdba.hanshushi;

import java.util.function.Supplier;

/**
 * @author huxingxin
 * @ClassName MaxValue.java
 * @Description 函数式接口  Supplier<T> 供给型
 * @createTime 2021年07月14日 22:45:00
 */
public class SupplierDemo {
    public static void main(String[] args) {
        int[] intArr = {10,23,45,5,6,9,0,33};

        //获取int数组里面的最大值
        int maxNUm = getMax(() -> {
            int max = intArr[0];
            for (int i : intArr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });

        System.out.println(maxNUm);

    }

    public static int getMax(Supplier<Integer> supplier){
        return supplier.get();
    }
}
