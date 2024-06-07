package com.ml.housecost.config;

import com.ml.housecost.message.Sender;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }
    @Bean
    public Sender sender() {
        return new Sender();
    }
}
