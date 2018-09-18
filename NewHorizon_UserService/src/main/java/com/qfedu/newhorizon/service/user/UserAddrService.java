package com.qfedu.newhorizon.service.user;

import com.qfedu.newhorizon.domain.user.UserAddr;

public interface UserAddrService {
    int save(UserAddr userAddr);

    int query(UserAddr userAddr);

    UserAddr select(int uid);
}
