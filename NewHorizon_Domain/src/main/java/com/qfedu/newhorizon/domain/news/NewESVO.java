package com.qfedu.newhorizon.domain.news;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/20  17:38
 */
@Document(indexName = "news",type = "newesvo")
public class NewESVO {

    private Integer nid;

    private String title;

    private Integer clicknum;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getClicknum() {
        return clicknum;
    }

    public void setClicknum(Integer clicknum) {
        this.clicknum = clicknum;
    }
}
