package com.jd.excalibur.vo;

import lombok.Data;

@Data
public class PageInf {

    private Integer index = 1;
    private Integer size = 10;


    public PageInf(){
    }

    public PageInf(Integer index, Integer size, Integer total) {
        this.index = index;
        this.size = size;
    }

}
