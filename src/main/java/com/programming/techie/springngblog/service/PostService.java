package com.programming.techie.springngblog.service;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.model.Post;
import com.programming.techie.springngblog.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PostService {
    //findById findAll Create Remove

    List<PostDto> showAllPosts();

    //Optional<Post> getPost(String username);

    //User savePost(Post post, String Username);

    Post createPost(PostDto postDto);

    PostDto readSinglePost(Long id);

    void deleteSinglePost(Long id);

    Post updateSinglePost(PostDto postDto);

   //List<Post> findPostsByUsername(String username);

}
