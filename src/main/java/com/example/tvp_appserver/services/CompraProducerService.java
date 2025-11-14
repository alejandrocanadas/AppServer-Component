package com.example.tvp_appserver.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.tvp_appserver.config.RabbitConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompraProducerService {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper mapper = new ObjectMapper();

    public void enviarMensajeAProcesar(Object mensaje) {
        try {
            String json = mapper.writeValueAsString(mensaje);
            rabbitTemplate.convertAndSend(
                    RabbitConfig.COMPRA_EXCHANGE,
                    RabbitConfig.COMPRA_ROUTING_KEY,
                    json
            );
        } catch (Exception e) {
            throw new RuntimeException("Error serializando JSON para RabbitMQ", e);
        }
    }
}
