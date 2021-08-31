package com.servlet.demo2.app01.pojo;

/**
 * @author huxingxin
 * @createTime 2021年08月08日 23:26:15
 * @Description 订单实体类
 */
public class Order {
    private String name;
    private String address;
    private String cities;
    private String expresses;
    private String[] otherService;
    private String remark;

    public Order() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getExpresses() {
        return expresses;
    }

    public void setExpresses(String expresses) {
        this.expresses = expresses;
    }

    public String[] getOtherService() {
        return otherService;
    }

    public void setOtherService(String[] otherService) {
        this.otherService = otherService;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
