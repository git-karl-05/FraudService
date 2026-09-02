package org.fraudservice.service;

import org.fraudservice.dto.FraudCheckRequest;
import org.fraudservice.dto.FraudCheckResponse;

public interface FraudService {

    public FraudCheckResponse evaluateTransfer(FraudCheckRequest request) throws Exception;
}
