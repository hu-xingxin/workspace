package com.basictest.annotation.tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created in 2021/4/7 10:13
 *
 * @author: huxingxin
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTag{
    int index() default 1;
    String name() default "test";
}
