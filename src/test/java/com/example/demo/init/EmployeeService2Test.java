package com.example.demo.init;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeService2Test {

    // dependencia (mock)
    @Mock
    EmployeeRepository repository;


    // SUT - System Under Test
    @InjectMocks
    EmployeeServiceImpl service;


    @Test
    void countTest() {

        // configuración del mock
        when(repository.count()).thenReturn(3);

        // ejecutar el comportamiento a testear
        Integer totalEmployees = service.count();

        // aserciones JUnit + verificaciones Mockito
        assertEquals(3, totalEmployees);
    }
}
