package com.ebcho.homecook.web;

import com.ebcho.homecook.service.recipe.RecipeService;
import com.ebcho.homecook.web.dto.PostListResponseDto;
import com.ebcho.homecook.web.dto.RecipeListResponseDto;
import com.ebcho.homecook.web.dto.RecipeResponseDto;
import com.ebcho.homecook.web.dto.RecipeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public RecipeResponseDto findById(@PathVariable Long id) {
        return recipeService.findById(id);
    }

    @PostMapping
    public Long save(@RequestBody RecipeSaveRequestDto requestDto) {
        return recipeService.save(requestDto);
    }

}
