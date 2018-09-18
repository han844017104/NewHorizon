package com.qfedu.newhorizon.service.user;

import com.qfedu.newhorizon.domain.user.UserDetail;
import com.qfedu.newhorizon.common.result.RO;

public interface UserDetailService {
    RO save(UserDetail userDetail);

    UserDetail queryByUid(int uid);
}
