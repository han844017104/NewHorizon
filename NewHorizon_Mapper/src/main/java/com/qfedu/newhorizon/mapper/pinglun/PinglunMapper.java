package com.qfedu.newhorizon.mapper.pinglun;

import com.qfedu.newhorizon.domain.pinglun.Pinglun;

public interface PinglunMapper {
    int deleteByPrimaryKey(Integer plid);

    int insert(Pinglun record);

    int insertSelective(Pinglun record);

    Pinglun selectByPrimaryKey(Integer plid);

    int updateByPrimaryKeySelective(Pinglun record);

    int updateByPrimaryKey(Pinglun record);
}