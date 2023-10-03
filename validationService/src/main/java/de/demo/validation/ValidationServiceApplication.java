package de.demo.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.Locale;

@EnableKafka
@SpringBootApplication
public class ValidationServiceApplication {

    /***
     * Die Start-Methode der Anwendung
     * @param args Kommandozeile der Argumente
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY);
        SpringApplication.run(ValidationServiceApplication.class, args);
    }

}
