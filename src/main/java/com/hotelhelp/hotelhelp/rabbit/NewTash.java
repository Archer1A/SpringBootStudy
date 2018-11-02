package com.hotelhelp.hotelhelp.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 1、使用“task_queue”声明了另一个Queue，因为RabbitMQ不容许声明2个相同名称、配置不同的Queue
 *
 * 2、使"task_queue"的Queue的durable的属性为true，即使消息队列durable
 *
 * 3、使用MessageProperties.PERSISTENT_TEXT_PLAIN使消息durable
 */
public class NewTash {

    private static final String TASH_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

    // queueDeclare(string queue,boolean durable,boolean exclusive)  队列名称 ，是否持久化，默认存放在内存中如果rabbitMQ重启会丢失
        channel.queueDeclare(TASH_QUEUE_NAME, true, false, false, null);
        String message = getMessage(args);
        channel.basicPublish("", TASH_QUEUE_NAME,  MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes("UTF-8")
        );
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }

    private static String getMessage(String[] strings) {
        if (strings.length < 1)
            return "h";
        return joinStrings(strings,"  ");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(delimiter).append(s);
        }
        return sb.toString();
    }

}
