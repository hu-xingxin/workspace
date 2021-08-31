package com.basictest.annotation.apt;

import java.lang.annotation.*;

/**
 * Created in 2021/4/7 20:53
 *  用于修饰持久化类
 * @author: huxingxin
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Persistent {
    String table();
}
