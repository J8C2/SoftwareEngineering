package com.attendance.attendancehub.service;

import java.util.List;

import com.attendance.attendancehub.model.Student;

public interface StudentService {
    
    List<Student> getAllStudents();
    void saveStudent(Student student);
    Student getStudentById(long id);
}
