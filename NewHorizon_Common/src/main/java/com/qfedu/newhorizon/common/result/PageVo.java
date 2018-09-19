package com.qfedu.newhorizon.common.result;

import java.util.List;

public class PageVo<T> {
    private int code;
    private String msg;
    private Integer count;
    private List<T> data;


    public static <T>  PageVo<T> createPage(List<T> data, Integer count){
        PageVo<T> pageVo=new PageVo<>();
        pageVo.setCode(0);
        pageVo.setMsg("OK");
        pageVo.setCount(count);
        pageVo.setData(data);
        return pageVo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
