package com.ebcho.homecook.web.dto;

import com.ebcho.homecook.domain.post.Post;

public class PostListResponseDto {
    private Long id;
    private String title;

    public PostListResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
    }
}
