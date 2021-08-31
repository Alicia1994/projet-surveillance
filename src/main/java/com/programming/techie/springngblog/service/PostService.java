package com.programming.techie.springngblog.service;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.model.Post;
import java.util.List;

public interface PostService {

    List<PostDto> showAllPosts();

    Post createPost(PostDto postDto);

    PostDto readSinglePost(Long id);

    void deleteSinglePost(Long id);

    Post updateSinglePost(PostDto postDto);

   //List<Post> findPostsByUsername(String username);

}
