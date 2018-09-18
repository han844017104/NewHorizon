package com.qfedu.newhorizon.provider.user;
import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.domain.user.UserMain;
import com.qfedu.newhorizon.mapper.user.UserMapper;
import com.qfedu.newhorizon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Auther: Kam
 * @Date: 下午 7:37 2018-09-17
 * @Description: 用户服务实现
 * @Version: 1.0
 */
@Service
public class UserProvider implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public R register(UserMain user) {
        if(user!=null){
            if (user.getUsername()!=null&& Objects.equals(user.getUsername(),"")) {
                //用户名不为空
                UserMain userMain = userMapper.selectByUsername(user.getUsername());
                if(userMain==null){
                    //为null，可以注册
                    return userMapper.insert(user)>0?R.OK():R.ERROR();
                }
            }
        }
       return R.ERROR();
    }
}
