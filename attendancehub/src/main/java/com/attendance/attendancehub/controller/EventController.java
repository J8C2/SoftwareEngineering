package com.attendance.attendancehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.attendance.attendancehub.model.Event;
import com.attendance.attendancehub.service.EventService;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;
    
     //display homepage
     @GetMapping("/")
     public String viewHomePage(Model model) {
 
         return "index";
     }

    //Enables Controller to handle event form request
    @GetMapping("/showNewEventForm")
    public String showNewEventForm(Model model) {

        //create model attribute to bind form data
        Event event = new Event();
        model.addAttribute("event", event);
        return "new_event";
    }

    @GetMapping("/showAllEvents")
    public String showAllEvents(Model model) {

        
        model.addAttribute("listEvents", eventService.getAllEvents());
        return "allEvents";
    }

    
    @GetMapping("/showAllEvents2")
    public String showAllEvents2(Model model) {

        
        model.addAttribute("listEvents", eventService.getAllEvents());
        return "allEvents2";
    }


    //crating a controller to handle save event request
    @PostMapping("/saveEvent")
    public String SaveEvent(@ModelAttribute("event") Event event) {

        //Save event to database
        eventService.saveEvent(event);
        return "redirect:/showAllEvents"; // redirect to event page

    }

    @GetMapping("/showFormForUpdate2/{id}")
    public String showFormForUpdate2(@PathVariable ( value = "id") long id, Model model) {

        //get event from the service
        Event event = eventService.getEventById(id);

        //set event as a model attribute to pr-populate the form
        model.addAttribute("event", event);

        return "update_event";
    }


    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable (value = "id") long id ){

        //call delete event method
        this.eventService.deleteEventById(id);
    
        return "redirect:/showAllEvents";
    }

}
