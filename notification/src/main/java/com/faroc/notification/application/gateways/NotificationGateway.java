package com.faroc.notification.application.gateways;

import com.faroc.kafka.contracts.NotificationRequest;

public interface NotificationGateway {
    void save(NotificationRequest request);
}
