package com.ebcho.homecook.domain.post;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After
    void cleanup () {
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "test title";
        String content = "test content";

        postRepository.save(Post.builder()
                .title(title)
                .content(content)
                .cookTime(100L)
                .build());

        //when
        List<Post> postsList = postRepository.findAll();

        //then
        Post posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
    }


}