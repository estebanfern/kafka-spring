package org.efernandez.kafkaspring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.efernandez.kafkaspring.dao.entity.PaymentModel;
import org.efernandez.kafkaspring.dao.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentConsumerService {

    private final static Logger logger = LoggerFactory.getLogger(PaymentConsumerService.class);

    private PaymentRepository paymentRepository;
    private ObjectMapper objectMapper;

    @KafkaListener(id = "spring-payment-consumer", topics = PaymentProducerService.TOPIC, groupId = "spring-payment-consumer", autoStartup = "true")
    public void listen(
            String value,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_KEY) String key
    ) throws JsonProcessingException {
        logger.info(String.format("Consumed event from topic %s: key = %-10s value = %s", topic, key, value));
        final PaymentModel paymentModel = objectMapper.readValue(value, PaymentModel.class);
        paymentRepository.save(paymentModel);
    }

}
