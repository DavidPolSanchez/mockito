package com.example.demo.init;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeService1Test {

    // dependencia
    EmployeeRepository repository;

    // SUT - System Under Test
    EmployeeService service;

    @BeforeEach
    void setUp() {
//        repository = new EmployeeRepositoryImpl(); // dependencia real
        repository = mock(EmployeeRepository.class); // dependencia simulada (mock)
        service = new EmployeeServiceImpl(repository);
    }

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
