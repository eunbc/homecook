package com.ebcho.homecook.web.dto;

import com.ebcho.homecook.domain.post.Post;
import com.ebcho.homecook.domain.recipe.Recipe;

public class RecipeListResponseDto {
    private Long id;
    private String title;
    private String author;
    private Long hits;

    public RecipeListResponseDto(Recipe entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.hits = entity.getHits();
    }
}
