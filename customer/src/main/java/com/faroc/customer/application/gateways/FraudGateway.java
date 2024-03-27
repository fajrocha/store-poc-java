package com.faroc.customer.application.gateways;

import com.faroc.clients.fraud.responses.FraudCheckResponse;

public interface FraudGateway {
    FraudCheckResponse checkFraudulentCustomer(String customerEmail);
}
