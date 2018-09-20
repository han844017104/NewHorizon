package com.qfedu.newhorizon.provider.search;

import com.qfedu.newhorizon.dao.NewsSearchDao;
import com.qfedu.newhorizon.domain.news.NewESVO;
import com.qfedu.newhorizon.service.search.NewsSearchService;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/20  17:22
 */
@Service
public class NewsSearchProvider implements NewsSearchService {

    @Autowired
    private NewsSearchDao nsd;

    @Override
    public List<NewESVO> queryByName(String name) {
        QueryBuilder qb = QueryBuilders.wildcardQuery("title", "*" + name + "*");
        Iterator<NewESVO> it = nsd.search(qb,new PageRequest(0,10)).iterator();
        List ret = new ArrayList();
        while (it.hasNext()){
            ret.add(it.next());
        }
        return ret;
    }

    @Override
    public List<NewESVO> queryOnceClike() {
        //TODO
        return null;
    }
}
