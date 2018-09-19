package com.qfedu.newhorizon.service.sso;


import com.qfedu.newhorizon.common.result.RO;

public interface SSOService {

    RO login(String username, String password);
    RO logout(String token);

}
