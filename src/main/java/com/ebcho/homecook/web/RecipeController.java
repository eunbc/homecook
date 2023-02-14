package com.ebcho.homecook.web;

import com.ebcho.homecook.service.recipe.RecipeService;
import com.ebcho.homecook.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
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

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody RecipeUpdateRequestDto requestDto) {
        return recipeService.update(id,requestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return recipeService.delete(id);
    }

}
