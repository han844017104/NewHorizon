package com.qfedu.newhorizon.common.result;

import java.io.Serializable;
import java.util.List;

public class RL implements Serializable {
    private Integer code;
    private String msg;
    private List data;

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

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public static RL creat (Integer code){
        RL rl = new RL();
        rl.setCode(code);
        return rl;
    }
    public static RL creat (Integer code,String msg){
        RL rl = new RL();
        rl.setCode(code);
        rl.setMsg(msg);
        return rl;
    }
    public static RL creat (Integer code,String msg,List data){
        RL rl = new RL();
        rl.setCode(code);
        rl.setMsg(msg);
        rl.setData(data);
        return rl;
    }
}
