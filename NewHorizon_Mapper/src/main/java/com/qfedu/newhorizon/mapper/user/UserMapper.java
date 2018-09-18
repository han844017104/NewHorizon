package com.qfedu.newhorizon.mapper.user;

import com.qfedu.newhorizon.domain.user.User;
import com.qfedu.newhorizon.domain.user.UserMain;

public interface UserMapper {


    int insert(UserMain record);

    UserMain selectByUsername(String username);
}