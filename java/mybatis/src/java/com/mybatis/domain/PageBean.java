package com.mybatis.domain;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-19 11:15
 **/
public class PageBean {
    private Integer currentPage;//当前页数
    private Integer pageSize;//当前每页数据条数
    private Integer totalCount;//总条数
    private Integer totalPage;//总页

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        this.totalPage =(int)Math.ceil(this.totalCount*1.0/this.pageSize);
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

}
