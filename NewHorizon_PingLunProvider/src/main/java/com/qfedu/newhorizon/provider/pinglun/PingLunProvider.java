package com.qfedu.newhorizon.provider.pinglun;

import com.qfedu.newhorizon.mapper.pinglun.PinglunMapper;
import com.qfedu.newhorizon.service.pinglun.PingLunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/19  19:23
 */
@Service("pingLunProvider")
public class PingLunProvider implements PingLunService {

    @Autowired
    private PinglunMapper pl;
}
