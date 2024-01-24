package com.example.blogapp.repositories;

import com.example.blogapp.entities.User;
import com.example.blogapp.payloads.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
