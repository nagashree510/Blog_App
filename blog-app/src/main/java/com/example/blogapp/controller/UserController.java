package com.example.blogapp.controller;

import com.example.blogapp.entities.User;
import com.example.blogapp.payloads.UserDto;
import com.example.blogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto>  createUser(@RequestBody UserDto user){
      userService.createUser(user);
      return new ResponseEntity<> (user,HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>>  createUser(){
        List<UserDto> list=userService.getAllUsers();
        return new ResponseEntity<> (list,HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto>  createUser(@PathVariable int id){
        UserDto user=userService.getUserById(id);
        return new ResponseEntity<> (user,HttpStatus.ACCEPTED);
    }


}
