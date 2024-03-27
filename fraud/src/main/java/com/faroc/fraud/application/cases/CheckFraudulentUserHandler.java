package com.faroc.fraud.application.cases;

import com.faroc.clients.fraud.responses.FraudCheckResponse;
import com.faroc.fraud.application.gateways.FraudCheckGateway;
import com.faroc.fraud.application.gateways.FraudCheckSaveGateway;
import com.faroc.fraud.domain.entities.FraudCheckResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CheckFraudulentUserHandler {
    private final FraudCheckGateway fraudCheckGateway;
    private final FraudCheckSaveGateway fraudCheckSaveGateway;

    public FraudCheckResponse handle(String customerString) {
        log.info("Checking fraud for customer with id {}", customerString);
        var isFraudulent = fraudCheckGateway.isCustomerFraudulent(customerString);

        if (isFraudulent)
            log.warn("The customer with id {} failed validation.", customerString);

        var fraudCheckResult = new FraudCheckResult(customerString, isFraudulent);
        fraudCheckSaveGateway.saveFraudCheck(fraudCheckResult);

        return new FraudCheckResponse(isFraudulent);
    }
}
