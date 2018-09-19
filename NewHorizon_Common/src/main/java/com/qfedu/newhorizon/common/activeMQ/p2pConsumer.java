package com.qfedu.newhorizon.common.activeMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/18  17:39
 */
public class p2pConsumer {
    public static void main(String[] args) throws JMSException {
        String url = "tcp://10.8.163.82:61616";

        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue first = session.createQueue("first");
        MessageConsumer consumer = session.createConsumer(first);
        TextMessage receive = (TextMessage) consumer.receive();
        System.out.println(receive.getText());
        session.close();
        connection.close();

    }
}
