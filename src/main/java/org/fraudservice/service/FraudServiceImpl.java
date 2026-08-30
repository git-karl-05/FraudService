package org.fraudservice.service;


import jakarta.persistence.*;
import org.fraudservice.dto.FraudCheckRequest;
import org.fraudservice.dto.FraudCheckResponse;
import org.fraudservice.entity.FraudCheckEntity;
import org.fraudservice.entity.FraudDecision;
import org.fraudservice.entity.RiskLevel;
import org.fraudservice.exception.InvalidFraudCheckRequestException;
import org.fraudservice.repository.FraudCheckRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class FraudServiceImpl implements FraudService{

    private static final BigDecimal HIGH_RISK_THRESHOLD = BigDecimal.valueOf(8000);
    private static final BigDecimal MEDIUM_RISK_THRESHOLD = BigDecimal.valueOf(5000);

    private final FraudCheckRepository fraudCheckRepository;
    private static final Logger log = LoggerFactory.getLogger(FraudServiceImpl.class);




    public FraudServiceImpl(FraudCheckRepository fraudCheckRepository) {
        this.fraudCheckRepository = fraudCheckRepository;
    }

    @Override
    public FraudCheckResponse evaluateTransfer(FraudCheckRequest request) {

        validateRequest(request);

        FraudCheckEntity fraudCheck = new FraudCheckEntity();
        fraudCheck.setFromAccountId(request.getFromAccountId());
        fraudCheck.setToAccountId(request.getToAccountId());
        fraudCheck.setAmount(request.getAmount());

        if (request.getAmount().compareTo(HIGH_RISK_THRESHOLD) > 0) {

            fraudCheck.setDecision(FraudDecision.REJECTED);
            fraudCheck.setRiskLevel(RiskLevel.HIGH);
            fraudCheck.setReason("");

        } else if (request.getAmount().compareTo(MEDIUM_RISK_THRESHOLD) > 0) {

            fraudCheck.setDecision(FraudDecision.APPROVED);
            fraudCheck.setRiskLevel(RiskLevel.MEDIUM);
            fraudCheck.setReason("Transfer requires elevated monitoring");

        } else {

            fraudCheck.setDecision(FraudDecision.APPROVED);
            fraudCheck.setRiskLevel(RiskLevel.LOW);
            fraudCheck.setReason("Transfer passed fraud screening");

        }

        FraudCheckEntity savedFraudCheck = fraudCheckRepository.save(fraudCheck);
        return new FraudCheckResponse(savedFraudCheck);
    }

    private void validateRequest(FraudCheckRequest request) {
        if (request == null) {
            throw new InvalidFraudCheckRequestException("Fraud check cannot be null");
        }

        if (request.getFromAccountId() == null ||
                request.getToAccountId() == null) {
            throw new InvalidFraudCheckRequestException("Source and destination accounts are required");
        }

        if (request.getAmount() == null ||
                request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidFraudCheckRequestException("Transfer amount must be greater than zero");
        }

    }
}
