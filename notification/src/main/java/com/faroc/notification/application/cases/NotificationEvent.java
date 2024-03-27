package com.faroc.notification.application.cases;

import org.springframework.context.ApplicationEvent;
import com.faroc.notification.domain.NotificationRegistration;

public class NotificationEvent extends ApplicationEvent {
    private final NotificationRegistration notificationRequest;

    public NotificationEvent(Object source, NotificationRegistration notificationRequest) {
        super(source);
        this.notificationRequest = notificationRequest;
    }

    public NotificationRegistration getNotification() {
        return notificationRequest;
    }
}
