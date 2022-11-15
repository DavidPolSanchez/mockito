package com.example.demo.domethods;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class DoNothingTest {

    // dependencia (mock)
    @Mock
    EmployeeRepository repository;


    // SUT - System Under Test
    @InjectMocks
    EmployeeServiceImpl service;


    @Test
    void doNothingTest() {

        doNothing().when(repository).deleteAll();

        service.deleteAll();

        verify(repository).deleteAll();

    }
}
