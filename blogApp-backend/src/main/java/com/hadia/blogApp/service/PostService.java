package com.hadia.blogApp.service;

import com.hadia.blogApp.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    Post getPostById(Long id);
    List<Post> getAllPosts();
    List<Post> getAllPosts(Integer pageNumber, Integer pageSize);
    List<Post> getPostsByUserId(Long userId);
    Post updatePost(Long id, Post post);
    void deletePost(Long id);
}