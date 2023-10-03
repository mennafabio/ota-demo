package de.demo.processing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.Locale;

@EnableKafka
@SpringBootApplication(scanBasePackages = "de.demo")
public class ProcessingServiceApplication {

    /***
     * Die Start-Methode der Anwendung
     * @param args Kommandozeile der Argumente
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY);
        SpringApplication.run(ProcessingServiceApplication.class, args);
    }
}
