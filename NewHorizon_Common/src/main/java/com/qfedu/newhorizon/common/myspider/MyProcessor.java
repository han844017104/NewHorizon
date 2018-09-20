package com.qfedu.newhorizon.common.myspider;

import com.qfedu.newhorizon.domain.news.NewMain;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

public class MyProcessor implements PageProcessor {
    private Site site = Site.me().addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36").setCharset("utf-8").setSleepTime(100).setRetryTimes(1);
    private  int count = 0;
    private List<String> url = new ArrayList<>();
    @Override
    public void process(Page page) {

        if(page.getUrl().regex("https://www.sina.com.cn/").match() ){
            //加入满足条件的链接
            page.addTargetRequests(
                    page.getHtml().xpath("//div/a/@href").all());
        }else if (!page.getUrl().regex("[a-zA-z]+://[^\\s]*.shtml").match()){
            List<String> list = page.getHtml().xpath("//div/a/@href").all();
            for(String s : list){
                if(s.matches("[a-zA-z]+://[^\\s]*.shtml")){
                    url.add(s);
                }
            }
            page.addTargetRequests(url);
        }

        if(page.getUrl().regex("[a-zA-z]+://[^\\s]*.shtml").match()){
            List<String> channel = page.getHtml().xpath("//div[@class='channel-path']/a/text()").all();
            List<String> title = page.getHtml().xpath("//h1[@class='main-title']/text()").all();
            List<String> time = page.getHtml().xpath("//*[@id=\"top_bar\"]/div/div[2]/span/text()").all();
             List<String> context = page.getHtml().xpath("//*[@id=\"article\"]").all();

            System.out.println("分类:"+ channel.get(0));
            System.out.println("标题："+ title.get(0));
            System.out.println("时间："+ time.get(0));
//            System.out.println("context------>" + context.get(0));
        }




        }


//        List<String> title = page.getHtml().xpath("//h1[@class='main-title']/text()").all();
//        List<String> time = page.getHtml().xpath("//*[@id=\"top_bar\"]/div/div[2]/span/text()").all();
//        List<String> context = page.getHtml().xpath("//*[@id=\"article\"]").all();
//
//        for(int i = 0; i < title.size(); i++){
//            System.out.println("title------>" + title.get(i));
//            System.out.println("time------>" + time.get(i));
//            System.out.println("context------>" + context.get(i));
//        }
//
//


    //站点信息
    @Override
    public Site getSite() {
        return site;
    }
}
