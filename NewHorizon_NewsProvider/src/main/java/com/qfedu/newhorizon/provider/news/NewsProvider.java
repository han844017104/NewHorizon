package com.qfedu.newhorizon.provider.news;

import com.qfedu.newhorizon.common.redis.RedisUtil;
import com.qfedu.newhorizon.mapper.news.NewMapper;
import com.qfedu.newhorizon.mapper.newtype.NewTypeMapper;
import com.qfedu.newhorizon.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/18  17:00
 */
@Service("newsServiceProvider")
public class NewsProvider implements NewsService {

    @Autowired
    private NewMapper nw;

    @Autowired
    private NewTypeMapper nt;

    @Autowired
    private RedisUtil ru;

}
