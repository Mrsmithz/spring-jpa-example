package com.example.springjpaexample.controller;

import com.example.springjpaexample.dto.CourseDto;
import com.example.springjpaexample.entity.Course;
import com.example.springjpaexample.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
public interface ApplicationController {

    @PostMapping("/user/create")
    ResponseEntity<User> createUser(@RequestBody User user);

    @GetMapping("/users")
    ResponseEntity<List<User>> getUsers();

    @PostMapping("/course/create/{userId}")
    ResponseEntity<Course> createCourse(@PathVariable String userId, @RequestBody Course course);

    @GetMapping("/courses")
    ResponseEntity<List<CourseDto>> getCourses();

    @PostMapping("/course/join/{courseId}/{userId}")
    ResponseEntity<CourseDto> joinCourse(@PathVariable String userId, @PathVariable String courseId);
}
