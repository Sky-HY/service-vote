package com.vote.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果的包装类
 */
public class PageResult {

    // 当前页
    private Integer page;
    // 总条数
    private Long count;
    // 当前页的数据集合
    private List<Object> data = new ArrayList<>();

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
