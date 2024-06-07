package com.ml.housecost.message;

import com.ml.housecost.Request;
import com.rabbitmq.client.*;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class RPCClient {
    private static final String RPC_QUEUE_NAME = "rpc_queue";

    public static AtomicReference<Integer> getPrice(Request request) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            String response = channel.queueDeclare().getQueue();
            AMQP.BasicProperties props = new AMQP.BasicProperties
                    .Builder()
                    .replyTo(response)
                    .build();

            int number = 10;
            channel.basicPublish("", RPC_QUEUE_NAME, props, request.toString().getBytes(StandardCharsets.UTF_8));

            System.out.println(" [x] Sent '" + request + "'");

            AtomicReference<Integer> result = new AtomicReference<>(0);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                result.set(Integer.parseInt(message));
                //System.out.println(" [.] Got '" + message + "'");
            };

            channel.basicConsume(response, true, deliverCallback, consumerTag -> {
            });
            return result;
        }
    }
}
