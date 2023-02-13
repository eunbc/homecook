package com.ebcho.homecook.web.dto;

import com.ebcho.homecook.domain.recipe.Recipe;
import lombok.Getter;


@Getter
public class RecipeUpdateRequestDto {
    private String title;
    private Long portion;
    private Long cookingTime;
    private String ingredients;
    private String content;

}
