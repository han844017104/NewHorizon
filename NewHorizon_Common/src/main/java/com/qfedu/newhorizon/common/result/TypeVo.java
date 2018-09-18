package com.qfedu.newhorizon.common.result;

import com.qfedu.newhorizon.domain.newtype.NewTypeMain;

import java.util.List;

public class TypeVo {
    private NewTypeMain father;
    private List<NewTypeMain> childrens;

    public NewTypeMain getFather() {
        return father;
    }

    public void setFather(NewTypeMain father) {
        this.father = father;
    }

    public List<NewTypeMain> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<NewTypeMain> childrens) {
        this.childrens = childrens;
    }
}
