package com.example.demo.arguments;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArgumentsTest {

    // dependencia (mock)
    @Mock
    EmployeeRepository repository;


    // SUT - System Under Test
    @InjectMocks
    EmployeeServiceImpl service;


    @Test
    void findOneTest() {

        Employee employee1 = new Employee(1L, "Emp1", 30);

//         when(repository.findOne(1L)).thenReturn(employee1);
        when(repository.findOne(anyLong())).thenReturn(employee1);

        Employee employeeResult1 = service.findOne(1L);
        Employee employeeResult2 = service.findOne(999L);

        // aserciones JUnit
        assertNotNull(employeeResult1);
        assertNotNull(employeeResult2);
//        assertEquals(1L, employeeResult.getId());
//        assertEquals("Emp1", employeeResult.getName());

        // verificaciones Mockito

        // times()
        verify(repository).findOne(1L); // 1 vez

    }

    @Test
    void save() {

        Employee employee1 = new Employee(1L, "Emp1", 30);
        when(repository.save(any(Employee.class))).thenReturn(employee1);

        Employee storedEmployee = service.save(employee1);

        assertNotNull(storedEmployee);
        assertEquals(1L, storedEmployee.getId());

        verify(repository).save(any(Employee.class));
        verify(repository).save(employee1);
    }
}
