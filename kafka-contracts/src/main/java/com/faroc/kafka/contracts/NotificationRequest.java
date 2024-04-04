package com.faroc.kafka.contracts;

public record NotificationRequest(int id, String email, String message) {
}
