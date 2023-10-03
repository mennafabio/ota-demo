package de.demo.processing.service;

import de.demo.processing.entitiy.UserEty;
import de.demo.processing.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    private final UserRepository userRepository;

    public ProcessService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserEty userEty) {
        this.userRepository.save(userEty);
        System.out.println("Entity saved successfully");
    }

}
