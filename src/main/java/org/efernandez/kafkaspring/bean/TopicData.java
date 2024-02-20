package org.efernandez.kafkaspring.bean;

import lombok.Data;

@Data
public class TopicData {
    private String serializer;
    private String deserializer;
}
