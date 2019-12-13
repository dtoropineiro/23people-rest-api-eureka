package com.dario.project23people.service;

import com.dario.project23people.model.Student;
import com.dario.project23people.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Added student with id: " + student.getId();
    }
}
