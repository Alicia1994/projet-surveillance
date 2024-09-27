package com.programming.techie.springngblog.controller;

import Utils.FileUtil;
import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.model.Post;
import com.programming.techie.springngblog.model.User;
import com.programming.techie.springngblog.repository.UserRepository;
import com.programming.techie.springngblog.service.PostService;
import com.programming.techie.springngblog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PostService postService;

    /* HANDLE POSTS */
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestPart("post") PostDto postDto,
                                           @RequestPart("file") MultipartFile file)
            throws IOException {
        String fileName = "";
        Post post = null;
        if (null != file){
            String [] nameExtension = Objects.requireNonNull(file.getContentType().split("/"));
            fileName = "post-name" + "." + nameExtension[1];
            postDto.setImage(fileName);
            post = postService.createPost(postDto);
            FileUtil.saveImages(post.getId(), fileName, file);
        }
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deleteSinglePost(id);
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestPart ("post") PostDto postDto,
                                           @RequestPart(value = "file", required = false) MultipartFile file)
            throws IOException {
        String fileName = "";
        String lastFile ="";
        Post post = null;
        if (file == null){
            post = postService.updateSinglePost(postDto);
        } else {
            String [] nameExtension = Objects.requireNonNull(file.getContentType().split("/"));
            fileName = "post-name" + "." + nameExtension[1];
           lastFile = postDto.getImage() != null ? postDto.getImage() : "";
            postDto.setImage(fileName);
            post = postService.updateSinglePost(postDto);
            FileUtil.saveFileAndReplace(lastFile, file, fileName, post.getId());
        }
        return new ResponseEntity(post, HttpStatus.OK);
    }

    /* HANDLE ADMINS */
    @GetMapping("/list/admins")
    public Iterable<User> listAdmin() {
        return userServiceImpl.getAllAdmin();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
    }

    /* HANDLE USERS */
    @GetMapping("/list/users")
    public Iterable<User> listUser() {
        return userServiceImpl.getAllUsers();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
    }
}
