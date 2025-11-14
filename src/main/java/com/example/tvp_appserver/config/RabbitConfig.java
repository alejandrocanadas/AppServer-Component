package com.example.tvp_appserver.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String COMPRA_EXCHANGE = "compras.exchange";
    public static final String COMPRA_ROUTING_KEY = "compras.creada";
    public static final String COMPRA_QUEUE = "compras.queue";

    @Bean
    public DirectExchange compraExchange() {
        return new DirectExchange(COMPRA_EXCHANGE);
    }

    @Bean
    public Queue compraQueue() {
        return new Queue(COMPRA_QUEUE, true);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(compraQueue())
                .to(compraExchange())
                .with(COMPRA_ROUTING_KEY);
    }
}

