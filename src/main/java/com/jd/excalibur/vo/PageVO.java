package com.jd.excalibur.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<T> {

    private PageInf pageInf = new PageInf();
    private List<T> dataList;
    private Integer total;

    public PageVO(){
    }

    public PageVO(PageInf pageInf, List<T> dataList, Integer total) {
        this.pageInf = pageInf;
        this.dataList = dataList;
        this.total = total;
    }

}
