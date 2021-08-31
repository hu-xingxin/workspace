package com.tools.hutool.utils.print;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * @author huxingxin
 * @createTime 2021年07月31日 23:14:48
 * @Description
 */
@Target({METHOD,TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Comment{
    String value();
}
