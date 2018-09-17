package com.qfedu.newhorizon.controller.user;

import com.alibaba.fastjson.JSON;
import com.qfedu.newhorizon.common.redis.JedisUtil;
import com.qfedu.newhorizon.common.redis.RedisUtil;
import com.qfedu.newhorizon.common.result.RO;
import com.qfedu.newhorizon.common.tools.CookieUtil;
import com.qfedu.newhorizon.common.tools.TokenTool;
import com.qfedu.newhorizon.domain.user.User;
import com.qfedu.newhorizon.domain.user.UserDetail;
import com.qfedu.newhorizon.service.user.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private JedisUtil jedisUtil;

    //新增
    @RequestMapping("userdetailsave.do")
    public RO save(UserDetail userDetail) {
        return userDetailService.saveDetail(userDetail);
    }

    //查询
    @RequestMapping("userdetailbyuid.do")
    public UserDetail getSingle(HttpServletRequest request) {
        String token = TokenTool.getToken(request);
        String json = jedisUtil.getStr(token);
        User user= JSON.parseObject(json, User.class);
        return userDetailService.queryByUid(user.getUid());
    }
}
