package com.example.demo.domethods;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeRepositoryImpl;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import com.example.demo.service.IRPFCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DoCallRealMethodTest {

    EmployeeRepository repository;
    EmployeeService service;

    @BeforeEach
    void setUp() {
        repository = mock(EmployeeRepositoryImpl.class); // dependencia simulada (mock)
        service = new EmployeeServiceImpl(repository);
    }

    @Test
    void findOne() {

//        Employee employee1 = new Employee(1L, "Emp1", 30);

        // when(repository.findOne(anyLong())).thenReturn(employee1); // no llama al método real
        // IMPORTANTE: llama únicamente al método real. Quiere decir que lo que hay en el constructor no se ha ejecutado
        // doCallRealMethod().when(repository).findOne(anyLong()); // sí llama al método real

//        Employee employee = service.findOne(1L);
//
//        verify(repository).findOne(1L);
    }

    @Test
    void calculator() {

        IRPFCalculator calculator = mock(IRPFCalculator.class);

//        when(calculator.calculateIRPF(anyDouble())).thenReturn(99.99);

         doCallRealMethod().when(calculator).calculateIRPF(anyDouble());

        calculator.calculateIRPF(99.99); // FIJARSE: imprime el sout que está dentro de ese método por lo que lo
        // ejecuta realmente


    }


}
