package org.fraudservice.dto;

import org.fraudservice.entity.FraudDecision;
import org.fraudservice.entity.RiskLevel;

public class FraudCheckResponse {

    private Long fraudCheckId;
    private FraudDecision decision;
    private RiskLevel riskLevel;
    private String reason;

    public FraudCheckResponse(){}

    public FraudCheckResponse(Long fraudCheckId, FraudDecision decision, RiskLevel riskLevel, String reason) {
        this.fraudCheckId = fraudCheckId;
        this.decision = decision;
        this.riskLevel = riskLevel;
        this.reason = reason;
    }

    public Long getFraudCheckId() {
        return fraudCheckId;
    }

    public void setFraudCheckId(Long fraudCheckId) {
        this.fraudCheckId = fraudCheckId;
    }

    public FraudDecision getDecision() {
        return decision;
    }

    public void setDecision(FraudDecision decision) {
        this.decision = decision;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
