package com.rabbitmq.demo.fanout;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author huxingxin
 * @createTime 2021年08月27日 14:56:39
 * @Description 消息消费者
 * 只能接收到消息消费者启动之后 成产者生产的消息
 *
 */
public class Consumer{
    private static final String EXCHANGE_NAME = "fanout_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2 设置RabbitMQ地址
        factory.setHost("localhost");
        //3 创建一个新的连接
        Connection connection = factory.newConnection();
        //4 创建一个通道
        Channel channel = connection.createChannel();
        //5 交换机声明(参数: 交换机名称,交换机类型)
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        //6 获取一个临时队列
        String queueName = channel.queueDeclare().getQueue();
        //7 队列与交换机绑定(参数: 队列名称,交换机名称,routingKey)
        channel.queueBind(queueName,EXCHANGE_NAME,"");

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("收到消息: " + message);
            }
        };

        //自动回复队列应答 -- RabbitMQ中的消息确认机制
        channel.basicConsume(queueName,true,consumer);
    }
}
