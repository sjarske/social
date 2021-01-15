package com.socialfeedapi.repository;


import com.socialfeedapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllPostsByUsernameAuthor(String username);
}
