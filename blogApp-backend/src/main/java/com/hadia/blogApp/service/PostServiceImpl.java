package com.hadia.blogApp.service;

import com.hadia.blogApp.model.Post;
import com.hadia.blogApp.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post){
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Long id){
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public List<Post> getAllPosts(){
//        public List<Post> getAllPosts(Integer pageNumber, Integer pageSize){
//        Pageable pageable = PageRequest.of(pageNumber,pageSize);
//        Page<Post> postPage = this.postRepository.findAll(pageable);
//        List<Post> allPosts = postPage.getContent();
        return postRepository.findAll();
    }

    @Override
    public List<Post> getAllPosts(Integer pageNumber, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Post> postPage = this.postRepository.findAll(pageable);
        return postPage.getContent();
    }
    @Override
    public List<Post> getPostsByUserId(Long userId){
        return postRepository.findByAuthorId(userId);
    }
    @Override
    public Post updatePost(Long id, Post post){
        Post existingPost = getPostById(id);
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        return postRepository.save(existingPost);
    }

    @Override
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
