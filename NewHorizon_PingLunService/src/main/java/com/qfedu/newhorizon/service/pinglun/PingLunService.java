package com.qfedu.newhorizon.service.pinglun;

import com.qfedu.newhorizon.common.result.PageVo;
import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.domain.pinglun.Pinglun;

import java.util.List;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/19  19:20
 */
public interface PingLunService {
    //分页查询评论,最新评论20个
    public List<Pinglun> selectNewPinglun(Integer nid, Integer page, Integer limit);
    //点赞
    public R addLike(Integer uid,Integer plid);
}
