package com.employees.details.model;

import com.employees.details.entity.EmployeeEntity;

import java.util.Date;

public class Employee {

    private Integer employeeId;

    private String employeeName;

    private String gender;

    private String clientName;

    private String maritalStatus;

    private Date dateOfJoining;

    private Integer yearsInOrg;

    private String department;

    private String performanceManager;

    private String reportingManager;

    public Employee(EmployeeEntity employeeEntity) {
        this.employeeId = employeeEntity.getEmployeeId();
        this.employeeName = employeeEntity.getEmployeeName();
        this.gender = employeeEntity.getGender();
        this.clientName = employeeEntity.getClientName();
        this.maritalStatus = employeeEntity.getMaritalStatus();
        this.dateOfJoining = employeeEntity.getDateOfJoining();
        this.yearsInOrg = employeeEntity.getYearInOrg();
        this.department = employeeEntity.getDepartment();
        this.performanceManager = employeeEntity.getPerformanceManager();
        this.reportingManager = employeeEntity.getReportingManager();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Integer getYearsInOrg() {
        return yearsInOrg;
    }

    public void setYearsInOrg(Integer yearsInOrg) {
        this.yearsInOrg = yearsInOrg;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPerformanceManager() {
        return performanceManager;
    }

    public void setPerformanceManager(String performanceManager) {
        this.performanceManager = performanceManager;
    }

    public String getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(String reportingManager) {
        this.reportingManager = reportingManager;
    }
}
