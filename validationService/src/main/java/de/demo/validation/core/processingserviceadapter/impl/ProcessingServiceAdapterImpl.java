package de.demo.validation.core.processingserviceadapter.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.demo.processing.core.dateneingang.NachrichtTo;
import de.demo.validation.core.processingserviceadapter.ProcessingServiceAdapater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProcessingServiceAdapterImpl implements ProcessingServiceAdapater {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    @Value("${topic.name.producer:nachricht_verarbeiten}")
    private String topic;

    @Autowired
    public ProcessingServiceAdapterImpl(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendeNachricht(NachrichtTo nachricht) throws JsonProcessingException {
        var serializedMessage = objectMapper.writeValueAsString(nachricht);
        kafkaTemplate.send(this.topic, serializedMessage);
    }

}
