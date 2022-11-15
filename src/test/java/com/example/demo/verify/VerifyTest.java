package com.example.demo.verify;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VerifyTest {

    // dependencia (mock)
    @Mock
    EmployeeRepository repository;


    // SUT - System Under Test
    @InjectMocks
    EmployeeServiceImpl service;

    @Test
    void findOneTest() {

        Employee employee = new Employee(1L, "Emp1", 30);

        when(repository.findOne(1L))
                .thenReturn(employee);

        Employee employeeResult = service.findOne(1L);

        // aserciones JUnit
        assertNotNull(employeeResult);
        assertEquals(1L, employeeResult.getId());
        assertEquals("Emp1", employeeResult.getName());

        // verificaciones Mockito

        // times()
        verify(repository).findOne(1L); // 1 vez
//      verify(repository, times(1)).findOne(1L); // 1 vez
//      verify(repository, times(2)).findOne(1L); // 2 veces
//      VerificationMode times2 = times(2);
//      verify(repository, times2).findOne(1L); // 2 veces

        // especializaciones
//      verify(repository, never()).count(); // ninguna vez
//      verify(repository, atMost(2)).findOne(1L);
//      verify(repository, atLeast(2)).findOne(1L);

    }
}
