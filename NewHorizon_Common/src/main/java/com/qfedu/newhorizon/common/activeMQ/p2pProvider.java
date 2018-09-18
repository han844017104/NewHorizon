package com.qfedu.newhorizon.common.activeMQ;

import org.apache.activemq.spring.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/18  16:47
 */
public class p2pProvider {
    public static void main(String[] args) throws JMSException {
        String url = "";
        ConnectionFactory factory = new ActiveMQConnectionFactory();
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, 1);
        Queue first = session.createQueue("first");
        QueueBrowser browser = session.createBrowser(first);

    }
}
