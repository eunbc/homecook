package com.ebcho.homecook;

import com.ebcho.homecook.domain.recipe.Recipe;
import com.ebcho.homecook.web.dto.RecipeResponseDto;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class JacksonTest {
    @Test
    void givenDtoWithGetters_whenSerializingWithDefault_thenNoException() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RecipeResponseDto dto = new RecipeResponseDto(Recipe.builder().title("title").content("test123").build());
        String dtoAsString = objectMapper.writeValueAsString(dto);
        assertThat(dtoAsString, containsString("title"));
        assertThat(dtoAsString, containsString("content"));
        System.out.println("result : " + dtoAsString);
    }

    @Test
    void givenDtoWithOnlyPrivateFields_whenSerializingWithAnyVisibility_thenNoException() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        RecipeResponseDto dto = new RecipeResponseDto(Recipe.builder().title("title").content("test123").build());
        String dtoAsString = objectMapper.writeValueAsString(dto);
        assertThat(dtoAsString, containsString("title"));
        assertThat(dtoAsString, containsString("content"));
        System.out.println("result : " + dtoAsString);
    }



}
