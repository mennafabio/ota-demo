package de.demo.processing.service.dateneingang.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.demo.processing.core.process.ProcessInterface;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Der nach außen angebotene asynchrone Service für Nachricht-Anlieferungen.
 */
@Component
public class DateneingangMessagingService {

    private final ProcessInterface processInterface;

    public DateneingangMessagingService(ProcessInterface processInterface) {
        this.processInterface = processInterface;
    }

    @Value("${topic.name.consumer:nachricht_verarbeiten")
    private String topicName;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id_nachricht")
    public void empfangeMeldung(ConsumerRecord<String, String> payload) throws JsonProcessingException {

        System.out.println("topic:" + topicName);
        System.out.println(payload.value());
        this.processInterface.processMessage(payload.value());
    }

}
