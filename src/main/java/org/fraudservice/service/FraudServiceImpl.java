package org.fraudservice.service;


import org.fraudservice.dto.FraudCheckRequest;
import org.fraudservice.dto.FraudCheckResponse;
import org.fraudservice.repository.FraudCheckRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class FraudCheckService implements FraudService{

    private static final BigDecimal HIGH_RISK_THRESHOLD = BigDecimal.valueOf(8000);
    private static final BigDecimal MEDIUM_RISK_THRESHOLD = BigDecimal.valueOf(5000);

    private final FraudCheckRepository fraudCheckRepository;
    private static final Logger log = LoggerFactory.getLogger(FraudCheckService.class);




    public FraudCheckService(FraudCheckRepository fraudCheckRepository) {
        this.fraudCheckRepository = fraudCheckRepository;
    }

    @Override
    public FraudCheckResponse evaluateTransfer(FraudCheckRequest request) {

        if (request == null || request.getAmount() == null) {
            throw InvalidRequestException();
        }

        if (request.getFromAccountId() == null ||
            request.getToAccountId() == null) {
            throw new
        }

        if (request.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            throw new
        }

        if (Objects.equals(request.getFromAccountId(), request.getToAccountId())) {
            throw new
        }

        if (request.getAmount().compareTo(MEDIUM_RISK_THRESHOLD) >= 0) {

        }
    }

}
