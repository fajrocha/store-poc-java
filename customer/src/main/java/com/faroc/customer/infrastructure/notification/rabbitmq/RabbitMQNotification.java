package com.faroc.customer.infrastructure.notification.rabbitmq;

import com.faroc.amqp.RabbitMQProducer;
import com.faroc.customer.application.gateways.NotificationGateway;
import com.faroc.customer.domain.entities.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RabbitMQNotification implements NotificationGateway {
    private final RabbitMQProducer rabbitProducer;

    @Override
    public void sendNotification(NotificationRequest notification) {
        log.info("Publishing notification: {}", notification);
        rabbitProducer.publish(
                notification,
                "internal.exchange",
                "internal.notification.routing-key");
    }
}