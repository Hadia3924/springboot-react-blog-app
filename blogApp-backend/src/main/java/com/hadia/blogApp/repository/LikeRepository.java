package com.hadia.blogApp.repository;

import com.hadia.blogApp.model.Like;
import com.hadia.blogApp.model.Post;
import com.hadia.blogApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository <Like, Long> {
    Optional<Like> findByPostAndUser(Post post, User user);
    int countByPost(Post post);
    boolean existsByPostAndUser(Post post, User user);
}
