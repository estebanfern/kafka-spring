package org.efernandez.kafkaspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@AllArgsConstructor
public class ConfigController {

    private final KafkaProperties kafkaProperties;

    @GetMapping
    private KafkaProperties getConfig() {
        return kafkaProperties;
    }

}
