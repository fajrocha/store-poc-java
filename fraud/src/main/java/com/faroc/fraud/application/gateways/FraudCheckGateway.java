package com.faroc.fraud.application.gateways;

public interface FraudCheckGateway {
    boolean isCustomerFraudulent(String id);
}
