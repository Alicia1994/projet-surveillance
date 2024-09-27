package com.programming.techie.springngblog.repository;

import com.programming.techie.springngblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Iterable <User> findByRole(String role);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);


}
