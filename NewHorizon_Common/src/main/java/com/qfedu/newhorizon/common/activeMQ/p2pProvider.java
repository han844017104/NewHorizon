package com.qfedu.newhorizon.common.activeMQ;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/18  16:47
 */
public class p2pProvider {
    public static void main(String[] args) throws JMSException {
        String url = "tcp://10.8.163.82:61616";
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue first = session.createQueue("first");
        MessageProducer producer = session.createProducer(first);
        producer.send(session.createTextMessage("First message"));
        session.close();
        connection.close();

    }
}
