package com.programming.techie.springngblog.controller;

import Utils.FileUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.model.Post;
import com.programming.techie.springngblog.service.PostService;
import io.grpc.netty.shaded.io.netty.handler.codec.http.multipart.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api/admin")
public class AdminPostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestPart ("post") PostDto postDto, @RequestPart("file") MultipartFile file) throws JsonParseException, IOException {

        String fileName = "";
        String lastFile ="";


        Post post = null;
        if (null != file){
            String [] nameExtension = Objects.requireNonNull(file.getContentType().split("/"));
            fileName = "post-name" + "." + nameExtension[1];
            //  lastFile = postDto.getImage() != null ? postDto.getImage() : "";

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
    public ResponseEntity<Post> updatePost(@RequestPart ("post") PostDto postDto, @RequestPart(value = "file", required = false) MultipartFile file) throws JsonParseException, IOException {


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

/*    @GetMapping("/{username}")
    public ResponseEntity<List<Post>> getPostsByUsername(@PathVariable("username") String username) {
        List<Post> listPosts = postService.findPostsByUsername(username);
        return new ResponseEntity<>(listPosts, HttpStatus.OK);
    }*/

}
