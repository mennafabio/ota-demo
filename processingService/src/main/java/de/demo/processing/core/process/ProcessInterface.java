package de.demo.processing.core.process;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ProcessInterface {

    void processMessage(String message) throws JsonProcessingException;
}
