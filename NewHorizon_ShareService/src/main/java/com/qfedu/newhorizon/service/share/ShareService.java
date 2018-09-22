package com.qfedu.newhorizon.service.share;

import com.qfedu.newhorizon.common.result.R;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/21  21:04
 */
public interface ShareService {
    //分享到qq
    R shareToQQ(Integer nid);
    //分享到qq空间
    R shareToQZone(Integer nid);
}
