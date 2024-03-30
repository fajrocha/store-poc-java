package com.faroc.clients.fraud;

import com.faroc.clients.fraud.responses.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;

@FeignClient(
        name = "fraud"
)
public interface FraudClient {
    @GetMapping("/api/v1/fraud/{customerEmail}")
    FraudCheckResponse getFraudulentCustomerValidationV1(@PathVariable("customerEmail") String customerEmail);
}
