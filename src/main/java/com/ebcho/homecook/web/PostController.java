package com.ebcho.homecook.web;

import com.ebcho.homecook.service.post.PostService;
import com.ebcho.homecook.web.dto.PostListResponseDto;
import com.ebcho.homecook.web.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/post/list")
    public List<PostListResponseDto> findAllDesc() {
        return postService.findAllDesc();
    }

    @GetMapping("/post/{id}")
    public PostResponseDto findById(@PathVariable Long id) { return postService.findById(id);}

}
