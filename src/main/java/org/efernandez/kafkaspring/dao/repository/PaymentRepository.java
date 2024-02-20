package org.efernandez.kafkaspring.dao.repository;

import org.efernandez.kafkaspring.dao.entity.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, String> {
}
