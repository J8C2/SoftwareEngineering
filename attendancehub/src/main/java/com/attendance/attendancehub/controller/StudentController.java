package com.attendance.attendancehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
