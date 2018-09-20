package com.qfedu.newhorizon.domain.pinglun;

import java.util.List;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/19  19:09
 */
public class PingLunVoList {

    private PingLunVo pinglun;

    private List<PingLunVo> fathers;

    public PingLunVo getPinglun() {
        return pinglun;
    }

    public void setPinglun(PingLunVo pinglun) {
        this.pinglun = pinglun;
    }

    public List<PingLunVo> getFathers() {
        return fathers;
    }

    public void setFathers(List<PingLunVo> fathers) {
        this.fathers = fathers;
    }
}
