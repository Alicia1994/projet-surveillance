package com.programming.techie.springngblog.controller;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.service.PostService;
import com.programming.techie.springngblog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
        return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable Long id) {
        return new ResponseEntity<>(postService.readSinglePost(id), HttpStatus.OK);
    }



 /*   @GetMapping("/{username}")
    public ResponseEntity<List<Post>> getPostsByUsername(@PathVariable("username") String username) {
        List<Post> listPosts = postService.findPostsByUsername(username);
        return new ResponseEntity<>(listPosts, HttpStatus.OK);
    }*/


    }
