package com.socialfeedapi.service;

import com.socialfeedapi.entity.Post;
import com.socialfeedapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> getPostsByUsername(String username) {
        return repository.findAllPostsByUsernameAuthor(username);
    }

    public Post getPostById(int id) {
        return  repository.findById(id).orElse(null);
    }
}
