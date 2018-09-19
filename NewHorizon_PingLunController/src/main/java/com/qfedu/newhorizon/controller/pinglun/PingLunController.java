package com.qfedu.newhorizon.controller.pinglun;

import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.service.pinglun.PingLunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/19  19:27
 */
@RestController
public class PingLunController {

    @Autowired
    private PingLunService pl;

    @RequestMapping("/selectlike.do")
    public R select(Integer nid, Integer page, Integer limit){

       return new R(0,"success",pl.selectNewPinglun(nid,page,limit)) ;
    }
}
