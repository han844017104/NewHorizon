package com.qfedu.newhorizon.service.pinglun;


import com.qfedu.newhorizon.common.result.PageVo;
import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.domain.pinglun.PingLunMain;
import com.qfedu.newhorizon.domain.pinglun.Pinglun;

import java.util.List;


import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.domain.pinglun.Pinglun;


/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/19  19:20
 */
public interface PingLunService {
    //分页查询评论,最新评论20个
    List<Pinglun> selectNewPinglun(Integer nid, Integer page, Integer limit);
    //点赞
    R addLike(Integer uid,Integer plid);

    R insert(Pinglun pinglun);


    R selectHot(Integer nid,Integer minlikenum, Integer limit);

    R selectNew( Integer nid, Integer page,Integer limit);


    R addReply(PingLunMain pingLunMain);
}
