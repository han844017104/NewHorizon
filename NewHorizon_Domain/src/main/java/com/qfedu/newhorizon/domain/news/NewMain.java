package com.qfedu.newhorizon.domain.news;


import java.util.Date;

import com.qfedu.newhorizon.domain.pinglun.PingLunMain;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.List;


/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/18  17:29
 */
public class NewMain extends New{


    private String title;

    private Date creattime;

    private Integer type;

    private Integer flag;

    private String text;

    private List<PingLunMain> pingLuns;

    public List<PingLunMain> getPingLuns() {
        return pingLuns;
    }

    public void setPingLuns(List<PingLunMain> pingLuns) {
        this.pingLuns = pingLuns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}
