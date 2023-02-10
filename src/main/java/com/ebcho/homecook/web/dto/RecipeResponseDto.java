package com.ebcho.homecook.web.dto;

import com.ebcho.homecook.domain.recipe.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class RecipeResponseDto {
    private Long id;
    private String title;
    private String author;
    private Long portion;
    private Long cookingTime;
    private String ingredients;
    private String content;
    private Long hits;


    public RecipeResponseDto(Recipe entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.hits = entity.getHits();
        this.portion = entity.getPortion();
        this.cookingTime = entity.getCookingTime();
        this.ingredients = entity.getIngredients();
        this.content = entity.getContent();
    }
}
