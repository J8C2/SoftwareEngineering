package com.attendance.attendancehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.attendance.attendancehub.model.Student;
import com.attendance.attendancehub.repository.StudentRepository;

public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
       
        return studentRepository.findAll();
    }
    
}
