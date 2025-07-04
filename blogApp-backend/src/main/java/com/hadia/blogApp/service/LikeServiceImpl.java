package com.hadia.blogApp.service;

import com.hadia.blogApp.model.Like;
import com.hadia.blogApp.model.Post;
import com.hadia.blogApp.model.User;
import com.hadia.blogApp.repository.LikeRepository;
import com.hadia.blogApp.repository.PostRepository;
import com.hadia.blogApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService{
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository, PostRepository postRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Like addLike(Long postId, Long userId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if(likeRepository.existsByPostAndUser(post, user))
            throw new RuntimeException("User has already liked this post");
        Like like = new Like(post, user);
        return likeRepository.save(like);

    }
    @Override
    public void removeLike(Long postId, Long userId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Like like = likeRepository.findByPostAndUser(post, user).orElseThrow(() -> new RuntimeException("Like not found"));
        likeRepository.delete(like);
    }
    @Override
    public int getLikeCountByPostId(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        return likeRepository.countByPost(post);
    }
    @Override
    public boolean isPostLikedByUser(Long postId, Long userId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return likeRepository.existsByPostAndUser(post, user);
    }
}
