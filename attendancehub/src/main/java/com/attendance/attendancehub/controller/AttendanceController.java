/*

package com.attendance.attendancehub.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.attendance.attendancehub.model.AttendanceRecord;
import com.attendance.attendancehub.service.AttendanceService;

@Controller
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // ... existing mappings ...

    @GetMapping("/markAttendance")
    public String showMarkAttendanceForm(Model model) {
        model.addAttribute("attendanceRecord", new AttendanceRecord());
        return "markAttendance";
    }

    @PostMapping("/markAttendance")
    public String markAttendance(@ModelAttribute AttendanceRecord attendanceRecord) {
        // Check if the entered event code is valid
        if ((boolean) attendanceService.isValidEventCode(attendanceRecord.getEventCode())) {
            attendanceRecord.setDate(LocalDate.now());
            attendanceRecord.setPresent(true);
            attendanceService.markAttendance(attendanceRecord);
            return "redirect:/allEvents2"; // Redirect to the student's page
        } else {
            return "redirect:/markAttendance?error=invalid"; // Redirect back with an error message
        }
    }
}

*/

