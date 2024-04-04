package com.faroc.customer.application.gateways;

import com.faroc.kafka.contracts.NotificationRequest;

public interface NotificationGateway {
    void sendNotification(NotificationRequest notification);
}
