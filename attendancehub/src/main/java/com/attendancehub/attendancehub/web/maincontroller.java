package com.attendancehub.attendancehub.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class maincontroller 
{
    @GetMapping("/loginPage")
    public String login()
    { 
        return "loginPage";
    }

    @GetMapping("/")
    public String home()
    { 
        return "userpage";
    }
}
