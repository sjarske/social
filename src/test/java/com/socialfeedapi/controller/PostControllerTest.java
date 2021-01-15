package com.socialfeedapi.controller;

import com.socialfeedapi.entity.Post;
import com.socialfeedapi.repository.PostRepository;
import com.socialfeedapi.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostControllerTest {

    @Autowired
    private PostService service;

    @MockBean
    private PostRepository repository;

    @Test
    void findAllPostsByUsernameTest() {
        String username = "jacky";
        Date today = Calendar.getInstance().getTime();
        when(repository.findAllPostsByUsernameAuthor(username)).thenReturn(Stream
            .of(new Post(1,"this post", today,username),new Post(2,"this another post", today,username)).collect(Collectors.toList()));
        assertEquals(2,service.getPostsByUsername(username).size());
    }
}