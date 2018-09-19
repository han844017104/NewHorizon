package com.qfedu.newhorizon.controller.news;

import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/18  17:04
 */
@RestController
public class NewsController {

    @Autowired
    private NewsService service;


    /**
     * 按分类查新闻
     * @param type
     * @return
     */
    @RequestMapping("/querybytype.do")
    public R querybytype(Integer type){
        return service.selectByType(type);
    }

    /**
     * 按分类分页查询新闻
     * @param page 当前页
     * @param limit 每页条数
     * @param type 分类
     * @return
     */
    @RequestMapping("/querybytypepage.do")
    public R querybytypepage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer limit, Integer type){
        return service.selectByPage(page,limit,type);
    }

    /**
     * 查询新闻详情
     * @param nid 新闻id
     * @return 返回分装好的新闻详情
     */
    @RequestMapping("/querynewdetail.do")
    public R querynewdetail(Integer nid){
       return service.selectNewDetail(nid);
    }

    /**
     * 查询所有分类
     * @return 返回封装父子目录类
     */
    @RequestMapping("/queryalltypes.do")
    public R queryalltypes(){
        return service.selectAll();
    }

    /**
     * 查询所有一级分类
     * @return
     */
    @RequestMapping("/queryallfathertype.do")
    public R queryallfathertype(){
        return service.selectFather();
    }
}
