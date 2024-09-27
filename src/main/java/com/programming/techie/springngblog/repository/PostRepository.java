package com.programming.techie.springngblog.repository;

import com.programming.techie.springngblog.model.Post;
import com.programming.techie.springngblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByUsername(String username);
}
