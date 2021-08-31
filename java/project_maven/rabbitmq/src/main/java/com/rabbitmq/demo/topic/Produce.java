package com.rabbitmq.demo.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author huxingxin
 * @createTime 2021年08月28日 15:53:31
 * @Description
 * 主题模式，注意这里的主题模式，和 ActivityMQ 里的不一样。 ActivityMQ 里的主题，更像是广播模式。
 * 那么这里的主题模式是什么意思呢？ 如消息来源有： 美国新闻，美国天气，欧洲新闻，欧洲天气。
 * 如果你想看 美国主题： 那么就会收到 美国新闻，美国天气。
 * 如果你想看 新闻主题： 那么就会收到 美国新闻，欧洲新闻。
 * 如果你想看 天气主题： 那么就会收到 美国天气，欧洲天气。
 * 如果你想看 欧洲主题： 那么就会收到 欧洲新闻，欧洲天气。
 *
 * 分别在 四个路由："usa.news", "usa.weather", "europe.news", "europe.weather" 上发布 "美国新闻", "美国天气", "欧洲新闻", "欧洲天气".
 */
public class Produce {
    private static final String EXCHANGE_NAME = "topic_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"topic");
        String[] routing_key = {"usa.news", "usa.weather", "europe.news", "europe.weather" };
        String[] messages = {"美国新闻", "美国天气", "欧洲新闻", "欧洲天气"};
        for (int i = 0; i < messages.length; i++){
            String routingKey = routing_key[i];
            String message = messages[i];
            channel.basicPublish(EXCHANGE_NAME,routingKey,null,message.getBytes());
            System.out.printf("发送消息到路由 %s,内容是 %s%n",routingKey,message);
        }
    }
}
