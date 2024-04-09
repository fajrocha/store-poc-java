package com.faroc.notification.infrastructure.persistence.notification;

import com.faroc.kafka.contracts.NotificationRequest;
import com.faroc.notification.application.gateways.NotificationGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationJpaGateway implements NotificationGateway {
    private final NotificationJpaRepository repository;

    @Override
    public void save(NotificationRequest request) {

        var notification = Notification.builder()
                .toCustomerId(request.id())
                .toCustomerEmail(request.email())
                .message(request.message())
                .sender("faroc")
                .sentAt(Instant.now())
                .build();

        repository.save(notification);
    }
}
