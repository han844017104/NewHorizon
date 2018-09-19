package com.qfedu.newhorizon.service.news;

import com.qfedu.newhorizon.common.result.R;
import org.apache.ibatis.annotations.Param;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/18  16:58
 */
public interface NewsService {
    R selectByType(Integer type);

    R selectByPage(@Param("page")Integer page, @Param("limit")Integer limit, @Param("type")Integer type);

    R selectById(Integer nid);

    R selectAll();

    R selectFather();

    R selectNewDetail(Integer nid);
}
