package com.qfedu.newhorizon.service.search;

import com.qfedu.newhorizon.domain.news.NewESVO;

import java.util.List;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/20  17:20
 */
public interface NewsSearchService {

    List<NewESVO> queryByName(String name);

}
