package com.qfedu.newhorizon.dao;

import com.qfedu.newhorizon.domain.news.New;
import com.qfedu.newhorizon.domain.news.NewESVO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/20  17:14
 */
public interface NewsSearchDao extends ElasticsearchRepository<NewESVO,Integer> {
}
