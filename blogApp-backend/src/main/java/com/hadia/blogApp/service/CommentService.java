package com.hadia.blogApp.service;

import com.hadia.blogApp.model.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Long postId, Comment comment);
    Comment getCommentById(Long id);
    List<Comment> getCommentsByPostId(Long postId);
    void deleteComment(Long id);
}