package com.example.springjpaexample.dto;

import com.example.springjpaexample.entity.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {

    private int id;

    private String email;

    private Role role;
}
