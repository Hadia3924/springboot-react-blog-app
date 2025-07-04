package com.hadia.blogApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 1000)
    private String content;

    private LocalDateTime timestamp;

    public Comment() {
    }

    public Comment(Long id, Post post, User user, String content, LocalDateTime timestamp) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.content = content;
        this.timestamp = timestamp;
    }
}
