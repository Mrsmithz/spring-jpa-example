package com.example.springjpaexample.service.implement;

import com.example.springjpaexample.dto.CourseDto;
import com.example.springjpaexample.dto.UserDto;
import com.example.springjpaexample.entity.Course;
import com.example.springjpaexample.entity.User;
import com.example.springjpaexample.repository.CourseRepository;
import com.example.springjpaexample.repository.UserRepository;
import com.example.springjpaexample.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final UserRepository userRepository;

    @Override
    public Course createCourse(Integer userId, Course course) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        course.setOwner(user);

        return courseRepository.save(course);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(course -> CourseDto.builder()
                        .id(course.getId())
                        .title(course.getTitle())
                        .owner(UserDto.builder()
                                .id(course.getOwner().getId())
                                .email(course.getOwner().getEmail())
                                .role(course.getOwner().getRole())
                                .build())
                        .userList(course.getUserList()
                                .stream()
                                .map(user -> UserDto.builder()
                                        .id(user.getId())
                                        .email(user.getEmail())
                                        .role(user.getRole())
                                        .build())
                                .toList())
                        .build()
                )
                .toList();
    }

    @Override
    public CourseDto join(Integer userId, Integer courseId) {
        Course existCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
        User userJoin = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        existCourse.getUserList().add(userJoin);

        Course course = courseRepository.save(existCourse);

        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .owner(UserDto.builder()
                        .id(course.getOwner().getId())
                        .email(course.getOwner().getEmail())
                        .role(course.getOwner().getRole())
                        .build())
                .userList(course.getUserList()
                        .stream()
                        .map(user -> UserDto.builder()
                                .id(user.getId())
                                .email(user.getEmail())
                                .role(user.getRole())
                                .build())
                        .toList())
                .build();
    }
}
