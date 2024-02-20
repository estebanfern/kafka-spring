package org.efernandez.kafkaspring.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaymentModel {

    @Id
    private String key;
    private String debtor;
    private String creditor;
    private Double amount;

}
