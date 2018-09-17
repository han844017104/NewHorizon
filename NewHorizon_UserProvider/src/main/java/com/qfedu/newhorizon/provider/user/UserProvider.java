package com.qfedu.newhorizon.provider.user;

import com.qfedu.newhorizon.common.redis.RedisUtil;
import com.qfedu.newhorizon.common.result.RO;
import com.qfedu.newhorizon.domain.user.UserDetail;
import com.qfedu.newhorizon.mapper.user.UserDetailMapper;
import com.qfedu.newhorizon.service.user.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceProvider")
public class UserProvider implements UserDetailService {
    @Autowired
    private UserDetailMapper userDetailMapper;

    @Override
    public RO saveDetail(UserDetail userDetail) {
        return RO.creat(userDetailMapper.insert(userDetail));
    }

    @Override
    public UserDetail queryByUid(int uid) {
        return userDetailMapper.selectByUid(uid);
    }
}
