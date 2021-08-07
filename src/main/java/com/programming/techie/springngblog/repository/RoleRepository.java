package com.programming.techie.springngblog.repository;

import com.programming.techie.springngblog.model.ERole;
import com.programming.techie.springngblog.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long>  {
    Optional<Role> findByName(ERole name);
}
