package com.ebcho.homecook.web.dto;

import com.ebcho.homecook.domain.post.Post;

public class PostSaveRequestDto {
    private Long id;
    private String title;
    private String author;
    private String content;

    public PostSaveRequestDto(String title,String author ,String content) {
        this.title = title;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
