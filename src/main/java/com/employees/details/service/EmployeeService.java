package com.employees.details.service;

import com.employees.details.entity.EmployeeDetails;
import com.employees.details.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDetails> list() {
        return employeeRepository.findAll();
    }
}
