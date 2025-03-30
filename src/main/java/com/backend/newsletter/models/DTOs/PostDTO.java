package com.backend.newsletter.models.DTOs;

import java.time.OffsetDateTime;
import java.util.UUID;

public record PostDTO(
        UUID id,
        String title,
        String content,
        OffsetDateTime created_at,
        String author,
        String description,
        String url,
        String imageUrl,
        boolean sent
){
    public boolean sent(boolean sent){
        return sent = this.sent;
    }
}
