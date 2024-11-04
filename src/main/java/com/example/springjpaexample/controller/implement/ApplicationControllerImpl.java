package com.example.springjpaexample.controller.implement;

import com.example.springjpaexample.controller.ApplicationController;
import com.example.springjpaexample.dto.CourseDto;
import com.example.springjpaexample.entity.Course;
import com.example.springjpaexample.entity.User;
import com.example.springjpaexample.service.CourseService;
import com.example.springjpaexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApplicationControllerImpl implements ApplicationController {

    private final CourseService courseService;

    private final UserService userService;

    @Override
    public ResponseEntity<User> createUser(User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity
                .ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<Course> createCourse(String userId, Course course) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(courseService.createCourse(Integer.valueOf(userId), course));
    }

    @Override
    public ResponseEntity<List<CourseDto>> getCourses() {
        return ResponseEntity
                .ok(courseService.getAllCourses());
    }

    @Override
    public ResponseEntity<CourseDto> joinCourse(String userId, String courseId) {
        return ResponseEntity
                .ok(courseService.join(Integer.valueOf(userId), Integer.valueOf(courseId)));
    }
}
