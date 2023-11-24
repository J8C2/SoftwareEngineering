package com.attendance.attendancehub.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(EventController.class)
class EventControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void viewHomePage() throws Exception {
    }

    @Test
    void showNewEventForm() {
    }

    @Test
    void showAllEvents() {
    }

    @Test
    void saveEvent() {
    }

    @Test
    void showFormForUpdate2() {
    }

    @Test
    void deleteEvent() {
    }
}