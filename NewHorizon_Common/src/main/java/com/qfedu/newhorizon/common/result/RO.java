package com.qfedu.newhorizon.common.result;

import java.io.Serializable;

public class RO  implements Serializable {
    private Integer code;
    private String msg;
    private Object object;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public static RO creat(String msg){
        RO ro = new RO();
        ro.setMsg(msg);
        return ro;
    }
    public static RO creat(Integer code){
        RO ro = new RO();
        ro.setCode(code);
        return ro;
    }
    public static RO creat(Integer code,String msg){
        RO ro = new RO();
        ro.setMsg(msg);
        ro.setCode(code);
        return ro;
    }
    public static RO creat(Integer code,String msg,Object obj){
        RO ro = new RO();
        ro.setMsg(msg);
        ro.setCode(code);
        ro.setObject(obj);
        return ro;
    }


}
