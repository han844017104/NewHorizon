package com.qfedu.newhorizon.provider.user;

import com.qfedu.newhorizon.common.redis.RedisUtil;
import com.qfedu.newhorizon.mapper.user.UserMapper;
import com.qfedu.newhorizon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/17  20:32
 */
@Service("userServiceProvider")
public class UserProvider implements UserService {

    @Autowired
    private UserMapper us;

    @Autowired
    private RedisUtil ru;
}
