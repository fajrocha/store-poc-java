package com.faroc.customer.infrastructure.persistence.repositories;

import com.faroc.customer.application.gateways.CustomerGateway;
import com.faroc.customer.domain.entities.CustomerRegistered;
import com.faroc.customer.domain.entities.CustomerRegistration;
import com.faroc.customer.infrastructure.persistence.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerGatewayRepository implements CustomerGateway {
    private final CustomerJpaRepos repository;

    @Override
    public CustomerRegistered saveCustomer(CustomerRegistration customerRegistration) {
        var customer = Customer.builder()
                .firstName(customerRegistration.firstName())
                .lastName(customerRegistration.lastName())
                .email(customerRegistration.email())
                .build();

        var customerRegistered = repository.save(customer);

        return new CustomerRegistered(
                customerRegistered.getId(),
                customerRegistered.getFirstName(),
                customerRegistered.getEmail());
    }
}
