package com.dario.project23people.repository;


import com.dario.project23people.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
