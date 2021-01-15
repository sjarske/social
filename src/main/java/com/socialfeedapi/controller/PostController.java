package com.socialfeedapi.controller;

import com.socialfeedapi.entity.Post;
import com.socialfeedapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping("/postsByUsername/{username}")
    public List<Post> findAllPostsByUsername(@PathVariable String username){
        return service.getPostsByUsername(username);
    }

    @GetMapping("/postsById/{id}")
    public Post findPostById(@PathVariable int id){
        return service.getPostById(id);
    }
}
