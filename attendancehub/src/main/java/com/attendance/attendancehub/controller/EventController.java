package com.attendance.attendancehub.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    
   // In your controller method
  // In your controller method
  @GetMapping("/showAllEvents2")
  public String showAllEvents2(@RequestParam(name = "enteredCode", required = false) String enteredCode, Model model) {
      List<Event> events = eventService.getAllEvents();
      model.addAttribute("listEvents", events);
  
  
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


    
    @GetMapping("/takeAttendance1/{id}")
    public String takeAttendance1(@PathVariable ("id") long id, Model model) {

        //get event from the service
        Event event = eventService.getEventById(id);

        //set event as a model attribute to pr-populate the form
        model.addAttribute("event", event);

        System.out.println("hello /n hello /n hello /n /helllllloo");
                                System.out.println("hello /n hello /n hello /n /helllllloo");
                                System.out.println("hello /n hello /n hello /n /helllllloo");
                                System.out.println("hello /n hello /n hello /n /helllllloo");

        return "takeAttendance";
    }

    @PostMapping("/takeAttendance1/{id}")
    public String takeAttendance2(@RequestParam("enteredCode") String enteredCode,
                              @ModelAttribute("event") Event event,
                              Model model) {
                                System.out.println("hello /n hello /n hello /n /######");
                                System.out.println("hello /n hello /n hello /n /########");
                                System.out.println("hello /n hello /n hello /n /######");
                                System.out.println("hello /n hello /n hello /n /########");
                                System.out.println("hello /n hello /n hello /n /#############");
                                System.out.println("hello /n hello /n hello /n /###########");
    boolean isAttendanceCorrect = eventService.isValidAttendanceCode(event.getId(), enteredCode);
    model.addAttribute("isAttendanceCorrect", isAttendanceCorrect);

    // Retrieve the event
    Event retrievedEvent = eventService.getEventById(event.getId());

    if (isAttendanceCorrect) {
        // Update the attendance status for the event
        retrievedEvent.setAttendanceStatus("Attended");

        // Save the updated event with the new attendance status
        eventService.saveEvent(retrievedEvent);

        model.addAttribute("message", "Attendance marked successfully");
    } else {
        model.addAttribute("error", "Wrong code. Please try again.");
    }

    model.addAttribute("listEvents", eventService.getAllEvents());
    return "attendanceResult";  // Return the new HTML file
}

    
    


    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable (value = "id") long id ){

        //call delete event method
        this.eventService.deleteEventById(id);
    
        return "redirect:/showAllEvents";
    }

/* 
    @PostMapping("/markStudentAttendance")
    public String markAttendance(@RequestParam("enteredCode") String enteredCode, @RequestParam("eventId") long eventId, Model model) {
        boolean isAttendanceCorrect = eventService.isValidAttendanceCode(eventId, enteredCode);
        model.addAttribute("isAttendanceCorrect_" + eventId, isAttendanceCorrect);
        model.addAttribute("listEvents", eventService.getAllEvents());
        return "redirect:/showAllEvents2";

}
*/

}
