package com.attendance.attendancehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendance.attendancehub.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    


}


