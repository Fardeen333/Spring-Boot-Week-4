package com.codingshuttle.anuj.production_ready_features.production_ready_features.controllers;

import com.codingshuttle.anuj.production_ready_features.production_ready_features.dto.PostDTO;
import com.codingshuttle.anuj.production_ready_features.production_ready_features.servcies.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.getAllPost();
    }

    @GetMapping(path = "/{postId}")
    public PostDTO getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO postDTO){
        return postService.createPost(postDTO);

    }
}
