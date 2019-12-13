package com.dario.project23people.service;

import com.dario.project23people.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getAllCoursesNotPaginated();
    List<Course> getAllCourses(Pageable paging);
    String addCourse(Course course);
    Course getCourseById(Long id);
    String deleteCourse(Long id);
    String updateCourse(Long id, Course course);
}
