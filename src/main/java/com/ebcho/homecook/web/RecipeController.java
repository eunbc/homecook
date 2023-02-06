package com.ebcho.homecook.web;

import com.ebcho.homecook.service.recipe.RecipeService;
import com.ebcho.homecook.web.dto.PostListResponseDto;
import com.ebcho.homecook.web.dto.RecipeListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/list")
    public List<RecipeListResponseDto> findAllDesc() {
        return recipeService.findAllDesc();
    }

}
