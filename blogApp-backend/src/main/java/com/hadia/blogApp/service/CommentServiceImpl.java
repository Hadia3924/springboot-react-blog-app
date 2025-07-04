package com.hadia.blogApp.service;

import com.hadia.blogApp.model.Comment;
import com.hadia.blogApp.model.Post;
import com.hadia.blogApp.repository.CommentRepository;
import com.hadia.blogApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Comment addComment(Long postId, Comment comment){
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Long id){
        return commentRepository.findById(id).orElseThrow(()-> new RuntimeException("Comment not found"));
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId){
        return commentRepository.findByPostId(postId);
    }

    @Override
    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
}
