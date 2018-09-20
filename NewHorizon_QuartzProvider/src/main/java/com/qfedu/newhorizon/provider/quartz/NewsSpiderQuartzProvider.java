package com.qfedu.newhorizon.provider.quartz;

import com.qfedu.newhorizon.mapper.news.NewMapper;
import com.qfedu.newhorizon.mapper.newtype.NewTypeMapper;
import com.qfedu.newhorizon.service.quartz.NewsSpiderQuartzService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/20  22:20
 */
public class NewsSpiderQuartzProvider implements NewsSpiderQuartzService {

    @Autowired
    private NewMapper nm;

    @Autowired
    private NewTypeMapper nt;

    @Override
    public void startNewSpider(Integer num) {


    }
}
