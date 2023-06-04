package org.todoshis.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.todoshis.spring_security.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
