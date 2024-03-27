package com.faroc.fraud.infrastructure.apis;

import com.faroc.fraud.application.gateways.FraudCheckGateway;
import com.faroc.fraud.presentation.config.FraudConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LazyFraudCheckService  implements FraudCheckGateway {
    private final FraudConfig fraudConfig;

    @Override
    public boolean isCustomerFraudulent(String id) {
        return fraudConfig.isFraudulent();
    }
}
