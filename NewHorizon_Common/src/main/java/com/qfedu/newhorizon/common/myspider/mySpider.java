package com.qfedu.newhorizon.common.myspider;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

public class mySpider {
    public static void main(String[] args) {
        new Spider(new MyProcessor()).addUrl("https://www.sina.com.cn/").thread(2).addPipeline(new ConsolePipeline()).runAsync();
    }
}
