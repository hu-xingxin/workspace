package com.basictest.annotation.apt;

import jdk.nashorn.internal.ir.annotations.Reference;

import java.lang.annotation.*;

/**
 * Created in 2021/4/7 20:55
 *
 * @author: huxingxin
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface IdProperty {
    String column();
    String type();
    String generator();
}
