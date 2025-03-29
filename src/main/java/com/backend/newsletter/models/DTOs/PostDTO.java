package com.backend.newsletter.models.DTOs;

import java.time.OffsetDateTime;

public record PostDTO(
        String title,
        String content,
        OffsetDateTime created_at,
        String author,
        String description,
        String url,
        String imageUrl
){
}
