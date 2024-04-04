package com.faroc.customer;

import com.faroc.customer.domain.entities.CustomerRegistered;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

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
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
