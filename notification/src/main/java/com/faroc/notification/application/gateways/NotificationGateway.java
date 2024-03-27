package com.faroc.notification.application.gateways;

import com.faroc.notification.domain.NotificationRegistration;

public interface NotificationGateway {
    void save(NotificationRegistration request);
}
