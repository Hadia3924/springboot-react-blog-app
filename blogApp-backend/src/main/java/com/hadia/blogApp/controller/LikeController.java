package com.hadia.blogApp.controller;

import com.hadia.blogApp.model.Like;
import com.hadia.blogApp.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Like> addLike(@PathVariable Long postId, @RequestParam Long userId){
        Like like = likeService.addLike(postId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(like);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long postId, @RequestParam Long userId){
        likeService.removeLike(postId, userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Integer> countLikes(@PathVariable Long postId){
        int likes = likeService.getLikeCountByPostId(postId);
        return ResponseEntity.ok(likes);
    }
}