package com.example.blogapp.payloads;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserDto {

    private int id;
    private  String name;
    private String email;
    private String password;
    private String  about;
}
