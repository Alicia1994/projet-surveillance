package com.programming.techie.springngblog.controller;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.model.Post;
import com.programming.techie.springngblog.model.User;
import com.programming.techie.springngblog.service.PostService;
import com.programming.techie.springngblog.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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



    @GetMapping("/{username}")
            public Post getPostByUsername(@PathVariable("username") final String username){
        Optional<Post> post = postService.getPost(username);
        if (post.isPresent()){
            return post.get();
        } else {
            return null;
        }
     /*   User user = userService.getUserByUsername(username);
        return new ResponseEntity<>( user.getPostList(), HttpStatus.OK);*/
    }



   /* @GetMapping("/name/{username}")
    public Post username(@PathVariable String username) { return postService.getPostByUsername(username);}*/


}