package org.fraudservice.repository;


import org.fraudservice.entity.FraudCheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface FraudCheckRepository extends JpaRepository <FraudCheckEntity, Long> {
}
