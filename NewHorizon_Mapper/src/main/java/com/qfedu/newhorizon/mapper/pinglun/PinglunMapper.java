package com.qfedu.newhorizon.mapper.pinglun;

import com.qfedu.newhorizon.domain.pinglun.Pinglun;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PinglunMapper {
    int deleteByPrimaryKey(Integer plid);

    int insert(Pinglun record);

    int insertSelective(Pinglun record);

    Pinglun selectByPrimaryKey(Integer plid);

    int updateByPrimaryKeySelective(Pinglun record);

    int updateByPrimaryKey(Pinglun record);

    List<Pinglun> selectByPage(@Param("nid") Integer nid,@Param("index") Integer index,@Param("limit") Integer limit);

}