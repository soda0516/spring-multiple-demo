package com.example.springmultipledemo.rabbitmq;



import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Describe TODO
 * @Author orang
 * @Create 2019/1/16 16:18
 **/
public class Producer {
    public final static String QUEUE_NAME="rabbitMQ_test2";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();

        //设置RabbitMQ相关信息
        factory.setHost("localhost");
        factory.setUsername("loveorange");
        factory.setPassword("Soda19860806#");
        factory.setPort(5672);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "Hello RabbitMQ";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        System.out.println("Producer Send +'" + message + "'");

        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
