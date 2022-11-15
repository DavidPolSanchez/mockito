package com.example.demo.init;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.EmployeeServiceImpl;
import com.example.demo.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    // dependencias (mocks)
    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    PersonRepository personRepository;


    // SUT - System Under Test
    @InjectMocks
    UserServiceImpl service;


    @Test
    void countTest() {

        System.out.println("fin");
        // configuración del mock
//        when(repository.count()).thenReturn(3);
//
//        // ejecutar el comportamiento a testear
//        Integer totalEmployees = service.count();
//
//        // aserciones JUnit + verificaciones Mockito
//        assertEquals(3, totalEmployees);
    }
}
