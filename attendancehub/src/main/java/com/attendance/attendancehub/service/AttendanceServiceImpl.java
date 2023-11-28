/* 

package com.attendance.attendancehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.attendancehub.model.AttendanceRecord;
import com.attendance.attendancehub.repository.AttendanceRecordRepository;


@Service
public class AttendanceServiceImpl implements AttendanceService{

    @Autowired
    private AttendanceRecordRepository attendanceRecordRepository;

    @Autowired
    private String validEventCode = "12345"; // Replace with the actual event code

    public void markAttendance(AttendanceRecord attendanceRecord) {
        attendanceRecordRepository.save(attendanceRecord);
    }

    public List<AttendanceRecord> getAllAttendanceRecords() {
        return attendanceRecordRepository.findAll();
    }

    public boolean isValidEventCode(String enteredCode) {
        return validEventCode.equals(enteredCode);
    }
}

*/

