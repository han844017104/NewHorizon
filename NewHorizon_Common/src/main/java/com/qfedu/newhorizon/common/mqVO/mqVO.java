package com.qfedu.newhorizon.common.mqVO;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/22  10:18
 */
public class mqVO<T> {
    private Integer code;

    private T obj;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public mqVO(Integer code, T obj) {
        this.code = code;
        this.obj = obj;
    }

    public mqVO() {

    }
}
