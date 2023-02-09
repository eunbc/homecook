package com.ebcho.homecook.web.dto;

import com.ebcho.homecook.domain.post.Post;
import com.ebcho.homecook.domain.recipe.Recipe;
import lombok.Getter;


//@Getter
public class RecipeSaveRequestDto {
    private Long id;
    private String title;
    private String author;
    private Long portion;
    private Long cookingTime;
    private String ingredients;
    private String content;
    private Long hits;

}
