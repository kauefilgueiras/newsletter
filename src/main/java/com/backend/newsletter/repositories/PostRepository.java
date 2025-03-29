package com.backend.newsletter.repositories;

import com.backend.newsletter.models.DTOs.PostDTO;
import com.backend.newsletter.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

}
