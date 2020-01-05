package com.dario.project23people.controller;

import com.dario.project23people.model.Student;
import com.dario.project23people.service.StudentService;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@EnableEurekaClient
@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    @Autowired
    EntityManager entityManager;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public Iterable<Student> getAllStudentsNotPaginated(){
        return studentService.getAllStudentsNotPaginated();
    }

    @GetMapping("/byage/{age}")
    public List<Student> getAllStudentsProcedure(@PathVariable Integer age){

        return studentService.getAllStudentsProcedure(age);
    }

    @GetMapping("/byage2/{age}")
    public List<Student> getAllStudentsProcedure3(@PathVariable Integer age){

        return studentService.fetchStudentAge(age);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return "Student is valid, added: " + student.getName();
    }

    @PutMapping("/{id}")
    public String updateStudent(@Valid @PathVariable Long id, @Valid @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}
