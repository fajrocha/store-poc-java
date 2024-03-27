package com.faroc.customer.application.gateways;

import com.faroc.customer.domain.entities.CustomerRegistered;
import com.faroc.customer.domain.entities.CustomerRegistration;

public interface CustomerGateway {
    CustomerRegistered saveCustomer(CustomerRegistration customerRegistration);
}
