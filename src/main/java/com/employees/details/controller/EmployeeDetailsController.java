package com.employees.details.controller;

import com.employees.details.exception.ApplicationException;
import com.employees.details.entity.EmployeeDetails;
import com.employees.details.service.EmployeeService;
import com.employees.details.util.JWTAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeDetailsController {

    @Autowired
    private JWTAuthentication jwtAuthentication;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDetails> getEmployeeDetails(@PathVariable("employeeId") Integer employeeId) {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setEmployeeId(employeeId);
        employeeDetails.setEmployeeName("Muyeez Khan");
        if (employeeId == 111) {
            throw new ApplicationException("Application Error.", "Some issue occured suring running the application.");
        }
        if (employeeId == 123) {
            throw new RuntimeException();
        }
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDetails>> getAllEmployees() {
        return new ResponseEntity<List<EmployeeDetails>>(employeeService.list(), HttpStatus.OK);
    }

    @GetMapping("/token")
    public ResponseEntity<String> getToken() {
        return new ResponseEntity<>(jwtAuthentication.getToken(), HttpStatus.OK);
    }
}
