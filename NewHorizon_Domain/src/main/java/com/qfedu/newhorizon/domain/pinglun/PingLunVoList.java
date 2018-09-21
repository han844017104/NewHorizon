package com.qfedu.newhorizon.domain.pinglun;

import java.util.List;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/19  19:09
 */
public class PingLunVoList {

    private PingLunVo father;

    private List<PingLunVo> childrens;

    public PingLunVo getFather() {
        return father;
    }

    public void setFather(PingLunVo father) {
        this.father = father;
    }

    public List<PingLunVo> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<PingLunVo> childrens) {
        this.childrens = childrens;
    }
}
