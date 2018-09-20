package com.qfedu.newhorizon.provider.pinglun;

import com.qfedu.newhorizon.common.result.PageVo;
import com.qfedu.newhorizon.common.result.R;

import com.qfedu.newhorizon.domain.pinglun.PingLunMain;

import com.qfedu.newhorizon.domain.pinglun.PingLunVoList;

import com.qfedu.newhorizon.domain.pinglun.Pinglun;
import com.qfedu.newhorizon.mapper.pinglun.PinglunMapper;
import com.qfedu.newhorizon.service.pinglun.PingLunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/19  19:23
 */
@Service("pingLunProvider")
public class PingLunProvider implements PingLunService {

    @Autowired
    private PinglunMapper mapper;

    @Override
    public List<Pinglun> selectNewPinglun(Integer nid,Integer page,Integer limit) {
        limit = 20;
        int index = 0;
        index = (page-1)*limit;
        List<Pinglun> pingluns = mapper.selectByPage(nid, index, limit);
        return pingluns;
    }

    @Override
    public R addLike(Integer uid, Integer plid) {
        Pinglun pinglun = new PingLunMain();
        ((PingLunMain) pinglun).setFatherid(plid);
        ((PingLunMain) pinglun).setType(2);
        return mapper.insert(pinglun)>0?R.OK():R.ERROR();
    }



    //新增评论
    @Override
    public R insert(Pinglun pinglun) {
        return mapper.insert(pinglun) > 0 ? R.OK():R.ERROR();
    }
    //查询3个热评
    @Override
    public R selectHot(Integer nid, Integer minlikenum, Integer limit) {
        List<PingLunVoList> pingLunVoLists = mapper.selectHot(nid, minlikenum,limit);
        if(pingLunVoLists != null && pingLunVoLists.size() > 0){
            return new R(0,"ok",pingLunVoLists);
        }
        return R.ERROR();
    }
    //分页查询最新评论
    @Override
    public R selectNew(Integer nid, Integer page, Integer limit) {
        PageVo pageVo = mapper.selectNew(nid, (page - 1) * limit, limit);
        if(null != pageVo){
            return new R(0,"ok",pageVo);
        }
        return R.ERROR();

    }
}
