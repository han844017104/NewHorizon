package com.qfedu.newhorizon.provider.pinglun;

import com.qfedu.newhorizon.common.result.PageVo;
import com.qfedu.newhorizon.common.result.R;

import com.qfedu.newhorizon.domain.pinglun.PingLunMain;

import com.qfedu.newhorizon.domain.pinglun.PingLunVo;
import com.qfedu.newhorizon.domain.pinglun.PingLunVoList;

import com.qfedu.newhorizon.domain.pinglun.Pinglun;
import com.qfedu.newhorizon.mapper.news.NewMapper;
import com.qfedu.newhorizon.mapper.newtype.NewTypeMapper;
import com.qfedu.newhorizon.mapper.pinglun.PinglunMapper;
import com.qfedu.newhorizon.service.pinglun.PingLunService;
import com.qfedu.newhorizon.service.pinglun.PinglunUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/19  19:23
 */
@Service("pingLunProvider")
public class PingLunProvider implements PingLunService {

    @Autowired
    private PinglunMapper mapper;

    @Autowired

    private NewMapper newMapper;

    @Autowired
    private NewTypeMapper newTypeMapper;

    @Override
    public List<Pinglun> selectNewPinglun(Integer nid,Integer page,Integer limit) {
        if(nid==null||page==null||limit==null){
            return null;
        }
        limit = 20;
        int index = 0;
        index = (page-1)*limit;
        List<Pinglun> pingluns = mapper.selectByPage(nid, index, limit);
        return pingluns;
    }

    @Override
    public R addLike(Integer uid, Integer plid) {
        if(uid==null||plid==null){
            return R.ERROR();
        }
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
        List<PingLunVo> pingLunVos = mapper.selectHot(nid, minlikenum, limit);

        if(pingLunVos != null && pingLunVos.size() > 0){
            List<PingLunVoList> pingLunVoLists = PinglunUtil.toList(pingLunVos);
            return new R(0,"ok",pingLunVoLists);
        }
        return R.ERROR();
    }

    //分页查询最新评论
    @Override
    public PageVo selectNew(Integer nid, Integer page, Integer limit) {
        Integer count = mapper.selectCount();

        List<PingLunVo> pingLunVos = mapper.selectNew(nid, (page - 1) * limit, limit);
        if(pingLunVos != null && pingLunVos.size() > 0){
            List<PingLunVoList> pingLunVoLists = PinglunUtil.toList(pingLunVos);
            return PageVo.createPage(pingLunVoLists,count);
        }

        return new PageVo(1,"error");

    }

    @Override
    public R myspider() {
        MyProcessor.start(newMapper,newTypeMapper);
        return R.OK();
    }

    //爬虫

}
