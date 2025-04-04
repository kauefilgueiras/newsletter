package com.backend.newsletter.controllers;

import com.backend.newsletter.models.DTOs.PostDTO;
import com.backend.newsletter.models.Post;
import com.backend.newsletter.services.PostService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAll(){
        return postService.getMany();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable UUID id){
        return postService.findById(id).orElseThrow(() -> new RuntimeException("Error GET/ posts/{id}"));
    }

    @PostMapping
    public ResponseEntity <Post> createPost(@RequestBody PostDTO postDTO){
        postService.create(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePost (@PathVariable UUID id){
        postService.delete(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public Post update(@RequestBody PostDTO postDTO, @PathVariable UUID id){
        Optional<Post> optionalPost = postService.findById(id);
        if (!optionalPost.isPresent()) {
            throw new IllegalArgumentException();
        }
        Post post = optionalPost.get();
        post.setSent(postDTO.sent());
        return postService.update(post);
    }
}
