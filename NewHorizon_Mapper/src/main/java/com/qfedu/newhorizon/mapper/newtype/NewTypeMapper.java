package com.qfedu.newhorizon.mapper.newtype;

import com.qfedu.newhorizon.domain.newtype.NewTypeMain;

import java.util.List;

public interface NewTypeMapper {
    //所有分类
    List<NewTypeMain> selectAll();
    //一级分类
    List<NewTypeMain> selectAllFather();
}