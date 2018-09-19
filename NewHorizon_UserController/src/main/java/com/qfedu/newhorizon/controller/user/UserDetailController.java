package com.qfedu.newhorizon.controller.user;

import com.alibaba.fastjson.JSON;

import com.qfedu.newhorizon.common.redis.RedisUtil;
import com.qfedu.newhorizon.common.result.R;

import com.qfedu.newhorizon.common.tools.TokenTool;
import com.qfedu.newhorizon.domain.user.User;
import com.qfedu.newhorizon.domain.user.UserDetail;
import com.qfedu.newhorizon.service.user.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.Objects;


@RestController
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;
    @Autowired

    private RedisUtil redisUtil;

    //新增用户详情
    @RequestMapping("userdetailsave.do")
    public R saveDetail(UserDetail userDetail) {

        return userDetailService.save(userDetail);
    }

    //查询用户详情
    @RequestMapping("userdetailbyuid.do")

    public R getSingle(HttpServletRequest request) {
        String token = TokenTool.getToken(request);
        String json = (String) redisUtil.get(token);
        if(json!=null&& !Objects.equals(json,"")){
            User user= JSON.parseObject(json, User.class);
            return new R(0,"success",userDetailService.queryByUid(user.getUid()));
        }
       return R.ERROR();

    }
}
