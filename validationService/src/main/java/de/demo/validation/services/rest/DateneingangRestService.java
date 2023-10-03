package de.demo.validation.services.rest;


import de.demo.validation.core.nachrichtvalidieren.impl.ValidierenInterfaceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/dateneingang/v1")
@AllArgsConstructor
public class DateneingangRestService {

    private ValidierenInterfaceImpl nachrichtValidierenImpl;

    @PostMapping(value = "/nachricht")
    public ResponseEntity<String> verarbeiteNachricht(@RequestBody String nachricht) {

        System.out.println(nachricht);
        if (nachricht == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        this.nachrichtValidierenImpl.nachrichtValidieren(nachricht);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}