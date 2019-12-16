package com.dario.project23people.service;

import com.dario.project23people.exception.EntityNotFoundException;
import com.dario.project23people.model.Course;
import com.dario.project23people.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {


    private CourseRepository courseRepository;

    public CourseServiceImpl(){
    }

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCoursesNotPaginated() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getAllCourses(Pageable paging) {
        Page<Course> pagedResult = courseRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Course>();
        }
    }

    @Override
    public String addCourse(Course course) {
        courseRepository.save(course);
        return "Added course with id: " + course.getId();
    }

    @Override
    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course not found"));
    }

    @Override
    public String deleteCourse(Long id) throws EntityNotFoundException {
        if (!courseRepository.findById(id).isPresent()){
            throw new EntityNotFoundException("Course not found");
        }
        courseRepository.deleteById(id);
        return "deleted course with id: " + id;
    }

    @Override
    public String updateCourse(Long id, Course course) throws EntityNotFoundException {
        if (!courseRepository.findById(id).isPresent()){
            throw new EntityNotFoundException("Course not found");
        }
        course.setId(id);
        courseRepository.save(course);
        return "updated course with id: " + id;
    }

}
