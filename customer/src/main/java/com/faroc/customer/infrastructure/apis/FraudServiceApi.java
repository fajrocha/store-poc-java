package com.faroc.customer.infrastructure.apis;

import com.faroc.clients.fraud.FraudClient;
import com.faroc.clients.fraud.responses.FraudCheckResponse;
import com.faroc.customer.application.gateways.FraudGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FraudServiceApi implements FraudGateway {
    private final FraudClient client;

    @Override
    public FraudCheckResponse checkFraudulentCustomer(String customerEmail) {
        return client.getFraudulentCustomerValidationV1(customerEmail);
    }
}
