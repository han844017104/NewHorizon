package com.qfedu.newhorizon.provider.share;

import org.springframework.stereotype.Component;

/**
 * @Auther: KAM1996
 * @Date: 上午 10:57 2018-09-22
 * @Description:
 * @Version: 1.0
 */
@Component
public enum ShareWord {
    HOSTNAME("localhost:8080"),
    SHAREURL(HOSTNAME+"/querynewdetail.do?nid=");

    private final String value;

    ShareWord(String value) {
        this.value = value;
    }
}
