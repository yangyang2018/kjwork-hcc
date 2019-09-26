package com.kj.comom.page;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/9/24 下午8:58
 * @description
 */
public class SimplePage<T> implements Serializable{

    private static final long serialVersionUID = -7024330226925199822L;

    private int page;

    private int pageSize;

    private int draw;

    private List<T> data;

    private int  totalCount;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
