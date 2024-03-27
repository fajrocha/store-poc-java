package com.faroc.customer.application.cases;

import com.faroc.customer.application.gateways.CustomerGateway;
import com.faroc.customer.application.gateways.FraudGateway;
import com.faroc.customer.application.gateways.NotificationGateway;
import com.faroc.customer.domain.entities.CustomerRegistration;
import com.faroc.customer.domain.entities.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RegisterCustomerHandler {
    private final CustomerGateway customerGateway;
    private final FraudGateway fraudGateway;
    private final NotificationGateway notificationGateway;

    public void handle(CustomerRegistration customer) {
        var customerEmail = customer.email();
        var fraudResponse = fraudGateway.checkFraudulentCustomer(customerEmail);

        if (fraudResponse.isFraudulent())
            throw new IllegalStateException("Customer with email " + customerEmail + " is fraudulent");

        var customerRegistered = customerGateway.saveCustomer(customer);

        var notification = new NotificationRequest(
                customerRegistered.id(),
                customerRegistered.email(),
                String.format("Hi Mr. %s! Welcome to store!", customerRegistered.firstName()));

        notificationGateway.sendNotification(notification);
    }

}
