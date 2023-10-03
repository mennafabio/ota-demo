package de.demo.validation.core.nachrichtvalidieren.impl;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.demo.processing.core.dateneingang.NachrichtTo;
import de.demo.validation.core.nachrichtvalidieren.ValidierenInterface;
import de.demo.validation.core.processingserviceadapter.ProcessingServiceAdapater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidierenInterfaceImpl implements ValidierenInterface {

    private final ObjectMapper objectMapper;

    private final ProcessingServiceAdapater processingServiceAdapater;

    public void nachrichtValidieren(String nachricht) {

        if (isValidJsonFormat(nachricht)) {

            try {
                final var nachrichtTo = objectMapper.readValue(nachricht, NachrichtTo.class);

                processingServiceAdapater.sendeNachricht(nachrichtTo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isValidJsonFormat(String nachricht) {
        try {
            objectMapper.readTree(nachricht);
        } catch (JacksonException e) {
            return false;
        }
        return true;
    }

}