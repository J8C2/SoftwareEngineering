package com.attendance.attendancehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.attendance.attendancehub.service.EventService;


@RestController
@RequestMapping("/markattendance")
public class MarkAttendanceController {

    //@Autowired
    //private EventService eventService;

    /* 
    @PostMapping("/{eventId}/{studentId}/{enteredCode}")
    public ResponseEntity<String> markAttendance(
            @PathVariable long eventId,
            @PathVariable long studentId,
            @PathVariable String enteredCode) {

        try {
            eventService.markStudentAttendance(eventId, studentId, enteredCode);
            return ResponseEntity.ok("Attendance marked successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    */
}

