package com.example.demo.arguments;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomArgumentMatcherTest {

    // dependencia (mock)
    @Mock
    EmployeeRepository repository;


    // SUT - System Under Test
    @InjectMocks
    EmployeeServiceImpl service;

    @Test
    void test1() {

        List<Employee> employees = List.of(
                new Employee(1L, "emp1", 30),
                new Employee(2L, "emp2", 40),
                new Employee(3L, "emp3", 50)
        );
        service.saveAll(employees);

        verify(repository).saveAll(anyList());
        verify(repository).saveAll(employees);
        verify(repository).saveAll(argThat(list -> list.size() == 3));


    }
}
