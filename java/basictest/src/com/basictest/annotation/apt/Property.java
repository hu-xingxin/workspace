package com.basictest.annotation.apt;

import java.lang.annotation.*;

/**
 * Created in 2021/4/8 9:05
 *
 * @author: huxingxin
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface Property {
    String column();
    String type();
}
