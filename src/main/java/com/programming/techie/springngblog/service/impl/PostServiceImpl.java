package com.programming.techie.springngblog.service.impl;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.exception.PostNotFoundException;
import com.programming.techie.springngblog.model.Post;
import com.programming.techie.springngblog.repository.PostRepository;
import com.programming.techie.springngblog.repository.UserRepository;
import com.programming.techie.springngblog.service.AuthService;
import com.programming.techie.springngblog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;
@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private AuthService authService;
    @Autowired
    private PostRepository postRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

        @Override
    public Post createPost(PostDto postDto) {
      //  Post post = mapFromDtoToPost(postDto);
        Post post = modelMapper.map(postDto, Post.class);
            User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
            post.setUsername(loggedInUser.getUsername());
        return postRepository.save(post);
    }

    @Override
    public PostDto readSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
        return mapFromPostToDto(post);
    }

    @Override
    public Post updateSinglePost(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        return postRepository.save(post);
    }

    @Override
    public void deleteSinglePost(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
        postRepository.delete(post);
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUsername(post.getUsername());
        postDto.setCreatedOn(post.getCreatedOn());
        postDto.setUpdatedOn(post.getUpdatedOn());
        postDto.setImage(post.getImage());
        postDto.setCategorie(post.getCategorie());
        return postDto;
    }
}