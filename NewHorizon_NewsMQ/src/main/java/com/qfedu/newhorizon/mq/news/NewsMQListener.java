package com.qfedu.newhorizon.mq.news;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qfedu.newhorizon.domain.news.New;
import com.qfedu.newhorizon.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/22  10:29
 */
public class NewsMQListener implements MessageListener {

    @Autowired
    private NewsService ns;

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            try {
                String json = ((TextMessage) message).getText();
                JSONObject o = JSON.parseObject(json);
                Integer code = o.getInteger("code");
                switch (code){
                    case 1 :
                        New n = o.getObject("obj", New.class);
                        ns.insertClick(n.getNid());
                        break;
                }

            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
