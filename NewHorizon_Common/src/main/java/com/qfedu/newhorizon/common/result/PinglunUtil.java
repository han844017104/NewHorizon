package com.qfedu.newhorizon.common.result;

import com.qfedu.newhorizon.domain.pinglun.PingLunVo;
import com.qfedu.newhorizon.domain.pinglun.PingLunVoList;

import java.util.ArrayList;
import java.util.List;

public class PinglunUtil {
    public static List<PingLunVoList> toList( List<PingLunVo> pingLunVos) {
        List<PingLunVoList> pingLunVoLists = new ArrayList<>();
        if (pingLunVos != null && pingLunVos.size() > 0) {
            for (PingLunVo p : pingLunVos) {
                PingLunVoList pingLunVoList = new PingLunVoList();
                if (p.getFatherid() == -1) {
                    pingLunVoList.setFather(p);
                    pingLunVoLists.add(pingLunVoList);
                } else {
                    for (PingLunVoList l : pingLunVoLists) {
                        if (l.getFather().getFatherid() == p.getFatherid()) {
                            l.getChildrens().add(p);
                        }
                    }
                }
            }

        }
        return pingLunVoLists;
    }
}
