package com.qfedu.newhorizon.common.myspider;

import com.qfedu.newhorizon.domain.newtype.NewTypeMain;
import com.qfedu.newhorizon.mapper.news.NewMapper;
import com.qfedu.newhorizon.mapper.newtype.NewTypeMapper;

import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyProcessor implements PageProcessor {
    private static NewMapper newMapper = null;
    private static NewTypeMapper newTypeMapper = null;
    private static Map<Integer,String> newTypeMains = new HashMap<>();


    private Site site = Site.me().addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36").setCharset("utf-8").setSleepTime(100).setRetryTimes(1);
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



            int index = -1;
            for(Integer k : newTypeMains.keySet()) {
                if(newTypeMains.get(k).equals(channel.get(0))) {
                    index = k;
                    break;
                }
            }
            if(index == -1){
                NewTypeMain a = new NewTypeMain();
                a.setTypename(channel.get(0));
                newTypeMapper.savetype(a);
                index = a.getTypeid();
                newTypeMains.put(index,a.getTypename());
            }

            newMapper.savenew(index,context.get(0),title.get(0),time.get(0));

        }
    }

    //站点信息
    @Override
    public Site getSite() {
        return site;
    }

    public static void  start(NewMapper newMappers,NewTypeMapper newTypeMappers){
        newMapper = newMappers;
        newTypeMapper = newTypeMappers;
        newTypeMains = newTypeMapper.selectAlltype();
        new Spider(new MyProcessor()).addUrl("https://www.sina.com.cn/").thread(2).addPipeline(new ConsolePipeline()).runAsync();
    }
}
