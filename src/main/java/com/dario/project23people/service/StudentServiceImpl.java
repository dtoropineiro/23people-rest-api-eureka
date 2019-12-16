package com.dario.project23people.service;

import com.dario.project23people.exception.EntityNotFoundException;
import com.dario.project23people.model.Student;
import com.dario.project23people.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public String updateStudent(Long id, Student student) {
        if (!studentRepository.findById(id).isPresent()){
            throw new EntityNotFoundException("Student not found");
        }
        student.setId(id);
        studentRepository.save(student);
        return "updated student with id: " + id;
    }

    @Override
    public String deleteStudent(Long id) {
        if (!studentRepository.findById(id).isPresent()){
            throw new EntityNotFoundException("Student not found");
        }
        studentRepository.deleteById(id);
        return "deleted student with id: " + id;
    }

    @Override
    public List<Student> getAllStudentsNotPaginated() {
        return studentRepository.findAll();
    }
}
