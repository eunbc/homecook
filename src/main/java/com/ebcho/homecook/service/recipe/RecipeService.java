package com.ebcho.homecook.service.recipe;

import com.ebcho.homecook.domain.recipe.RecipeRepository;
import com.ebcho.homecook.web.dto.PostListResponseDto;
import com.ebcho.homecook.web.dto.RecipeListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    public List<RecipeListResponseDto> findAllDesc() {
        return recipeRepository.findAllDesc().stream()
                .map(RecipeListResponseDto::new)
                .collect(Collectors.toList());
    }
}
