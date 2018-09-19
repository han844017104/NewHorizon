package com.qfedu.newhorizon.mapper.pinglun;

import com.qfedu.newhorizon.common.result.PageVo;
import com.qfedu.newhorizon.domain.pinglun.PingLunVoList;
import com.qfedu.newhorizon.domain.pinglun.Pinglun;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinglunMapper {

    int insert(Pinglun pinglun);


    List<PingLunVoList> selectHot(@Param("nid") Integer nid, @Param("minlikenum") Integer minlikenum, @Param("limit") Integer limit);

    PageVo selectNew(@Param("nid") Integer nid,@Param("page")Integer page,@Param("limit")Integer limit);


}