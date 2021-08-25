package com.programming.techie.springngblog.controller;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.model.Post;
import com.programming.techie.springngblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

/*    @GetMapping("/{username}")
    public ResponseEntity<List<Post>> getPostsByUsername(@PathVariable("username") String username) {
        List<Post> listPosts = postService.findPostsByUsername(username);
        return new ResponseEntity<>(listPosts, HttpStatus.OK);
    }*/

}
