package com.spring.demo1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huxingxin
 * @createTime 2021年08月08日 23:26:15
 * @Description 订单实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String name;
    private String address;
    private String cities;
    private String expresses;
    private String[] otherService;
    private String remark;
}
