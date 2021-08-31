package com.springboot.demo1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author huxingxin
 * @createTime 2021年08月13日 01:06:21
 * @Description
 */
@Data
public class Person {
    private String userName;
    private Integer age;
    private char sex;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM-8")
    private Date birthday;
    private String idCard;
}
