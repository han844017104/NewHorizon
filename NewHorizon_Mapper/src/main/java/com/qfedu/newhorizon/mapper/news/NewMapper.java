package com.qfedu.newhorizon.mapper.news;

import com.qfedu.newhorizon.common.result.PageVo;
import com.qfedu.newhorizon.domain.news.New;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewMapper {


    List<New> selectByType(Integer type);

    PageVo selectByPage(@Param("page")Integer page,@Param("limit")Integer limit);

    New selectById(Integer id);
}