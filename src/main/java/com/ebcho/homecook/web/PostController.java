package com.ebcho.homecook.web;

import com.ebcho.homecook.service.post.PostService;
import com.ebcho.homecook.web.dto.PostListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
