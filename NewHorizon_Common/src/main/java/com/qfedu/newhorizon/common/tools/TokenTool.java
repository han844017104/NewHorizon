package com.qfedu.newhorizon.common.tools;

import javax.servlet.http.HttpServletRequest;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/16  22:20
 */
public class TokenTool {
    public static String getToken(HttpServletRequest request){
        String token = CookieUtil.getCk(request, "token");
        if (token==null||token.length()<1){
            String t = (String) request.getAttribute("token");
            if (t==null||t.length()<1){
                return null;
            }else{
                return t;
            }
        }
        return token;
    }
}
