package org.efernandez.kafkaspring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.efernandez.kafkaspring.dao.entity.PaymentModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class PaymentProducerService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentProducerService.class);
    public static final String TOPIC = "payments";

    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper;

    public PaymentModel sendPayment(PaymentModel paymentModel) throws JsonProcessingException {
        String key = UUID.randomUUID().toString();
        paymentModel.setKey(key);
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, key, objectMapper.writeValueAsString(paymentModel));

        future.whenComplete((sendResult, ex) -> {
            if (ex == null) {
                logger.info("Message sent successfully for the key: " + key + " and the value is " + paymentModel);
            } else {
                logger.error("Error sending the message and the exception is " + ex.getMessage());
                throw new RuntimeException(ex.getMessage());
            }
        });

        return paymentModel;
    }

}
