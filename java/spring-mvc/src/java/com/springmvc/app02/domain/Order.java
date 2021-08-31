package com.springmvc.app02.domain;

/**
 * @author huxingxin
 * @createTime 2021年08月11日 22:36:03
 * @Description
 */
public class Order {
    private String name;
    private String address;
    private String cities;
    private String expresses;
    private String[] otherService;
    private String remark;

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
