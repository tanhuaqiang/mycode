package com.dalingjia.test;

import org.junit.Test;

public class Page implements Cloneable {
    public static int DEFAULT_PAGESIZE = 20;
    public static int DEFAULT_PAGE = 1;
    private int pageNo;
    private int pageSize;
    private int totalCount;
    private int totalPageCount;

    public Page() {
        this.pageNo = DEFAULT_PAGE;
        this.pageSize = DEFAULT_PAGESIZE;
        this.totalCount = -1;
        this.totalPageCount = 1;
    }

    public Page(Integer pageNo) {
        this.pageNo = DEFAULT_PAGE;
        this.pageSize = DEFAULT_PAGESIZE;
        this.totalCount = -1;
        this.totalPageCount = 1;
        this.pageNo = pageNo;
        this.pageSize = DEFAULT_PAGESIZE;
    }

    public Page(Integer pageNo, Integer pageSize) {
        this.pageNo = DEFAULT_PAGE;
        this.pageSize = DEFAULT_PAGESIZE;
        this.totalCount = -1;
        this.totalPageCount = 1;
        this.pageNo = pageNo;
        this.pageSize = pageSize == null ? DEFAULT_PAGESIZE : pageSize;
    }

    public Page(Integer pageNo, Integer pageSize, Integer totalCount) {
        this.pageNo = DEFAULT_PAGE;
        this.pageSize = DEFAULT_PAGESIZE;
        this.totalCount = -1;
        this.totalPageCount = 1;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public int getStart() {
        return this.pageNo >= 0 && this.pageSize >= 0 ? (this.pageNo - 1) * this.pageSize : -1;
    }

    public int getTotalPageCount() {
        this.calculateTotalPageCount();
        return this.totalPageCount;
    }

    public void calculateTotalPageCount() {
        this.totalPageCount = this.totalCount / this.pageSize;
        if (this.totalCount % this.pageSize > 0) {
            ++this.totalPageCount;
        }

        if (this.pageNo > this.totalPageCount) {
            this.pageNo = this.totalPageCount;
        }

        if (this.pageNo < 1) {
            this.pageNo = 1;
        }

    }

    public boolean isHasNextPage() {
        return this.pageNo + 1 <= this.getTotalPageCount();
    }

    public int getNextPage() {
        return this.isHasNextPage() ? this.pageNo + 1 : this.pageNo;
    }

    public boolean isHasPrePage() {
        return this.pageNo - 1 >= 1;
    }

    public int getPrePage() {
        return this.isHasPrePage() ? this.pageNo - 1 : this.pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(int page) {
        this.pageNo = page;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.calculateTotalPageCount();
    }

    public Object clone() {
        Object page = null;

        try {
            page = super.clone();
        } catch (CloneNotSupportedException var3) {
            ;
        }

        return page;
    }


    @Test
    public void jjl(String[] args) {
        Page p = new Page(null, null, 0);
        System.out.println(p);
    }
}
