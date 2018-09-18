package com.qfedu.newhorizon.common.activeMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/18  17:48
 */
public class TopicPub {

    public static void main(String[] args) throws JMSException {
        String url = "tcp://10.8.163.82:61616";
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic sec = session.createTopic("Sec");
        MessageProducer producer = session.createProducer(sec);
        producer.send(session.createTextMessage("hehe"));
        session.close();
        connection.close();
    }
}
