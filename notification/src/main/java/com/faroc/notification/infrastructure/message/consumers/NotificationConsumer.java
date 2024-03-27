package com.faroc.notification.infrastructure.message.consumers;

import com.faroc.notification.application.cases.NotificationEvent;
import com.faroc.notification.domain.NotificationRegistration;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final ApplicationEventPublisher publisher;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void save(NotificationRegistration request) {
        log.info("Received the following content {}", request);

        var event = new NotificationEvent(this, request);
        publisher.publishEvent(event);
    }
}
