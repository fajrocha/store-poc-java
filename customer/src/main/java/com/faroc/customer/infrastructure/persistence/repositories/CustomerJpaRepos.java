package com.faroc.customer.infrastructure.persistence.repositories;

import com.faroc.customer.infrastructure.persistence.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepos extends JpaRepository<Customer, Integer> {
}
