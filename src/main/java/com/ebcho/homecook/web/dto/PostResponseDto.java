package com.ebcho.homecook.web.dto;

import com.ebcho.homecook.domain.post.Post;

public class PostResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private Long cookTime;

    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.cookTime = entity.getCookTime();
    }
}
