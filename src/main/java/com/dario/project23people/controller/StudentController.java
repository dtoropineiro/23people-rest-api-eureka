package com.dario.project23people.controller;

import com.dario.project23people.model.Student;
import com.dario.project23people.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<Student> getAllStudentsNotPaginated(){
        return studentService.getAllStudentsNotPaginated();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return "Student is valid, added: " + student.getName();
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}
