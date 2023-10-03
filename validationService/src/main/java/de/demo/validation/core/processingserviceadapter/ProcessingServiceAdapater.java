package de.demo.validation.core.processingserviceadapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.demo.processing.core.dateneingang.NachrichtTo;

public interface ProcessingServiceAdapater {

    void sendeNachricht(NachrichtTo nachricht) throws JsonProcessingException;
}
