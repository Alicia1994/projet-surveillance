package com.programming.techie.springngblog.service.impl;

import com.programming.techie.springngblog.common.UserConstant;
import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.dto.UserDto;
import com.programming.techie.springngblog.exception.PostNotFoundException;
import com.programming.techie.springngblog.model.Post;
import com.programming.techie.springngblog.model.User;
import com.programming.techie.springngblog.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.UserDataHandler;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public Iterable<com.programming.techie.springngblog.model.User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(IllegalArgumentException::new);
    }

    public void deleteUser(Long id){
       userRepository.deleteById(id);
    }

    public Iterable<com.programming.techie.springngblog.model.User> getAllAdmin() {
        return userRepository.findByRole(UserConstant.ADMIN_ACCESS);
    }

    public User updateSingleUser(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        return userRepository.save(user);
    }

}