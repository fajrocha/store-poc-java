package com.faroc.customer.application.gateways;

import com.faroc.customer.domain.entities.NotificationRequest;

public interface NotificationGateway {
    void sendNotification(NotificationRequest notification);
}
