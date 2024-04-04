package com.faroc.customer.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "${spring.kafka.app.topics.notification}", groupId = "test")
    void listener(String data) {
        log.info("Received the following data from Kafka: {}", data);
    }
}
