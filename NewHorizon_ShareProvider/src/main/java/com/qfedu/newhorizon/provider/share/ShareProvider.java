package com.qfedu.newhorizon.provider.share;

import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.domain.news.NewMain;
import com.qfedu.newhorizon.mapper.news.NewMapper;
import com.qfedu.newhorizon.service.share.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/21  21:05
 *
 * Update By Kam On 2018/9/22  11:30
 */

@Service
public class ShareProvider implements ShareService {
    @Autowired
    private NewMapper newMapper;

    @Autowired
    private ShareWord shareWords;

    private String NEWTITLE = null;

    @Override
    public R shareToQQ(Integer nid) {
        try {
            NEWTITLE = newMapper.selectNewDetail(nid).getTitle();
            final String QQSHARE = "https://connect.qq.com/widget/shareqq/index.html?url=http%3A%2F%2F" + shareWords.SHAREURL + nid + "&desc=&title=" + NEWTITLE + "&summary=&pics=&flash=&site=";
            return new R(0, "success", QQSHARE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.ERROR();
    }

    @Override
    public R shareToQZone(Integer nid) {
        try {
            NEWTITLE = newMapper.selectNewDetail(nid).getTitle();
            final String QZONESHARE = "https://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=http%3A%2F%2F" + shareWords.SHAREURL + nid + "&title=" + NEWTITLE + "&desc=&summary=&pics=";
            return new R(0, "success", QZONESHARE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.ERROR();
    }
}
