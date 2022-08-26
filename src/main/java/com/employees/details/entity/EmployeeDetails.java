package com.employees.details.entity;

import com.employees.details.util.Gender;
import com.employees.details.util.MaritalStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="EMPLOYEES")
public class EmployeeDetails {
    @Id
    @GeneratedValue
    @Column(name="EMPLOYEE_ID")
    private Integer employeeId;

    @Column(name="EMPLOYEE_NAME")
    private String employeeName;

    @Column(name="GENDER")
    private String gender;

    @Column(name="CLIENT_NAME")
    private String clientName;

    @Column(name="MARITAL_STATUS")
    private String maritalStatus;

    @Column(name="DATE_OF_JOINING")
    private Date dateOfJoining;

    @Column(name="YEARS_IN_ORG")
    private Integer yearsInOrg;

    @Column(name="DEPARTMENT")
    private String department;

    @Column(name="PERFORMANCE_MANAGER")
    private String performanceManager;

    @Column(name="REPORTING_MANAGER")
    private String reportingManager;

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

    public Integer getYearInOrg() {
        return yearsInOrg;
    }

    public void setYearInOrg(Integer yearsInOrg) {
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
