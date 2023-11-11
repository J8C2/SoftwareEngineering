package com.attendance.attendancehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.attendance.attendancehub.model.Student;
import com.attendance.attendancehub.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    //display the list of students
    @GetMapping("/")
    public String viewHomePage(Model model) {

        model.addAttribute("listStudents", studentService.getAllStudents());
        return "index";
    }

    //Enables Controller to handle student form request
    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {

        //create model attribute to bind form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_Student";
    }

    //crating a controller to handle save student request
    @PostMapping("/saveStudent")
    public String SaveStudent(@ModelAttribute("student") Student student) {

        //Save Student to database
        studentService.saveStudent(student);
        return "redirect:/"; // redirect to homepage

    }

}
