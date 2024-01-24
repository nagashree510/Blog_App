package com.example.blogapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

    String resurceName;
    String fielsName;
    long fieldValue;


}
