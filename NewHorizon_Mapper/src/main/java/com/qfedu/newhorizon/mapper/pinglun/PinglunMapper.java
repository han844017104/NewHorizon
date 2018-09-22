package com.qfedu.newhorizon.mapper.pinglun;

import com.qfedu.newhorizon.common.result.PageVo;
import com.qfedu.newhorizon.domain.pinglun.PingLunVo;
import com.qfedu.newhorizon.domain.pinglun.PingLunVoList;
import com.qfedu.newhorizon.domain.pinglun.Pinglun;
import org.apache.ibatis.annotations.Param;


import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinglunMapper {

    int insert(Pinglun pinglun);


    List<PingLunVo> selectHot(@Param("nid") Integer nid, @Param("minlikenum") Integer minlikenum, @Param("limit") Integer limit);

    List<PingLunVo> selectNew(@Param("nid") Integer nid,@Param("page")Integer page,@Param("limit")Integer limit);

    int selectCount();

    List<Pinglun> selectByPage(@Param("nid") Integer nid,@Param("index") Integer index,@Param("limit") Integer limit);


}