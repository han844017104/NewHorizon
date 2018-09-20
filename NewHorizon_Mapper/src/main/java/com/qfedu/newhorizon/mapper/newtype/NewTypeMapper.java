package com.qfedu.newhorizon.mapper.newtype;

import com.qfedu.newhorizon.domain.newtype.NewType;
import com.qfedu.newhorizon.domain.newtype.NewTypeMain;

import java.util.List;

public interface NewTypeMapper {
    //所有分类
    List<NewTypeMain> selectAll();

    List<NewTypeMain> selectAllFather();

}