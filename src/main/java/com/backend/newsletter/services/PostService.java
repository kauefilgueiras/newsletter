package com.backend.newsletter.services;
import com.backend.newsletter.models.DTOs.PostDTO;
import com.backend.newsletter.models.Post;
import com.backend.newsletter.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post create(PostDTO postDTO){
        if (postDTO.title() == null || postDTO.content() == null ){
            throw new IllegalArgumentException("Dados invalidos ou incompletos");
        }
        if (postDTO.created_at() != null && postDTO.created_at().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("data e hora maior que a data atual");
        }

        Post post = new Post();
        post.setTitle(postDTO.title());
        post.setContent(postDTO.content());
        post.setCreated_at(OffsetDateTime.now());
        return postRepository.save(post);
    }

    public List<Post> getMany(){
        return postRepository.findAll();
    }

    public Optional<Post> findById(UUID id){
        return postRepository.findById(id);
    }

    public void delete(UUID id){
        postRepository.deleteById(id);
    }
}
