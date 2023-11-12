package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import entity.User;
import service.impl.serviceimpl;

@Controller
public class HubController 
{
    private serviceimpl service;
    @GetMapping("users/new") //create link to this in login html
    public String registrationForm(Model model)
    { 
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/users")
    public String saveStudent(@ModelAttribute("user") User user)
    { 
       service.saveUser(user);
       return "redirect:/login";
    }
}
