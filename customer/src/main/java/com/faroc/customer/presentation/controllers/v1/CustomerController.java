package com.faroc.customer.presentation.controllers.v1;

import com.faroc.customer.application.cases.RegisterCustomerHandler;
import com.faroc.customer.domain.entities.CustomerRegistration;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final RegisterCustomerHandler registerCustomerHandler;

    @PostMapping()
    public void registerCostumer(@RequestBody CustomerRegistration request) {
        registerCustomerHandler.handle(request);
    }
}
