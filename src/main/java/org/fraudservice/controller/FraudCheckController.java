package org.fraudservice.controller;


import org.fraudservice.dto.FraudCheckRequest;
import org.fraudservice.dto.FraudCheckResponse;
import org.fraudservice.service.FraudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/evaluateTransfer")
public class FraudCheckController {

    private final FraudService fraudService;

    public FraudCheckController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @PostMapping("/check")
    public ResponseEntity<FraudCheckResponse> evaluateTransfer(@RequestBody FraudCheckRequest request) {
        return ResponseEntity.ok(fraudService.evaluateTransfer(request));
    }
}
