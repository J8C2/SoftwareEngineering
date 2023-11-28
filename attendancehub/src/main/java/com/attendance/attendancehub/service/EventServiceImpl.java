package com.attendance.attendancehub.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.attendancehub.model.Event;
import com.attendance.attendancehub.model.Student;
import com.attendance.attendancehub.repository.EventRepository;
import com.attendance.attendancehub.repository.StudentRepository;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Event> getAllEvents() {
       
        return eventRepository.findAll();
    }

    @Override
    public void saveEvent(Event event) {
       
       this.eventRepository.save(event);
    }

    @Override
    public Event getEventById(long id) {
        
        Optional<Event> optional = eventRepository.findById(id);
        Event event = null;

        if (optional.isPresent()){
            event = optional.get();
        }

        else {

            throw new RuntimeException("event not found for id :: " + id);
        }
        return event;
    }

    @Override
    public void deleteEventById(long id) {

        this.eventRepository.deleteById(id);
      
    }

    @Override
    public boolean isValidAttendanceCode(long eventId, String enteredCode) {
    Optional<Event> optional = eventRepository.findById(eventId);
    if (optional.isPresent()) {
        Event event = optional.get();
        String validAttendanceCode = event.getEventcode();
        return validAttendanceCode.equals(enteredCode);
    } else {
        throw new RuntimeException("Event not found for id :: " + eventId);
    }
}

@Override
public void markStudentAttendance(long eventId, long studentId, String enteredCode) {
    Optional<Event> optionalEvent = eventRepository.findById(eventId);
    Optional<Student> optionalStudent = studentRepository.findById(studentId);

    if (optionalEvent.isPresent() && optionalStudent.isPresent()) {
        Event event = optionalEvent.get();
        Student student = optionalStudent.get();

        // Assuming your isValidAttendanceCode method is already implemented
        if (isValidAttendanceCode(eventId, enteredCode)) {
            Set<Event> studentEvents = student.getEvents();
            studentEvents.add(event);
            student.setAttendanceStatus(true);
            studentRepository.save(student);
        } else {
            throw new RuntimeException("Invalid attendance code for event id :: " + eventId);
        }
    } else {
        throw new RuntimeException("Event or student not found for given ids");
    }
}

}


    

