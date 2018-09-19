package com.qfedu.newhorizon.service.user;


import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.domain.user.UserDetail;


public interface UserDetailService {
    R save(UserDetail userDetail);
    UserDetail queryByUid(int uid);
}
