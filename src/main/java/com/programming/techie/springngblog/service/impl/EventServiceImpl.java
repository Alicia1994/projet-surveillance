package com.programming.techie.springngblog.service.impl;

import com.programming.techie.springngblog.model.Event;
import com.programming.techie.springngblog.repository.EventRepository;
import com.programming.techie.springngblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventServiceImpl {

    @Autowired
    private EventRepository eventRepository;

    public Iterable<Event> showAllEvents(){
        return eventRepository.findAll();
    }

}
