package com.socialfeedapi.controller;

import com.socialfeedapi.entity.User;
import com.socialfeedapi.repository.UserRepository;
import com.socialfeedapi.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    public void getUsersTest() {
        when(repository.findAll()).thenReturn(Stream
                .of(new User(1, "bob", "sue", "bobsue", "test123"), new User(2, "jack", "gregor", "jacky", "test123")).collect(Collectors.toList()));
        assertEquals(2, service.getUsers().size());
    }

    @Test
    public void getUserByIdTest(){
        int id = 1;
        when(repository.findById(id)).thenReturn(java.util.Optional.of(new User(1, "bob", "sue", "bobsue", "test123")));
        assertEquals(1,service.getUserById(id).getId());
    }

    @Test
    public void getUserByUsernameTest(){
        String username = "bobsue";
        when(repository.findByUsername(username)).thenReturn((new User(1, "bob", "sue", "bobsue", "test123")));
        assertEquals(username,service.getUserByUsername(username).getUsername());
    }

    @Test
    public void saveUserTest(){
        User user = new User(123, "jack", "jackson", "jackjson", "test123");
        when(repository.save(user)).thenReturn(user);
        assertEquals(user, service.saveUser(user));
    }

    @Test
    public void deleteUserTest(){
        User user = new User(123, "jack", "jackson", "jackjson", "test123");
        service.deleteUser(123);
        verify(repository,times(1)).deleteById(123);
    }
}