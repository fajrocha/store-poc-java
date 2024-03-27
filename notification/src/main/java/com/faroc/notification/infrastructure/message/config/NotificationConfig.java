package com.faroc.notification.infrastructure.message.config;

import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("rabbitmq")
@Data
public class NotificationConfig {
    private ExchangesConfig exchanges;
    private QueueConfig queue;
    private RoutingKeyConfig routingKeys;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(exchanges.getInternal());
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(queue.getNotification());
    }

    @Bean
    public Binding internalExchangeToNotificationQueue() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(internalTopicExchange())
                .with(routingKeys.getInternalNotification());
    }
}

