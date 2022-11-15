package com.example.demo.order;

import com.example.demo.domain.Employee;
import com.example.demo.service.IRPFCalculator;
import com.example.demo.service.IVACalculator;
import com.example.demo.service.SalaryCalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InvocationOrderTest {

    @Mock
    IRPFCalculator irpfCalculator;
    @Mock
    IVACalculator ivaCalculator;

    // sut
    @InjectMocks
    SalaryCalculatorService service;

    @Test
    @DisplayName("Comprobar el orden de ejecución de los mocks IRPF y IVA")
    void calculateSalaryOrderTest() {
        when(irpfCalculator.calculateIRPF(anyDouble())).thenReturn(0d);
        when(ivaCalculator.calculateIVA(anyDouble())).thenReturn(0d);

        Employee employee = new Employee(null, "emp", 20);
        double salary = service.calculateSalary(employee);

        // assertEquals(0, salary);
        verify(irpfCalculator).calculateIRPF(anyDouble());
        verify(ivaCalculator).calculateIVA(anyDouble());

        InOrder inOrder = inOrder(irpfCalculator, ivaCalculator);
        inOrder.verify(irpfCalculator).calculateIRPF(anyDouble()); // primero
        inOrder.verify(ivaCalculator).calculateIVA(anyDouble()); // segundo
    }
}
