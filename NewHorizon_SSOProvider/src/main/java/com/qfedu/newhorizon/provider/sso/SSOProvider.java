package com.qfedu.newhorizon.provider.sso;

import com.qfedu.newhorizon.common.redis.RedisUtil;
import com.qfedu.newhorizon.common.result.RO;
import com.qfedu.newhorizon.common.tools.Base64Utils;
import com.qfedu.newhorizon.common.tools.EncrypUtil;
import com.qfedu.newhorizon.domain.user.UserMain;
import com.qfedu.newhorizon.mapper.user.UserMapper;
import com.qfedu.newhorizon.service.sso.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/16  16:07
 */
@Service("ssoServiceProvider")
public class SSOProvider implements SSOService{

    @Autowired
    private UserMapper us;

    @Autowired
    private RedisUtil ru;

    @Override
    public RO login(String username, String password) {
        UserMain user = us.selectByUsername(username);
        if (user==null){
            return RO.creat(0,"未注册");
        }
        if (Objects.equals(EncrypUtil.md5Pass(user.getUid().toString(), password), user.getPassword())){
            String s = Base64Utils.encode("OnLineUser" + username);
            ru.set(s,user,60 * 30 );
            return RO.creat(1,"登录成功",s);
        }
        return RO.creat(2,"密码错误");
    }

    @Override
    public @ResponseBody RO logout(String token) {
        ru.del(token);
        return RO.creat(1);
    }
}
