package com.ml.housecost.message;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RPCClient {
    private static final String RPC_QUEUE_NAME = "rpc_queue";

    public static void main(String[] args) throws Exception {
        //RPCClient.getPrice();
    }

    public static Integer getPrice(Request request) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            String response = channel.queueDeclare().getQueue();
            AMQP.BasicProperties props = new AMQP.BasicProperties
                    .Builder()
                    .replyTo(response)
                    .build();

            channel.basicPublish("", RPC_QUEUE_NAME, props, request.toString().getBytes(StandardCharsets.UTF_8));

            System.out.println(" [x] Sent '" + request + "'");

            long startTime = System.currentTimeMillis();
            long endTime = startTime + TimeUnit.SECONDS.toMillis(10);

            GetResponse result = null;
            while (System.currentTimeMillis() < endTime) {
                result = channel.basicGet(response, true);
                //System.out.println("Performing action...");
                if (result != null) {
                    System.out.println("Condition met, stopping action");
                    break;
                }
            }
            // Если сообщение было получено, распечатываем его
            if (result != null) {
                String message = new String(result.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [.] Got '" + message + "'");
                return Integer.parseInt(message);
            } else {
                System.out.println(" [.] No message received within the timeout period.");
                return null;
            }
        }
    }
}


/*
HttpClient httpClient = HttpClient.newHttpClient();
                String url = "http://localhost:6060/prices/update";
                String body = "{\"price\": " + Integer.parseInt(message) + "}";
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .POST(HttpRequest.BodyPublishers.ofString(body))
                        .header("Content-Type", "application/json")
                        .build();
                try {
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
 */