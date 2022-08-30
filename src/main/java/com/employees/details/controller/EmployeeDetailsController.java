package com.employees.details.controller;

import com.employees.details.entity.EmployeeEntity;
import com.employees.details.model.Employee;
import com.employees.details.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeDetailsController {

    @Autowired
    private EmployeeService employeeService;

    //try one change
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeDetails(@PathVariable("employeeId") Integer employeeId) {
        Employee employee = new Employee(employeeService.getEmployee(employeeId).get());
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeService.list().forEach(s -> employeeList.add(new Employee(s)));
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeEntity employeeEntity) {
        Employee employee = new Employee(employeeService.addEmployee(employeeEntity));
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        Employee employee = new Employee(employeeService.updateEmployee(employeeEntity));
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        employeeService.deleteByEmployeeId(employeeId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity deleteEmployee(@RequestBody EmployeeEntity employeeEntity) {
        employeeService.deleteEmployee(employeeEntity);
        return new ResponseEntity(HttpStatus.OK);
    }
}
