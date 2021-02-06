package json_demo_lab.services.interfaces;

import json_demo_lab.domain.dtos.PostCreateDto;
import json_demo_lab.domain.dtos.PostDeleteDto;
import json_demo_lab.domain.dtos.PostUpdateDto;
import json_demo_lab.domain.dtos.PostViewDto;
import json_demo_lab.domain.entities.Post;

import java.util.List;

public interface PostService {
    List<PostViewDto> getAllPosts();

    PostViewDto getPostById(Long id);

    PostCreateDto addPost(PostCreateDto post);

    PostUpdateDto updatePost(PostUpdateDto postUpdateDto);

    PostDeleteDto deletePost(Long id);

    Long getAllPostsCount();
}
