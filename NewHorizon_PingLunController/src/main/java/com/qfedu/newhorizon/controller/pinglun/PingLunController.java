package com.qfedu.newhorizon.controller.pinglun;

import com.qfedu.newhorizon.common.result.PageVo;
import com.qfedu.newhorizon.common.result.R;

import com.qfedu.newhorizon.domain.pinglun.PingLunMain;
import com.qfedu.newhorizon.domain.pinglun.Pinglun;
import com.qfedu.newhorizon.service.pinglun.PingLunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/19  19:27
 */
@RestController
public class PingLunController {


    @Autowired
    private PingLunService service;

    @RequestMapping("/selectlike.do")
    public R selectnewpinglun(Integer nid, Integer page, Integer limit) {
        List<Pinglun> pingluns = service.selectNewPinglun(nid, page, limit);
        return pingluns!=null? new R(0, "success",pingluns ):R.ERROR();

    }

    @RequestMapping("/addlike.do")
    public R addlike(Integer uid,Integer plid){
        return service.addLike(uid,plid);
    }

    @RequestMapping("/savepinglun.do")
    public R savepinglun(PingLunMain pingLunMain){
        return service.insert(pingLunMain);
    }


    @RequestMapping("/queryhot.do")
    public R queryhot(Integer nid,@RequestParam(defaultValue = "3") Integer minlikenum,@RequestParam(defaultValue = "3") Integer limit){
        return service.selectHot(nid,minlikenum,limit);
    }


    @RequestMapping("/querynew.do")
    public PageVo querynew(Integer nid, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer limit){
        return service.selectNew(nid,page,limit);
    }
}
