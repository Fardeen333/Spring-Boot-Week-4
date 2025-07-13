package com.codingshuttle.anuj.production_ready_features.production_ready_features.servcies;

import com.codingshuttle.anuj.production_ready_features.production_ready_features.dto.PostDTO;
import com.codingshuttle.anuj.production_ready_features.production_ready_features.entities.PostEntity;
import com.codingshuttle.anuj.production_ready_features.production_ready_features.exception.ResourceNotFoundException;
import com.codingshuttle.anuj.production_ready_features.production_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPost() {
//        return postRepository.findAll().stream().map(postEntity -> modelMapper.map(postEntity, PostDTO.class)).collect(Collectors.toList());

        return postRepository.findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .toList();
    }

    @Override
    public PostDTO createPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        PostEntity createdPost = postRepository.save(postEntity);
        return modelMapper.map(createdPost, PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }
}
