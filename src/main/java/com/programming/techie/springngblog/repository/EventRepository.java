package com.programming.techie.springngblog.repository;

import com.programming.techie.springngblog.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository  extends JpaRepository<Event, Long> {
}
