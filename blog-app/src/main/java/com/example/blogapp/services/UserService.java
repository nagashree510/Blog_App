package com.example.blogapp.services;

import com.example.blogapp.entities.User;
import com.example.blogapp.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.*;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();

    void deleteUserById(Integer userId);
    //User createUser(User user);

}
