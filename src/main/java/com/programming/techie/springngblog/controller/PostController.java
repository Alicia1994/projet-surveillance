package com.programming.techie.springngblog.controller;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.model.Post;
import com.programming.techie.springngblog.model.User;
import com.programming.techie.springngblog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
        return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable Long id) {
        return new ResponseEntity<>(postService.readSinglePost(id), HttpStatus.OK);
    }

 /*   @GetMapping("/{id}/user")
            public ResponseEntity<List<Post>> getPostByUserId(@PathVariable("id") Long id){
        List<Post> listPosts = postService.findPostsByUserId(id);
        return new ResponseEntity<>(listPosts, HttpStatus.OK);
    }*/

   /* @GetMapping("/name/{username}")
    public Post username(@PathVariable String username) { return postService.getPostByUsername(username);}*/


}