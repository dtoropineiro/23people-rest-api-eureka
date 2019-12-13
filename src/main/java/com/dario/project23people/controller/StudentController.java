package com.dario.project23people.controller;

import com.dario.project23people.model.Course;
import com.dario.project23people.model.Student;
import com.dario.project23people.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return "Student is valid, added: " + student.getName();
    }


}
