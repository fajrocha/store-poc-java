package com.faroc.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQProducer {
    private final AmqpTemplate template;

    public <T> void publish(T payload, String exchange, String routingKey) {
        log.info("Publishing to {} using routingKey {}. Payload {}", exchange, routingKey, payload);
        template.convertAndSend(exchange, routingKey, payload);
        log.info("Published to {} using routingKey {}. Payload {}", exchange, routingKey, payload);
    }
}
