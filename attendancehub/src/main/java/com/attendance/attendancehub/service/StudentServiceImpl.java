package com.attendance.attendancehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.attendancehub.model.Student;
import com.attendance.attendancehub.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
       
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
       
       this.studentRepository.save(student);
    }
    
}
