package com.faroc.customer.infrastructure.streaming.kafka;

import com.faroc.customer.application.gateways.NotificationGateway;
import com.faroc.kafka.contracts.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@Primary
public class KafkaProducer implements NotificationGateway {

    @Value("${spring.kafka.app.topics.notification}")
    private String notificationTopic;
    private final KafkaTemplate<String, NotificationRequest> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, NotificationRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendNotification(NotificationRequest notification) {
        var key = UUID.randomUUID();
        kafkaTemplate.send(notificationTopic, key.toString(), notification);
    }
}
