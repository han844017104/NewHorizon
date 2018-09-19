package com.qfedu.newhorizon.provider.pinglun;

import com.qfedu.newhorizon.common.result.PageVo;
import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.domain.pinglun.PingLunMain;
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
    private PinglunMapper pl;

    @Override
    public List<Pinglun> selectNewPinglun(Integer nid,Integer page,Integer limit) {
        limit = 20;
        int index = 0;
        index = (page-1)*limit;
        List<Pinglun> pingluns = pl.selectByPage(nid, index, limit);
        return pingluns;
    }

    @Override
    public R addLike(Integer uid, Integer plid) {
        Pinglun pinglun = new PingLunMain();
        ((PingLunMain) pinglun).setFatherid(plid);
        ((PingLunMain) pinglun).setType(2);
        return pl.insert(pinglun)>0?R.OK():R.ERROR();
    }
}
