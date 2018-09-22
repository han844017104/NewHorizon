package com.qfedu.newhorizon.mapper.news;

import com.qfedu.newhorizon.domain.news.NewMain;
import com.qfedu.newhorizon.domain.news.NewPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewMapper {

    int savenew(@Param("tid") Integer typeid,@Param("text") String context,@Param("title") String title,@Param("createtime") String date);

    List<NewPage> selectByType(Integer type);

    List<NewPage> selectByPage(@Param("page")Integer page,@Param("limit")Integer limit,@Param("type")Integer type);

    int selectCount();

    NewMain selectById(Integer nid);

    NewMain selectNewDetail(Integer nid);

    Integer insertNewClick(Integer nid);
}