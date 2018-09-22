package com.qfedu.newhorizon.controller.share;

import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.service.share.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: Kam
 * @Date: 上午 10:10 2018-09-22
 * @Description: 分享新闻数据接口
 * @Version: 1.0
 */
public class ShareController {

    @Autowired
    private ShareService shareService;

    @RequestMapping(value = "/sharetoqq.do")
    public R shareqq(Integer nid){
        return shareService.shareToQQ(nid);
    }
    @RequestMapping("/sharetoqzone.do")
    public R shareqzone(Integer nid){
        return shareService.shareToQZone(nid);
    }
}
