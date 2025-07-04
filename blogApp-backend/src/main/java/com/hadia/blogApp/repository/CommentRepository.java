package com.hadia.blogApp.repository;

import com.hadia.blogApp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
