package com.qfedu.newhorizon.provider.user;

import com.qfedu.newhorizon.domain.user.UserAddr;
import com.qfedu.newhorizon.mapper.user.UserAddrMapper;
import com.qfedu.newhorizon.service.user.UserAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserAddrServiceProvider")
public class UserAddrProvider implements UserAddrService {
    @Autowired
    private UserAddrMapper userAddrMapper;

    @Override
    public int save(UserAddr userAddr) {
        return userAddrMapper.insert(userAddr);
    }

    @Override
    public int query(UserAddr userAddr) {
        return userAddrMapper.updateById(userAddr);
    }
}
