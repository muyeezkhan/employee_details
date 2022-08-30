package com.employees.details.service;

import com.employees.details.entity.Employee;
import com.employees.details.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployee(Integer empId) {
        return employeeRepository.findById(empId);
    }

    public List<Employee> list() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    public void deleteById(Integer empId) {
        employeeRepository.deleteById(empId);
    }
}
