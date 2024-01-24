package com.example.blogapp.serviceImpl;

import com.example.blogapp.entities.User;
import com.example.blogapp.exceptions.ResourceNotFoundException;
import com.example.blogapp.payloads.UserDto;
import com.example.blogapp.repositories.UserRepo;
import com.example.blogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
//    @Override
//    public User createUser(User user) {
//        userRepo.save(user);
//        return user;
//    }


    public UserDto createUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
        userRepo.save(user);
        return this.userToUserDto(user);
    }


    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
         User user=this.userRepo.findById(userId)
                 .orElseThrow(()->new ResourceNotFoundException("user","ID",userId));
         user.setName(userDto.getName());
         user.setEmail(userDto.getEmail());
         user.setPassword(user.getPassword());
         user.setAbout(user.getAbout());
        return this.userToUserDto(user);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user=this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user","ID",userId));

        return this.userToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User>users= this.userRepo.findAll();
       List<UserDto> list=users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
        return list;
    }

    @Override
    public void deleteUserById(Integer userId) {
        User user=this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user","ID",userId));
          this.userRepo.delete(user);
    }
//model mapper library
    public User dtoToUser(UserDto userDto){
        User user=new User(userDto.getId(),userDto.getName(),
                userDto.getEmail(),userDto.getPassword(),userDto.getAbout());
        return user;
    }
    public UserDto userToUserDto(User user){
        UserDto userDto=new UserDto(user.getId(),user.getName(),
                user.getEmail(),user.getPassword(),user.getAbout());
        return userDto;
    }


}
