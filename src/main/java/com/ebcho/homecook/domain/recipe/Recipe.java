package com.ebcho.homecook.domain.recipe;

import com.ebcho.homecook.web.dto.RecipeSaveRequestDto;
import com.ebcho.homecook.web.dto.RecipeUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Long portion; //몇인분
    private Long cookingTime; //소요시간
    private String ingredients; //재료
    private String content;
    private Long hits; //조회수
    private Boolean isDeleted = Boolean.FALSE;
    //todo : 대표 사진
    @Builder
    public Recipe(String title, String author, Long portion, Long cookingTime, String ingredients, String content) {
        this.title = title;
        this.author = author;
        this.portion = portion;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.content = content;
    }

    public void update(RecipeUpdateRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.portion = requestDto.getPortion();
        this.cookingTime = requestDto.getCookingTime();
        this.ingredients = requestDto.getIngredients();
        this.content = requestDto.getContent();
    }

    public void delete() {
        this.isDeleted = Boolean.TRUE;
    }
}
