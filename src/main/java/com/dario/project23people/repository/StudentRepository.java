package com.dario.project23people.repository;

import com.dario.project23people.model.Student;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {

    @Procedure(name =  "studentsByAge")
    List<Student> fetchStudentsAge(@Param("s_age") Integer age);
}
