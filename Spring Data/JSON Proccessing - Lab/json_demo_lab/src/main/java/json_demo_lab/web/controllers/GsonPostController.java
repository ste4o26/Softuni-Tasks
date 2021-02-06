package json_demo_lab.web.controllers;

import com.google.gson.Gson;
import json_demo_lab.domain.dtos.PostCreateDto;
import json_demo_lab.domain.dtos.PostViewDto;
import json_demo_lab.domain.entities.Post;
import json_demo_lab.services.interfaces.PostService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/gson/posts")
@Slf4j
public class GsonPostController {
    private final PostService postService;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public GsonPostController(PostService postService, Gson gson, ModelMapper modelMapper) {
        this.postService = postService;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String getPosts() {
        List<PostViewDto> posts = this.postService.getAllPosts();
        return this.gson.toJson(posts);
    }

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody String body) {
        PostCreateDto parsed = this.gson.fromJson(body, PostCreateDto.class);
        parsed.setCreationDate(LocalDate.parse("2020-11-14"));

        PostCreateDto postCreateDto = this.postService.addPost(parsed);

        Post post = this.modelMapper.map(postCreateDto, Post.class);

        PostViewDto postViewDto = this.modelMapper.map(post, PostViewDto.class);

        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .pathSegment("{id}")
                .buildAndExpand(postViewDto.getId().toString())
                .toUri())
                .body(this.gson.toJson(postViewDto));
    }
}
