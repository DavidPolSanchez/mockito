package com.example.demo.bdd;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

/*
Behavior Driven Development
 */
@ExtendWith(MockitoExtension.class)
public class BDDTest {

    // dependencia (mock)
    @Mock
    EmployeeRepository repository;

    // SUT - System Under Test
    @InjectMocks
    EmployeeServiceImpl service;

    @Test
    void findOneTest() {

        // Given
        Employee employee = new Employee(1L, "Emp1", 30);
        given(repository.findOne(anyLong())).willReturn(employee);

        // When
        Employee employeeResult = service.findOne(1L);

        // Then
        then(repository).should(times(1)).findOne(anyLong());

    }
}
