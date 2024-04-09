package com.faroc.notification.infrastructure.streaming.kafka;

import com.faroc.kafka.contracts.NotificationRequest;
import com.faroc.notification.application.cases.NotificationEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationKafkaConsumer {
    private final ApplicationEventPublisher publisher;

    @KafkaListener(topics = "${spring.kafka.app.topics.notification}")
    void listener(NotificationRequest notificationRegistration) {
        log.info("Received the following notification from Kafka: {}", notificationRegistration);

        var event = new NotificationEvent(this, notificationRegistration);
        publisher.publishEvent(event);
    }
}