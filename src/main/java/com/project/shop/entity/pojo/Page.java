package com.project.shop.entity.pojo;

import java.util.List;

public class Page<T> {
    private List<T> list;
    private long total;
    private int pageNum;
    private int pageSize;

    // getter setter
    public List<T> getList() { return list; }
    public void setList(List<T> list) { this.list = list; }
    public long getTotal() { return total; }
    public void setTotal(long total) { this.total = total; }
    public int getPageNum() { return pageNum; }
    public void setPageNum(int pageNum) { this.pageNum = pageNum; }
    public int getPageSize() { return pageSize; }
    public void setPageSize(int pageSize) { this.pageSize = pageSize; }
}