package com.attendance.attendancehub.controller;

import com.attendance.attendancehub.model.Event;
import com.attendance.attendancehub.model.Student;
import com.attendance.attendancehub.service.EventService;
import com.attendance.attendancehub.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
class StudentControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;
    @Mock
    private StudentService sService;

    @InjectMocks
    private StudentController studentController;

    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    void showNewStudentForm() throws Exception{
        Student s1 = new Student(23L, "Dan", "Smith","Dan@gmail.com");

        Event e1 = new Event(831L,"halloween","2023","candy","8312023");
        when(studentService.getStudentById(23L)).thenReturn(s1);

        mvc.perform(get("/showNewStudentForm"))
                .andExpect(status().isOk())
                .andExpect(view().name("new_Student"))
                .andExpect(model().attributeExists("student"))
                .andExpect(model().attribute("student", instanceOf(Student.class)));

    }

    @Test
    void showAllStudents() throws Exception{
        List<Student> mockStudents = new ArrayList<>();
        Student s1 = new Student(23L, "Dan", "Smith","Dan@gmail.com");
        Student s2 = new Student(23L, "John", "Doe","Johm@gmail.com");

        mockStudents.add(s1);
        mockStudents.add(s2);

        when(studentService.getAllStudents()).thenReturn(mockStudents);


        mvc.perform(get("/showAllStudents"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("listStudents"))
                .andExpect(view().name("allStudents"));;
    }

    @Test
    void saveStudent() throws Exception{
        long studentID = 55L;
        Student s1 = new Student(studentID, "John", "Doe","Johm@gmail.com");
        doNothing().when(sService).saveStudent(s1);

        String result = studentController.SaveStudent(s1);
        verify(sService, times(1)).saveStudent(s1);
        assertEquals("redirect:/showAllStudents", result);
    }

//    @Test
//    void showFormForUpdate() {
//    }

    @Test
    void deleteStudent() throws Exception{
        long studentID = 55L;
        Student s1 = new Student(studentID, "John", "Doe","Johm@gmail.com");
        doNothing().when(studentService).deleteStudentById(studentID);
        mvc.perform(get("/deleteStudent/{id}", studentID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(s1)))
                .andExpect(status().is3xxRedirection());
    }
}