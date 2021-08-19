package com.programming.techie.springngblog.controller;


import com.programming.techie.springngblog.model.User;
import com.programming.techie.springngblog.repository.UserRepository;
import com.programming.techie.springngblog.security.service.UserDetailsImpl;
import com.programming.techie.springngblog.service.UserService;
import com.programming.techie.springngblog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/users")
@RestController

public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepository userRepository;

    /* HANDLE USERS */
    @GetMapping("")
    public Iterable<User> listUser() {
        return userServiceImpl.getAllUsers();
    }

    @GetMapping("/{id}")
    public User user(@PathVariable long id) { return  userServiceImpl.getUserById(id);}

    @GetMapping("/name/{username}")
    public User username(@PathVariable String username) { return  userServiceImpl.getUserByUsername(username);}

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
    }

   /* HANDLE ADMINS */
    @DeleteMapping("/admin/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
    }

    @GetMapping("/admin")
    public Iterable<User> listAdmin() {
        return userServiceImpl.getAllAdmin();
    }

      /* @PostMapping("/{id}/infos")
    public ResponseEntity<User> addUserDetails(@PathVariable("id") Long id, @RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Long TokenUserId = userDetails.getId();
        if(id == TokenUserId ) {
            userService.addUserDetails(id, user);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }*/
    //}

  /*  @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto ) {
        User user = userDetailsServiceImpl.updateSingleUser(userDto);
        return new ResponseEntity(user, HttpStatus.OK);
    }*/

}
