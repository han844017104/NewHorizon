package com.qfedu.newhorizon.controller.sso;

import com.qfedu.newhorizon.common.result.RO;
import com.qfedu.newhorizon.common.tools.CookieUtil;
import com.qfedu.newhorizon.common.tools.TokenTool;
import com.qfedu.newhorizon.service.sso.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/16  16:08
 */
@Controller
public class SSOController {

    @Autowired
    private SSOService sso;

    @RequestMapping("/login.do")
    public @ResponseBody RO login(@NotNull String username, @NotNull String password,HttpServletResponse response){
        RO login = sso.login(username.trim(), password.trim());
        if (login.getCode()==1){
            CookieUtil.setCK(response, "token", login.getObject().toString());
        }
        return login;
    }

    @RequestMapping("/logout.do")
    public RO logOut(HttpServletRequest request,HttpServletResponse response){
        String token = TokenTool.getToken(request);
        if (token!=null){
            CookieUtil.delCK(response, "token");
            return sso.logout(token);
        }else{
            return RO.creat(0);
        }
    }
}
