package com.programming.techie.springngblog.controller;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.model.Event;
import com.programming.techie.springngblog.service.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/events")
@RestController

public class EventController {

    @Autowired
    private EventServiceImpl eventServiceImpl;

    @GetMapping("/all")
    public Iterable <Event> showAllEvents() {
        return eventServiceImpl.showAllEvents();
    }

}
