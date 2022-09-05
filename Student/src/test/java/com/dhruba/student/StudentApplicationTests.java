package com.dhruba.student;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.dhruba.student.entity.Student;
import com.dhruba.student.repository.StudentRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StudentApplicationTests {

@Autowired
    private MockMvc mockMvc;

@Autowired
    private StudentRepository studentRepository;

@BeforeEach
    void setup(){
        studentRepository.deleteAll();
    }

@Test
    public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws Exception{
        // given - precondition or setup
        List<Student> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(new Student(1,"Dhrubajyoti Samui","Male",23,3,"Science"));
        listOfEmployees.add(new Student(2,"Arpan Roy","Male",34,4,"Science"));
        listOfEmployees.add(new Student(3,"Kris Moris","Malee",44,5,"Arts"));
        listOfEmployees.add(new Student(4,"Gurmeet Sing Sidhu","Male",32,1,"Science"));
        listOfEmployees.add(new Student(5,"Imran Khan","Male",32,1,"Commers"));
        listOfEmployees.add(new Student(6,"Trisha Dutta","Female",32,1,"Commers"));
        
        
        
        studentRepository.saveAll(listOfEmployees);
        // when -  action or the behavior that we are going test
        ResultActions response = mockMvc.perform(get("http://localhost:9092/employee"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfEmployees.size())));

    }
}