package com.example.demo.exceptions;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExceptionsTest {

    // dependencia (mock)
    @Mock
    EmployeeRepository repository;


    // SUT - System Under Test
    @InjectMocks
    EmployeeServiceImpl service;

    @Test
    void findOneTest() {

        when(repository.findOne(null)).thenThrow(IllegalArgumentException.class);

        // comprobar con JUnit que se lanza la excepción
        assertThrows(IllegalArgumentException.class, () -> service.findOne(null));

    }

    @Test
    void findOneOptionalNullTest() {

        when(repository.findOne(null)).thenThrow(IllegalArgumentException.class);

        Optional<Employee> employeeOpt = service.findOneOptional(null);

        assertNotNull(employeeOpt);
        assertTrue(employeeOpt.isEmpty());
    }

    @Test
    void findOneOptionalExistTest() {
        Employee employee1 = new Employee(1L, "Emp1", 30);

        when(repository.findOne(1L)).thenReturn(employee1);

        Optional<Employee> employeeOpt = service.findOneOptional(1L);
        assertNotNull(employeeOpt);
        assertTrue(employeeOpt.isPresent());
        Employee employeeDB = employeeOpt.get();
        assertEquals(1L , employeeDB.getId());
    }

    @Test
    void findOneOptionalNotExistTest() {

        when(repository.findOne(anyLong())).thenReturn(null);

        Optional<Employee> employeeOpt = service.findOneOptional(1L);
        assertNotNull(employeeOpt);
        assertTrue(employeeOpt.isEmpty());
    }
}
