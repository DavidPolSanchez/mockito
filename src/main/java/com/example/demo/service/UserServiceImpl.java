package com.example.demo.service;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.PersonRepository;

public class UserServiceImpl {

    private EmployeeRepository employeeRepository;
    private PersonRepository personRepository;

    public UserServiceImpl(EmployeeRepository employeeRepository, PersonRepository personRepository) {
        this.employeeRepository = employeeRepository;
        this.personRepository = personRepository;
    }


}
