package com.faroc.notification.application.cases;

import com.faroc.kafka.contracts.NotificationRequest;
import org.springframework.context.ApplicationEvent;

public class NotificationEvent extends ApplicationEvent {
    private final NotificationRequest notificationRegistration;

    public NotificationEvent(Object source, NotificationRequest notificationRegistration) {
        super(source);
        this.notificationRegistration = notificationRegistration;
    }

    public NotificationRequest getNotification() {
        return notificationRegistration;
    }
}
