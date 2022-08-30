package com.employees.details.service;

import com.employees.details.entity.EmployeeEntity;
import com.employees.details.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<EmployeeEntity> getEmployee(Integer empId) {
        return employeeRepository.findById(empId);
    }

    public List<EmployeeEntity> list() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity addEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.saveAndFlush(employeeEntity);
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.saveAndFlush(employeeEntity);
    }

    public void deleteEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.delete(employeeEntity);
    }

    public void deleteByEmployeeId(Integer empId) {
        employeeRepository.deleteById(empId);
    }
}
