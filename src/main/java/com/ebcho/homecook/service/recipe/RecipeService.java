package com.ebcho.homecook.service.recipe;

import com.ebcho.homecook.domain.recipe.Recipe;
import com.ebcho.homecook.domain.recipe.RecipeRepository;
import com.ebcho.homecook.web.dto.RecipeListResponseDto;
import com.ebcho.homecook.web.dto.RecipeResponseDto;
import com.ebcho.homecook.web.dto.RecipeSaveRequestDto;
import com.ebcho.homecook.web.dto.RecipeUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    public List<RecipeListResponseDto> findAllDesc() {
        return recipeRepository.findByIsDeletedFalseOrderByIdDesc()
                .stream()
                .map(RecipeListResponseDto::new)
                .collect(Collectors.toList());
    }

    public RecipeResponseDto findById(Long id) {
        Recipe entity = recipeRepository.findById(id).orElseThrow();
        return new RecipeResponseDto(entity);
    }

    public Long save(RecipeSaveRequestDto requestDto) {
        return recipeRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id,RecipeUpdateRequestDto requestDto) {
        Recipe entity = recipeRepository.findById(id).orElseThrow();
        entity.update(requestDto);
        return entity.getId();
    }


    @Transactional
    public Long delete(Long id) {
        Recipe entity = recipeRepository.findById(id).orElseThrow();
        entity.delete();
        return entity.getId();
    }
}
