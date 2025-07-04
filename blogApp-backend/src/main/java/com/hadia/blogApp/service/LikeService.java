package com.hadia.blogApp.service;

import com.hadia.blogApp.model.Like;

public interface LikeService {
    Like addLike(Long postId, Long userId);
    void removeLike(Long postId, Long userId);
    int getLikeCountByPostId(Long postId);
    boolean isPostLikedByUser(Long postId, Long userId);
}