package com.example.springjpaexample.service;

import com.example.springjpaexample.dto.CourseDto;
import com.example.springjpaexample.entity.Course;

import java.util.List;

public interface CourseService {

    Course createCourse(Integer userId, Course course);

    List<CourseDto> getAllCourses();

    CourseDto join(Integer userId, Integer courseId);
}
