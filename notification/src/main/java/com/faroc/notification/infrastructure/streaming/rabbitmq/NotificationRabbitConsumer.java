package com.faroc.notification.infrastructure.streaming.rabbitmq;

import com.faroc.kafka.contracts.NotificationRequest;
import com.faroc.notification.application.cases.NotificationEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationRabbitConsumer {
    private final ApplicationEventPublisher publisher;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void save(NotificationRequest request) {
        log.info("Received the following content {}", request);

        var event = new NotificationEvent(this, request);
        publisher.publishEvent(event);
    }
}
