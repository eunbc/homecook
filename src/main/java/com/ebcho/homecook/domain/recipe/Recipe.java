package com.ebcho.homecook.domain.recipe;

import com.ebcho.homecook.web.dto.RecipeSaveRequestDto;
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
    //todo : 대표 사진


}
