package com.codingshuttle.anuj.production_ready_features.production_ready_features.servcies;

import com.codingshuttle.anuj.production_ready_features.production_ready_features.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPost();

    PostDTO createPost (PostDTO inputPost);

    PostDTO getPostById(Long postId);
}
