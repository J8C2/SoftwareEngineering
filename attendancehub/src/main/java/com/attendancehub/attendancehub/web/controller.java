package com.attendancehub.attendancehub.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attendancehub.attendancehub.RegistrationDto;
import com.attendancehub.attendancehub.service.service;

@Controller
@RequestMapping("/registration")
public class controller 
{
    
    private service userService;

    public controller(service userService) 
    {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public RegistrationDto registrationDto()
    { 
        return new RegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm()
    { 
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") RegistrationDto registrationDto)
    {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
