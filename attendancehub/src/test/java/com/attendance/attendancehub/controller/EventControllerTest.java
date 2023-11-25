package com.attendance.attendancehub.controller;

import com.attendance.attendancehub.model.Event;
import com.attendance.attendancehub.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




@ExtendWith(SpringExtension.class)
@WebMvcTest(EventController.class)
class EventControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EventService eventService;
    @Mock
    private EventService eService;

    @InjectMocks
    private EventController eventController;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(eventController).build();
    }

    @Test
    void viewHomePage() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(content().string(containsString("")));
    }

    @Test
    void showNewEventForm() throws Exception {

        Event e1 = new Event(831L,"halloween","2023","candy","8312023");
        when(eventService.getEventById(831L)).thenReturn(e1);

        mvc.perform(get("/showNewEventForm"))
                .andExpect(status().isOk())
                .andExpect(view().name("new_event"))
                .andExpect(model().attributeExists("event"))
                .andExpect(model().attribute("event", instanceOf(Event.class)));

    }

    @Test
    void showAllEvents() throws Exception {
        List<Event> mockEvents = new ArrayList<>();
        Event e1 = new Event(55L, "foodEvent","2023","steak","123");
        Event e2 = new Event(23L, "cakeEvent","2025","cake","567");

        mockEvents.add(e1);
        mockEvents.add(e2);

        when(eventService.getAllEvents()).thenReturn(mockEvents);

        mvc.perform(get("/showAllEvents")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("listEvents"))
                .andExpect(view().name("allEvents"));

//        mvc.perform(get("/showAllEvents"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("allEvents"))
//
//                .andExpect(jsonPath("[0].eventName").value("foodEvent"));
    }

    @Test
    void saveEvent() throws Exception{
        Event e1 = new Event(831L,"halloween","2023","candy","8312023");
        doNothing().when(eService).saveEvent(e1);

        String result = eventController.SaveEvent(e1);
        verify(eService, times(1)).saveEvent(e1);
        assertEquals("redirect:/showAllEvents", result);
    }

//    @Test
//    void showFormForUpdate2() {
//    }

    @Test
    void deleteEvent() throws Exception{
        long eventId = 55L;
        Event e1 = new Event(eventId, "foodEvent", "2023", "steak", "123");
        doNothing().when(eService).deleteEventById(eventId);

        // Perform a GET request to trigger deletion (not recommended)
        //checks for redirects
        mvc.perform(get("/deleteEvent/{id}", eventId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/showAllEvents"));
        //checking to see if functions was calld
        verify(eService, times(1)).deleteEventById(eventId);
    }
}