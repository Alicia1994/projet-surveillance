package com.programming.techie.springngblog.controller;


import com.programming.techie.springngblog.model.User;
import com.programming.techie.springngblog.repository.UserRepository;
import com.programming.techie.springngblog.security.jwt.JwtProvider;
import com.programming.techie.springngblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/users")
@RestController

public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public Iterable<User> listUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/admin")
    public Iterable<User> listAdmin() {
        return userService.getAllAdmin();
    }


   /* @GetMapping("/{id}")
    public User user(@PathVariable long id) { return  userService.getUserById(id);}

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MODERATOR')");
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteSinglePost(id);
    }
*/

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
