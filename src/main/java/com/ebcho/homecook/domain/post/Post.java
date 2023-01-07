package com.ebcho.homecook.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long cookTime;
    private String author;
    private String content;

    @Builder
    public Post(String title, String content, Long cookTime) {
        this.title = title;
        this.content = content;
        this.cookTime = cookTime;
    }

}
