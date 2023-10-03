package de.demo.processing.repository;

import de.demo.processing.entitiy.UserEty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<UserEty, Long> {
}
