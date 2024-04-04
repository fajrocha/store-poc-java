package com.faroc.notification.application.cases;

import com.faroc.notification.application.gateways.NotificationGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RegistrationNotificationCase {
    private final NotificationGateway notificationGateway;

    @EventListener
    public void handleUserRegistrationEvent(NotificationEvent event) {
        var notification = event.getNotification();

        notificationGateway.save(notification);
    }
}
