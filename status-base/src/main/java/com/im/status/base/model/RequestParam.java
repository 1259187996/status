package com.im.status.base.model;

import java.io.Serializable;

/**
 * 查询基础参数
 * @author zhizhuang.yang
 * @date 2017年9月8日
 * @version 1.0.0
 * @description 查询基础参数
 */
public class RequestParam implements Serializable{

    private final static long serialVersionUID = 1L;

    private Integer pageIndex = 1;

    private Integer pageSize = Integer.MAX_VALUE;

    /**
     * 返回行数
     * @return
     */
    public Integer getLimitOffset(){
        return this.pageSize;
    }

    /**
     * 返回第几条开始
     * @return
     */
    public Integer getLimitRows(){
        return (this.pageIndex-1)*this.pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
