package org.fraudservice.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "fraud_checks")
public class FraudCheckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fraudCheckId;

    @Column(nullable = false)
    private Long fromAccountId;

    @Column(nullable = false)
    private Long toAccountId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FraudDecision decision;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RiskLevel riskLevel;

    private String reason;

    public FraudCheckEntity() {}

    public Long getFraudCheckId() {
        return fraudCheckId;
    }

    public void setFraudCheckId(Long fraudCheckId) {
        this.fraudCheckId = fraudCheckId;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
