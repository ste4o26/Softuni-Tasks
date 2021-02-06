package json_demo_lab.services;

import json_demo_lab.domain.dtos.PostCreateDto;
import json_demo_lab.domain.dtos.PostDeleteDto;
import json_demo_lab.domain.dtos.PostUpdateDto;
import json_demo_lab.domain.dtos.PostViewDto;
import json_demo_lab.domain.entities.Post;
import json_demo_lab.exceptions.NonExistingEntityException;
import json_demo_lab.repositories.PostRepository;
import json_demo_lab.services.interfaces.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostViewDto> getAllPosts() {
        return this.postRepository
                .findAll()
                .stream()
                .map(post -> this.modelMapper.map(post, PostViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostViewDto getPostById(Long id) {
        Post post = this.postRepository
                .findById(id)
                .orElseThrow(() -> new NonExistingEntityException(String.format("No post with ID %d was found!", id)));

        return this.modelMapper
                .map(post, PostViewDto.class);
    }

    @Override
    public PostCreateDto addPost(PostCreateDto postCreateDto) {
        Post post = this.modelMapper.map(postCreateDto, Post.class);

        Post createdPost = this.postRepository.saveAndFlush(post);

        return this.modelMapper
                .map(createdPost, PostCreateDto.class);
    }

    @Override
    public PostUpdateDto updatePost(PostUpdateDto postUpdateDto) {
        this.getPostById(postUpdateDto.getId());

        Post post = this.modelMapper.map(postUpdateDto, Post.class);

        Post updatedPost = this.postRepository.saveAndFlush(post);

        return this.modelMapper.map(updatedPost, PostUpdateDto.class);
    }

    @Override
    public PostDeleteDto deletePost(Long id) {
        Post post = this.modelMapper.map(this.getPostById(id), Post.class);

        this.postRepository.deleteById(id);

        return this.modelMapper.map(post, PostDeleteDto.class);
    }

    @Override
    public Long getAllPostsCount() {
        return this.postRepository.count();
    }
}
