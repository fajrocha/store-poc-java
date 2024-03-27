package com.faroc.fraud.infrastructure.persistence.repositories;

import com.faroc.fraud.application.gateways.FraudCheckSaveGateway;
import com.faroc.fraud.domain.entities.FraudCheckResult;
import com.faroc.fraud.infrastructure.persistence.entities.FraudCheckHistory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
@AllArgsConstructor
public class FraudRepositoryGateway implements FraudCheckSaveGateway {
    private final FraudJpaRepository repository;

    @Override
    public void saveFraudCheck(FraudCheckResult fraudCheckResult) {

        var fraudCheckResultToSave = FraudCheckHistory.builder()
                .customerEmail(fraudCheckResult.customerEmail())
                .isFraudster(fraudCheckResult.result())
                .createdAt(Instant.now())
                .build();

        repository.save(fraudCheckResultToSave);
    }
}
