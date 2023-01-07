package com.ebcho.homecook.service.post;

import com.ebcho.homecook.domain.post.Post;
import com.ebcho.homecook.domain.post.PostRepository;
import com.ebcho.homecook.web.dto.PostListResponseDto;
import com.ebcho.homecook.web.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public List<PostListResponseDto> findAllDesc() {
        return postRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    public PostResponseDto findById(Long id) {
        Post entity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("This post does not exist. id : "+id));
        return new PostResponseDto(entity);
    }
}
