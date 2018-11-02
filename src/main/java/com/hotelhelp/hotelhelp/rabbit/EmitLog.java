package com.hotelhelp.hotelhelp.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

/**
 *  *Exchange.DeclareOk exchangeDeclare(String exchange,
 *                                      String type, boolean durable,
 *                                      boolean autoDelete,
 *                                      boolean internal,
 *                                      Map<String, Object> arguments) throws IOException;
 *  exchange: 交换器名称
 *  Type: 交换器类型 DIRECT("direct"), FANOUT("fanout"), TOPIC("topic"), HEADERS("headers");1、消息与队列匹配规则：fanout类型交换机会将接收到的消息广播给所有与之绑定的队列。
 *  durable : 是否持久化
 *  autoDelete ： 是否自动删除True表示自动删除，自删除的前提事至少有一个队列或者交换器与这交换器绑定
 *  之后所有与这个交换器绑定的队列或者交换器都与此解绑，一般设置为false
 *  internal：是否内置，如果设置true，则表示内置的交换器客户端程序无法直接发送消息到这个交换器中只能通过交换器路由到交换器的方式
 *  arguments:其它一些结构化参数比如:alternate-exchange
 *  BuiltinExchangeType
 *
 * 发布、订阅模式，发送端发送广播消息，多个接收端接收。
 *
 */
public class EmitLog {
    private final static String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String message = getMessage(args);

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();

    }

    private static String getMessage(String[] strings) {
        if (strings.length < 1) {
            return "info: hello World！";
        }
        return joinStrings(strings, "  ");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0) return "";
        StringBuilder sb = new StringBuilder();
        Arrays.stream(strings).forEach(x -> sb.append(x).append(delimiter));
        return sb.toString();
    }
}
