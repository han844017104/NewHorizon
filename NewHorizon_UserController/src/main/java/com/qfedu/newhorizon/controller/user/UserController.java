package com.qfedu.newhorizon.controller.user;

import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.domain.user.User;
import com.qfedu.newhorizon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Kam
 * @Date: 下午 7:36 2018-09-17
 * @Description: 用户数据接口
 * @Version: 1.0
 */
@RestController
public class UserController {
    @Autowired
     private  UserService userService;
    //注册
    @RequestMapping("/register.do")
    public R register(User user){
       return userService.register(user);
    }
}
