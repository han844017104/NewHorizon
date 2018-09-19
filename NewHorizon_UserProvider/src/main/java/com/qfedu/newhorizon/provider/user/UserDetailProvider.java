package com.qfedu.newhorizon.provider.user;

import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.common.result.RO;
import com.qfedu.newhorizon.domain.user.UserDetail;
import com.qfedu.newhorizon.mapper.user.UserDetailMapper;
import com.qfedu.newhorizon.service.user.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailProvider implements UserDetailService {
    @Autowired
    private UserDetailMapper userDetailMapper;

    @Override
    public R save(UserDetail userDetail) {
        if(userDetail!=null){
            userDetailMapper.insert(userDetail);
            return R.OK();
        }
        return R.ERROR();
    }

    @Override
    public UserDetail queryByUid(int uid) {
        return userDetailMapper.selectByUid(uid);
    }
}
