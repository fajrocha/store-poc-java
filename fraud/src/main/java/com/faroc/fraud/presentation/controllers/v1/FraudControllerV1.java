package com.faroc.fraud.presentation.controllers.v1;

import com.faroc.clients.fraud.responses.FraudCheckResponse;
import com.faroc.fraud.application.cases.CheckFraudulentUserHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud")
@AllArgsConstructor
public class FraudControllerV1 {
    private final CheckFraudulentUserHandler handler;

    @GetMapping("{customerEmail}")
    public FraudCheckResponse getFraudulentCustomerValidation(@PathVariable("customerEmail") String customerEmail) {
        return handler.handle(customerEmail);
    }
}
