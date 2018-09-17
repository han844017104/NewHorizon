package com.qfedu.newhorizon.service.user;

import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.common.result.RO;
import com.qfedu.newhorizon.domain.user.User;

/**
 * @Auther: KAM1996
 * @Date: 下午 7:37 2018-09-17
 * @Description: 用户服务
 * @Version: 1.0
 */
public interface UserService {
    //用户注册
    public R register(User user);
    //
}
