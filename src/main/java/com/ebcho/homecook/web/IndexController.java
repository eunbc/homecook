package com.ebcho.homecook.web;

import com.ebcho.homecook.web.dto.RecipeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final RecipeController recipeController;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("recipes",recipeController.findAllDesc());
        return "index";
    }

    @GetMapping("/recipe/save")
    public String recipeSave() {
        return "recipe-save";
    }

    @GetMapping("/recipe/update/{id}")
    public String recipeSave(@PathVariable Long id, Model model) {
        RecipeResponseDto dto = recipeController.findById(id);
        model.addAttribute("recipe", dto);
        return "recipe-update";
    }
}
