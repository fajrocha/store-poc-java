package com.faroc.customer;

import com.faroc.customer.domain.entities.CustomerRegistered;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication(
        scanBasePackages = {
                "com.faroc.customer",
                "com.faroc.amqp",
                "com.faroc.kafka",
        }
)
@EnableFeignClients(
        basePackages = "com.faroc.clients"
)
public class CustomerApplication {

    @Value("${spring.kafka.app.topics.notification}")
    private String notificationTopic;

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        var data = new CustomerRegistered(1,"10", "faroc@banana.com");
        return args -> kafkaTemplate.send(notificationTopic, data.toString());
    }
}
