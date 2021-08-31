package com.springboot.demo1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author huxingxin
 * @createTime 2021年08月12日 17:17:02
 * @Description 用ConfigurationProperties 获取配置文件中的值
 */
@Data
@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private String userName;
    private Integer age;
    private char sex;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM-8")
    private Date birthday;
    private String idCard;
}
