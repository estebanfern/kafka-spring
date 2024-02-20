package org.efernandez.kafkaspring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.efernandez.kafkaspring.dao.entity.PaymentModel;
import org.efernandez.kafkaspring.service.PaymentProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {

    private PaymentProducerService paymentService;

    @PostMapping
    public PaymentModel pay(@RequestBody PaymentModel payment) throws JsonProcessingException {
        return paymentService.sendPayment(payment);
    }

}
