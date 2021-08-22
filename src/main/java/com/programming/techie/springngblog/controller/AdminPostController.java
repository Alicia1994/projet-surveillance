package com.programming.techie.springngblog.controller;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.model.Post;
import com.programming.techie.springngblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin")
public class AdminPostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deleteSinglePost(id);
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody PostDto postDto ) {
        Post post = postService.updateSinglePost(postDto);

        return new ResponseEntity(post, HttpStatus.OK);
    }

}
