package com.attendance.attendancehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.attendance.attendancehub.model.Student;
import com.attendance.attendancehub.service.StudentService;

@Controller
public class  StudentController {

    @Autowired
    private StudentService studentService;
    
    //Enables Controller to handle student form request
    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {

        //create model attribute to bind form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_Student";
    }

    @GetMapping("/showAllStudents")
    public String showAllStudents(Model model) {

        //create model attribute to bind form data
        //Student student = new Student();
        //model.addAttribute("student", student);
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "allStudents";
    }


    //crating a controller to handle save student request
    @PostMapping("/saveStudent")
    public String SaveStudent(@ModelAttribute("student") Student student) {

        //Save Student to database
        studentService.saveStudent(student);
        return "redirect:/showAllStudents"; // redirect to homepage

    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        //get student from the service
        Student student = studentService.getStudentById(id);

        //set student as a model attribute to pr-populate the form
        model.addAttribute("student", student);

        return "update_student";
    }


    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable (value = "id") long id ){

        //call delete student method
        this.studentService.deleteStudentById(id);
    
        return "redirect:/showAllStudents";
    }

}
