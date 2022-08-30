package com.employees.details.controller;

import com.employees.details.entity.Employee;
import com.employees.details.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeDetailsController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeDetails(@PathVariable("employeeId") Integer employeeId) {
        return new ResponseEntity<>(employeeService.getEmployee(employeeId).get(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.list(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        employeeService.deleteById(employeeId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity deleteEmployee(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
        return new ResponseEntity(HttpStatus.OK);
    }
}
