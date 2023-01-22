package com.ebcho.homecook.web;

import com.ebcho.homecook.service.post.PostService;
import com.ebcho.homecook.web.dto.PostListResponseDto;
import com.ebcho.homecook.web.dto.PostResponseDto;
import com.ebcho.homecook.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public List<PostListResponseDto> findAllDesc() {
        return postService.findAllDesc();
    }

    @GetMapping("/{id}")
    public PostResponseDto findById(@PathVariable Long id) { return postService.findById(id);}

    @PostMapping()
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }

}
