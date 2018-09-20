package com.qfedu.newhorizon.controller.pinglun;

import com.alibaba.fastjson.JSON;
import com.qfedu.newhorizon.common.redis.RedisUtil;
import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.common.tools.TokenTool;
import com.qfedu.newhorizon.domain.pinglun.PingLunMain;
import com.qfedu.newhorizon.domain.pinglun.Pinglun;
import com.qfedu.newhorizon.domain.user.User;
import com.qfedu.newhorizon.service.pinglun.PingLunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/19  19:27
 */
@RestController
public class PingLunController {


    @Autowired
    private PingLunService service;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/querypinglun.do")
    public R selectnewpinglun(Integer nid, Integer page, Integer limit) {
        List<Pinglun> pingluns = service.selectNewPinglun(nid, page, limit);
        return pingluns!=null? new R(0, "success",pingluns ):R.ERROR();

    }

    @RequestMapping("/addlike.do")
    public R addlike(Integer uid,Integer plid){
        return service.addLike(uid,plid);
    }

    //新增评论、回复
    @RequestMapping("/savepinglun.do")
    public R savepinglun(PingLunMain pingLunMain, HttpServletRequest request){
        String token = TokenTool.getToken(request);
        String json = (String) redisUtil.get(token);
        if (json != null && Objects.equals(json,"")) {
            if (pingLunMain.getText() != null && pingLunMain.getText().trim().length()>10) {
                return new R(0, "success", service.insert(pingLunMain));
            }
            return  new R(1,"评论不符合要求");
        }
        return new R(1, "请先登录");
    }


    @RequestMapping("/queryhot.do")
    public R queryhot(Integer nid,@RequestParam(defaultValue = "3") Integer minlikenum,@RequestParam(defaultValue = "3") Integer limit){
        return service.selectHot(nid,minlikenum,limit);
    }


    @RequestMapping("/querynew.do")
    public R querynew(Integer nid, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer limit){
        return service.selectNew(nid,page,limit);
    }

    //评论回复
    @RequestMapping("/addpinglunreply.do")
    public R addReply(PingLunMain pingLunMain){
        return service.addReply(pingLunMain);
    }
}
