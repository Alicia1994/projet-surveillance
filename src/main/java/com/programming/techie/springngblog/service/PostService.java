package com.programming.techie.springngblog.service;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.model.Post;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostService {
    //findById findAll Create Remove

    List<PostDto> showAllPosts();

    void createPost(PostDto postDto);

    PostDto readSinglePost(Long id);

    void deleteSinglePost(Long id);

    Post updateSinglePost(PostDto postDto);
}
