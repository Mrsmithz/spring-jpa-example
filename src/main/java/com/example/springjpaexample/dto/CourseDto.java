package com.example.springjpaexample.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CourseDto {

    private int id;

    private String title;

    private UserDto owner;

    private List<UserDto> userList;
}
