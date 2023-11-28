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
public class StudentController {

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

    @GetMapping("/adminPage")
    public String viewAdminConsole(Model model) {

        return "adminConsole";
    }

    @GetMapping("/userPage")
    public String viewUserConsole(Model model) {

        return "userConsole";
    }

/* 
    @PostMapping("/markStudentAttendance")
    public String markAttendance(
            @RequestParam("eventId") long eventId,
            @ModelAttribute("enteredCode") String enteredCode,
            Model model
    ) {
        try {
            // Validate attendance code and mark attendance
            if (eventService.isValidAttendanceCode(eventId, enteredCode)) {
                // Assuming you have a logged-in student, you can get the student from the session
                // For demonstration purposes, let's assume the student is identified by a studentId
                long studentId = 1; // Replace with the actual student ID

                // Mark attendance for the student
                eventService.markStudentAttendance(eventId, studentId);

                model.addAttribute("isAttendanceCorrect", true);
            } else {
                model.addAttribute("isAttendanceCorrect", false);
            }

            // Fetch the updated list of events and add it to the model
            model.addAttribute("listEvents", eventService.getAllEvents());
        } catch (Exception e) {
            // Handle exceptions as needed
            e.printStackTrace(); // For demonstration purposes, print the stack trace
        }

        // Return the name of the HTML template to display
        return "your-events-template"; // Replace with the actual template name
    }
    */

}
