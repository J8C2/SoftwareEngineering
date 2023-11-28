package com.attendance.attendancehub.service;

import java.util.List;

import com.attendance.attendancehub.model.Event;

public interface EventService {

    List<Event> getAllEvents();
    void saveEvent(Event event);
    Event getEventById(long id);
    void deleteEventById(long id);
    boolean isValidAttendanceCode(long eventId, String enteredCode);
    void markStudentAttendance(long eventId, long studentId, String enteredCode);


}
