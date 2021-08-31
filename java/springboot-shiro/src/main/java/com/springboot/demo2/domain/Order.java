package com.springboot.demo2.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author huxingxin
 * @createTime 2021年08月13日 00:28:57
 * @Description  @Value 可以从配置文件中取值赋给Order  也可以直接赋值给Order
 */
@Data
@Component
public class Order {
    @Value("${user.user-name}")
    private String userName;
    @Value("南京")
    private String address;
    @Value("23.12")
    private String price;
    private String cities;
    private String expresses;
    private String[] otherService;
    private String remark;
}
