package com.qfedu.newhorizon.domain.news;

import java.io.Serializable;
import java.util.Date;

public class New  implements Serializable {
    private Integer nid;

    public New() {
    }

    public New(Integer nid) {
        this.nid = nid;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

}