package com.tools.hutool.utils.print;

import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Method;

/**
 * @author huxingxin
 * @createTime 2021年07月31日 23:17:17
 * @Description
 */
public class LogUtil {
    private String commentValue="";//记录注解内容
    private Class aClass;

    public LogUtil(Class aClass){
        this.aClass = aClass;
    }

    /**
     * 对输出格式进行格式化
     * @param str1
     * @param obj1
     * @param str2
     * @param obj2
     */
    public void formatPrint(String str1, Object obj1,String str2, Object obj2){

        //该线程堆栈转储的堆栈跟踪元素数组  StackTraceElement 数组，每个数组代表一个堆栈帧
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        /**
         * [0]getStackTrace
         * [1]getMethodName
         * [2]info
         * [3]isHexNumber
         * ......
         */
        //根据index 获取方法名称
        String methodName = stackTrace[2].getMethodName();

        Method method = ReflectUtil.getMethod(aClass, methodName);
        Comment annotation = method.getAnnotation(Comment.class);
        String value = annotation.value();

        //多次调用 对同一注解内容只打印一次
        if(!commentValue.equals(value)){
            //输出打印调用方法的注解内容
            System.out.printf("%s\n\n",value);
            commentValue = value;//记录上次打印的注解内容
        }

        //格式化输出格式
        System.out.printf("基于 %s: %s\n",str1,obj1);
        System.out.printf("获取 %s: %s\n\n",str2,obj2);
    }

}
