package com.attendance.attendancehub.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class HomeController {

     //display homepage
    @GetMapping("/")
    public String viewHomePage(Model model) {

        return "index";
    }

  
}


   

   
    

