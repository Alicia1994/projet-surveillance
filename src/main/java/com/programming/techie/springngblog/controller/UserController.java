package com.programming.techie.springngblog.controller;

import com.programming.techie.springngblog.dto.UserDto;
import com.programming.techie.springngblog.model.User;
import com.programming.techie.springngblog.repository.UserRepository;
import com.programming.techie.springngblog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/users")
@RestController

public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public User user(@PathVariable long id) { return  userServiceImpl.getUserById(id);}

    @GetMapping("/name/{username}")
    public User username(@PathVariable String username) { return  userServiceImpl.getUserByUsername(username);}

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
    }


 /*      @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto ) {
        User user = userServiceImpl.updateSingleUser(userDto);
        return new ResponseEntity(user, HttpStatus.OK);
    }*/

}




/*    @PostMapping("/{username}")
    public ResponseEntity<User> addUserInPost(@PathVariable("username") String username, @RequestBody Post post) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       // UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
       // String TokenUserUsername = userDetails.getUsername();
        *//*if(username == TokenUserUsername ) {*//*
            userServiceImpl.addUserInPost(username, post);
            return new ResponseEntity<>(HttpStatus.OK);
       *//* }else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }*//*

    }*/
