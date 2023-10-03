package de.demo.processing.core.process.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.demo.processing.core.dateneingang.NachrichtTo;
import de.demo.processing.core.process.ProcessInterface;
import de.demo.processing.entitiy.UserEty;
import de.demo.processing.service.ProcessService;
import org.springframework.stereotype.Component;

@Component
public class ProcessImpl implements ProcessInterface {

    private final ProcessService processService;

    private final ObjectMapper objectMapper;

    public ProcessImpl(ProcessService processService, ObjectMapper objectMapper) {
        this.processService = processService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void processMessage(String message) throws JsonProcessingException {
        var mappedNachricht = objectMapper.readValue(message, NachrichtTo.class);
        var transformedNachricht = transformMessage(mappedNachricht);

        this.processService.saveUser(transformedNachricht);
    }

    private UserEty transformMessage(NachrichtTo mappedNachricht) {
        var userEty = new UserEty();
        userEty.setVorname(mappedNachricht.getPersonendaten().getVorname());
        userEty.setNachname(mappedNachricht.getPersonendaten().getNachname());
        userEty.setAnschrift(mappedNachricht.getPersonendaten().getAnschrift());
        userEty.setGeburtsdatum(mappedNachricht.getPersonendaten().getGeburtsdatum());
        userEty.setAusweisnr(mappedNachricht.getPersonendaten().getAusweisnr());

        return userEty;
    }
}
