package com.faroc.fraud.application.gateways;

import com.faroc.fraud.domain.entities.FraudCheckResult;

public interface FraudCheckSaveGateway {
    void saveFraudCheck(FraudCheckResult fraudCheck);
}
