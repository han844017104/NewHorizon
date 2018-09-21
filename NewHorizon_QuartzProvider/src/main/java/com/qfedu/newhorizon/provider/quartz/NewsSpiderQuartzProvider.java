package com.qfedu.newhorizon.provider.quartz;

import com.qfedu.newhorizon.common.myspider.MyProcessor;
import com.qfedu.newhorizon.mapper.news.NewMapper;
import com.qfedu.newhorizon.mapper.newtype.NewTypeMapper;
import com.qfedu.newhorizon.service.quartz.NewsSpiderQuartzService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/20  22:20
 */
public class NewsSpiderQuartzProvider implements NewsSpiderQuartzService {

    @Autowired
    private NewMapper nm;

    @Autowired
    private NewTypeMapper nt;

    @Override
    public void startNewSpider(Integer num) {
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("NewSpider", "Spider").withSchedule(CronScheduleBuilder.cronSchedule("")).build();
        JobDetail detail = JobBuilder.newJob(new Job() {
            @Override
            public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

                System.out.println("新闻爬虫功能已开启 ， 本次开启每次爬取 " + num == null ? 1000 : num + "条数据");
            }
        }.getClass()).build();
        try {
            Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
            defaultScheduler.scheduleJob(detail, trigger);
            defaultScheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
