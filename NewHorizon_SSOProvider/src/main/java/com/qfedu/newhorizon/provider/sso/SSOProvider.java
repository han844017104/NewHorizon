package com.qfedu.newhorizon.provider.sso;

import com.qfedu.newhorizon.service.sso.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/16  16:07
 */
@Service("ssoServiceProvider")
public class SSOProvider implements SSOService{

    @Autowired
    private SSOService sso;
}
