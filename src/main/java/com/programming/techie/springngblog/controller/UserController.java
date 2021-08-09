package com.programming.techie.springngblog.controller;


import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.dto.UserDto;
import com.programming.techie.springngblog.model.Post;
import com.programming.techie.springngblog.model.User;
import com.programming.techie.springngblog.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/users")
@RestController

public class UserController {


    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping("")
    public Iterable<User> listUser() {
        return userDetailsServiceImpl.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userDetailsServiceImpl.deleteSinglePost(id);
    }
/*

    @GetMapping("/{id}")
    public User user(@PathVariable long id) { return  userDetailsServiceImpl.getUserById(id);}
*/

  /*  @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto ) {
        User user = userDetailsServiceImpl.updateSingleUser(userDto);
        return new ResponseEntity(user, HttpStatus.OK);
    }*/

/*
    @GetMapping("/{id}")
    public User user(@PathVariable long id) { return  userDetailsServiceImpl.getUserById(id);}*/

/*

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> listUsers = userService.findAllUsers();
        return new ResponseEntity<>(listUsers, HttpStatus.OK);
    }

*/
/*
    @GetMapping("/{id}")
    public ResponseEntity <User> getById(@PathVariable Long id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

}
