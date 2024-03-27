package com.faroc.fraud.infrastructure.persistence.repositories;

import com.faroc.fraud.infrastructure.persistence.entities.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudJpaRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
