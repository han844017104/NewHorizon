package com.qfedu.newhorizon.service.pinglun;

import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.domain.pinglun.Pinglun;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/19  19:20
 */
public interface PingLunService {
    R insert(Pinglun pinglun);


    R selectHot(Integer nid,Integer minlikenum, Integer limit);

    R selectNew( Integer nid, Integer page,Integer limit);


}
