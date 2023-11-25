package com.attendance.attendancehub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Events")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Event_name")
    private String eventName;

    @Column(name = "Event_Date")
    private String eventDate;

    @Column(name = "EventDescription")
    private String eventDescription;

    @Column(name = "EventCode")
    private String eventcode;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventcode() {
        return eventcode;
    }

    public void setEventcode(String eventcode) {
        this.eventcode = eventcode;
    }


}
