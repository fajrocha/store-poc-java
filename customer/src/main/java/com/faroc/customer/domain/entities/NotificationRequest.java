package com.faroc.customer.domain.entities;

import lombok.Builder;

@Builder
public record NotificationRequest(int id, String email, String message) {
}
